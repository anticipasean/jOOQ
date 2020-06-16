/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Other licenses:
 * -----------------------------------------------------------------------------
 * Commercial licenses for this work are available. These replace the above
 * ASL 2.0 and offer limited warranties, support, maintenance, and commercial
 * database integrations.
 *
 * For more information, please visit: http://www.jooq.org/licenses
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
package org.jooq.impl;

import static org.jooq.impl.Tools.EMPTY_CHECK;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.jooq.Catalog;
import org.jooq.Check;
import org.jooq.Domain;
import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Meta;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Sequence;
import org.jooq.SortField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UDT;
import org.jooq.UDTRecord;
import org.jooq.UniqueKey;
import org.jooq.exception.DataAccessException;

/**
 * An implementation of {@code Meta} which can be used to create fully
 * self-contained copies of other {@code Meta} objects.
 *
 * @author Knut Wannheden
 */
final class DetachedMeta extends AbstractMeta {

    private static final long serialVersionUID = 5561057000510740144L;
    private Meta              delegate;

    DetachedMeta(Meta meta) {
        super(meta.configuration());

        delegate = meta;
        getCatalogs();
        delegate = null;
        resolveReferences();
    }

    private final void resolveReferences() {
        for (Catalog catalog : getCatalogs())
            ((DetachedCatalog) catalog).resolveReferences();
    }

    @Override
    final List<Catalog> getCatalogs0() throws DataAccessException {
        List<Catalog> result = new ArrayList<>();

        for (Catalog catalog : delegate.getCatalogs())
            result.add(new DetachedCatalog(catalog));

        return result;
    }

    private class DetachedCatalog extends CatalogImpl {
        private static final long          serialVersionUID = 7979890261252183486L;
        private final List<DetachedSchema> schemas;

        DetachedCatalog(Catalog catalog) {
            super(catalog.getQualifiedName(), catalog.getCommentPart());

            schemas = new ArrayList<>();

            for (Schema schema : catalog.getSchemas())
                schemas.add(new DetachedSchema(this, schema));
        }

        private final void resolveReferences() {
            for (DetachedSchema schema : schemas)
                schema.resolveReferences();
        }

        @Override
        public final List<Schema> getSchemas() {
            return Collections.unmodifiableList(schemas);
        }
    }

    private class DetachedSchema extends SchemaImpl {
        private static final long               serialVersionUID = -95755926444275258L;

        private final List<DetachedDomain<?>>   domains;
        private final List<DetachedTable<?>>    tables;
        private final List<DetachedSequence<?>> sequences;
        private final List<DetachedUDT<?>>      udts;

        DetachedSchema(DetachedCatalog catalog, Schema schema) {
            super(schema.getQualifiedName(), catalog, schema.getCommentPart());

            domains = new ArrayList<>();
            tables = new ArrayList<>();
            sequences = new ArrayList<>();
            udts = new ArrayList<>();

            for (Domain<?> domain : schema.getDomains())
                domains.add(new DetachedDomain<>(this, domain));
            for (Table<?> table : schema.getTables())
                tables.add(new DetachedTable<>(this, table));
            for (Sequence<?> sequence : schema.getSequences())
                sequences.add(new DetachedSequence<>(this, sequence));
            for (UDT<?> udt : schema.getUDTs())
                udts.add(new DetachedUDT<>(this, udt));
        }

        final void resolveReferences() {
            for (DetachedTable<?> table : tables)
                table.resolveReferences();
        }

        @Override
        public final List<Domain<?>> getDomains() {
            return Collections.unmodifiableList(domains);
        }

        @Override
        public final List<Table<?>> getTables() {
            return Collections.unmodifiableList(tables);
        }

        @Override
        public final List<Sequence<?>> getSequences() {
            return Collections.unmodifiableList(sequences);
        }

        @Override
        public final List<UDT<?>> getUDTs() {
            return Collections.unmodifiableList(udts);
        }
    }

    private class DetachedDomain<T> extends DomainImpl<T> {
        private static final long serialVersionUID = -1607062195966296849L;

        DetachedDomain(DetachedSchema schema, Domain<T> domain) {
            super(schema, domain.getQualifiedName(), domain.getDataType(), domain.getChecks().toArray(EMPTY_CHECK));
        }
    }

    private class DetachedTable<R extends Record> extends TableImpl<R> {
        private static final long serialVersionUID = -6070726881709997500L;

