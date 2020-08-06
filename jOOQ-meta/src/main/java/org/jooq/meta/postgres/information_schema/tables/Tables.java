/*
 * This file is generated by jOOQ.
 */
package org.jooq.meta.postgres.information_schema.tables;


import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;
import org.jooq.meta.postgres.information_schema.InformationSchema;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables extends TableImpl<Record> {

    private static final long serialVersionUID = 1099370467;

    /**
     * The reference instance of <code>information_schema.tables</code>
     */
    public static final Tables TABLES = new Tables();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<Record> getRecordType() {
        return Record.class;
    }

    /**
     * The column <code>information_schema.tables.table_catalog</code>.
     */
    public final TableField<Record, String> TABLE_CATALOG = createField(DSL.name("table_catalog"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>information_schema.tables.table_schema</code>.
     */
    public final TableField<Record, String> TABLE_SCHEMA = createField(DSL.name("table_schema"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>information_schema.tables.table_name</code>.
     */
    public final TableField<Record, String> TABLE_NAME = createField(DSL.name("table_name"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>information_schema.tables.table_type</code>.
     */
    public final TableField<Record, String> TABLE_TYPE = createField(DSL.name("table_type"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>information_schema.tables.self_referencing_column_name</code>.
     */
    public final TableField<Record, String> SELF_REFERENCING_COLUMN_NAME = createField(DSL.name("self_referencing_column_name"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>information_schema.tables.reference_generation</code>.
     */
    public final TableField<Record, String> REFERENCE_GENERATION = createField(DSL.name("reference_generation"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>information_schema.tables.user_defined_type_catalog</code>.
     */
    public final TableField<Record, String> USER_DEFINED_TYPE_CATALOG = createField(DSL.name("user_defined_type_catalog"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>information_schema.tables.user_defined_type_schema</code>.
     */
    public final TableField<Record, String> USER_DEFINED_TYPE_SCHEMA = createField(DSL.name("user_defined_type_schema"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>information_schema.tables.user_defined_type_name</code>.
     */
    public final TableField<Record, String> USER_DEFINED_TYPE_NAME = createField(DSL.name("user_defined_type_name"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>information_schema.tables.is_insertable_into</code>.
     */
    public final TableField<Record, String> IS_INSERTABLE_INTO = createField(DSL.name("is_insertable_into"), org.jooq.impl.SQLDataType.VARCHAR(3), this, "");

    /**
     * The column <code>information_schema.tables.is_typed</code>.
     */
    public final TableField<Record, String> IS_TYPED = createField(DSL.name("is_typed"), org.jooq.impl.SQLDataType.VARCHAR(3), this, "");

    /**
     * The column <code>information_schema.tables.commit_action</code>.
     */
    public final TableField<Record, String> COMMIT_ACTION = createField(DSL.name("commit_action"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    private Tables(Name alias, Table<Record> aliased) {
        this(alias, aliased, null);
    }

    private Tables(Name alias, Table<Record> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.view());
    }

    /**
     * Create an aliased <code>information_schema.tables</code> table reference
     */
    public Tables(String alias) {
        this(DSL.name(alias), TABLES);
    }

    /**
     * Create an aliased <code>information_schema.tables</code> table reference
     */
    public Tables(Name alias) {
        this(alias, TABLES);
    }

    /**
     * Create a <code>information_schema.tables</code> table reference
     */
    public Tables() {
        this(DSL.name("tables"), null);
    }

    public <O extends Record> Tables(Table<O> child, ForeignKey<O, Record> key) {
        super(child, key, TABLES);
    }

    @Override
    public Schema getSchema() {
        return InformationSchema.INFORMATION_SCHEMA;
    }

    @Override
    public Tables as(String alias) {
        return new Tables(DSL.name(alias), this);
    }

    @Override
    public Tables as(Name alias) {
        return new Tables(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Tables rename(String name) {
        return new Tables(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Tables rename(Name name) {
        return new Tables(name, null);
    }
}