        private final List<Index>            indexes;
        private final List<UniqueKey<R>>     uniqueKeys;
        private UniqueKey<R>                 primaryKey;
        private final List<ForeignKey<R, ?>> foreignKeys;
        private final List<Check<R>>         checks;
        private Identity<R, ?>               identity;

        DetachedTable(DetachedSchema schema, Table<R> table) {
            super(table.getQualifiedName(), schema, null, null, table.getCommentPart(), table.getOptions());

            indexes = new ArrayList<>();
            uniqueKeys = new ArrayList<>();
            foreignKeys = new ArrayList<>();
            checks = new ArrayList<>();

            for (Field<?> field : table.fields()) {
                TableField<R, ?> f = DetachedTable.createField(field.getUnqualifiedName(), field.getDataType(), this, field.getComment());

                if (field.getDataType().identity() && identity == null)
                    identity = Internal.createIdentity(this, f);
            }

            for (Index index : table.getIndexes()) {
                List<SortField<?>> indexFields = index.getFields();
                SortField<?>[] copiedFields = new SortField[indexFields.size()];

                for (int i = 0; i < indexFields.size(); i++) {
                    SortField<?> field = indexFields.get(i);
                    copiedFields[i] = field(field.getName()).sort(field.getOrder());
                    // [#9009] TODO NULLS FIRST / NULLS LAST
                }

                indexes.add(Internal.createIndex(index.getQualifiedName(), this, copiedFields, index.getUnique()));
            }

            for (UniqueKey<R> uk : table.getKeys())
                uniqueKeys.add(Internal.createUniqueKey(this, uk.getQualifiedName(), fields(uk.getFieldsArray()), uk.enforced()));

            UniqueKey<R> pk = table.getPrimaryKey();
            for (UniqueKey<R> uk : uniqueKeys)
                if (uk.equals(pk))
                    primaryKey = uk;

            foreignKeys.addAll(table.getReferences());
            checks.addAll(table.getChecks());
        }

        @SuppressWarnings("unchecked")
        @Deprecated
        private final TableField<R, ?>[] fields(TableField<R, ?>[] tableFields) {

            // TODO: [#9456] This auxiliary method should not be necessary
            //               We should be able to call TableLike.fields instead.
            TableField<R, ?>[] result = new TableField[tableFields.length];

            for (int i = 0; i < tableFields.length; i++)
                result[i] = (TableField<R, ?>) field(tableFields[i].getName());

            return result;
        }

        final void resolveReferences() {

            // TODO: Is there a better way than temporarily keeping the wrong
            //       ReferenceImpl in this list until we "know better"?
            for (int i = 0; i < foreignKeys.size(); i++) {
                ForeignKey<R, ?> fk = foreignKeys.get(i);

                foreignKeys.set(i, org.jooq.impl.Internal.createForeignKey(
                    lookupUniqueKey(fk),
                    this,
                    fk.getQualifiedName(),
                    fields(fk.getFieldsArray()),
                    fk.enforced())
                );
            }
        }

        @Override
        public final List<Index> getIndexes() {
            return Collections.unmodifiableList(indexes);
        }

        @Override
        public final List<UniqueKey<R>> getKeys() {
            return Collections.unmodifiableList(uniqueKeys);
        }

        @Override
        public final UniqueKey<R> getPrimaryKey() {
            return primaryKey;
        }

        @Override
        public final List<ForeignKey<R, ?>> getReferences() {
            return Collections.unmodifiableList(foreignKeys);
        }

        @Override
        public final List<Check<R>> getChecks() {
            return Collections.unmodifiableList(checks);
        }

        @Override
        public final Identity<R, ?> getIdentity() {
            return identity;
        }
    }

    private class DetachedSequence<T extends Number> extends SequenceImpl<T> {
        private static final long serialVersionUID = -1607062195966296849L;

        DetachedSequence(DetachedSchema schema, Sequence<T> sequence) {
            super(
                sequence.getQualifiedName(),
                schema,
                sequence.getDataType(),
                false,
                sequence.getStartWith(),
                sequence.getIncrementBy(),
                sequence.getMinvalue(),
                sequence.getMaxvalue(),
                sequence.getCycle(),
                sequence.getCache()
            );
        }
    }

    private class DetachedUDT<R extends UDTRecord<R>> extends UDTImpl<R> {
        private static final long serialVersionUID = -5732449514562314202L;

        DetachedUDT(DetachedSchema schema, UDT<R> udt) {
            super(udt.getName(), schema, udt.getPackage(), udt.isSynthetic());
        }
    }
}