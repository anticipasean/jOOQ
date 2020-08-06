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
public class Attributes extends TableImpl<Record> {

    private static final long serialVersionUID = 1641092926;

    /**
     * The reference instance of <code>information_schema.attributes</code>
     */
    public static final Attributes ATTRIBUTES = new Attributes();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<Record> getRecordType() {
        return Record.class;
    }

    /**
     * The column <code>information_schema.attributes.udt_catalog</code>.
     */
    public final TableField<Record, String> UDT_CATALOG = createField(DSL.name("udt_catalog"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>information_schema.attributes.udt_schema</code>.
     */
    public final TableField<Record, String> UDT_SCHEMA = createField(DSL.name("udt_schema"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>information_schema.attributes.udt_name</code>.
     */
    public final TableField<Record, String> UDT_NAME = createField(DSL.name("udt_name"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>information_schema.attributes.attribute_name</code>.
     */
    public final TableField<Record, String> ATTRIBUTE_NAME = createField(DSL.name("attribute_name"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>information_schema.attributes.ordinal_position</code>.
     */
    public final TableField<Record, Integer> ORDINAL_POSITION = createField(DSL.name("ordinal_position"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>information_schema.attributes.attribute_default</code>.
     */
    public final TableField<Record, String> ATTRIBUTE_DEFAULT = createField(DSL.name("attribute_default"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>information_schema.attributes.is_nullable</code>.
     */
    public final TableField<Record, String> IS_NULLABLE = createField(DSL.name("is_nullable"), org.jooq.impl.SQLDataType.VARCHAR(3), this, "");

    /**
     * The column <code>information_schema.attributes.data_type</code>.
     */
    public final TableField<Record, String> DATA_TYPE = createField(DSL.name("data_type"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>information_schema.attributes.character_maximum_length</code>.
     */
    public final TableField<Record, Integer> CHARACTER_MAXIMUM_LENGTH = createField(DSL.name("character_maximum_length"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>information_schema.attributes.character_octet_length</code>.
     */
    public final TableField<Record, Integer> CHARACTER_OCTET_LENGTH = createField(DSL.name("character_octet_length"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>information_schema.attributes.character_set_catalog</code>.
     */
    public final TableField<Record, String> CHARACTER_SET_CATALOG = createField(DSL.name("character_set_catalog"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>information_schema.attributes.character_set_schema</code>.
     */
    public final TableField<Record, String> CHARACTER_SET_SCHEMA = createField(DSL.name("character_set_schema"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>information_schema.attributes.character_set_name</code>.
     */
    public final TableField<Record, String> CHARACTER_SET_NAME = createField(DSL.name("character_set_name"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>information_schema.attributes.collation_catalog</code>.
     */
    public final TableField<Record, String> COLLATION_CATALOG = createField(DSL.name("collation_catalog"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>information_schema.attributes.collation_schema</code>.
     */
    public final TableField<Record, String> COLLATION_SCHEMA = createField(DSL.name("collation_schema"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>information_schema.attributes.collation_name</code>.
     */
    public final TableField<Record, String> COLLATION_NAME = createField(DSL.name("collation_name"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>information_schema.attributes.numeric_precision</code>.
     */
    public final TableField<Record, Integer> NUMERIC_PRECISION = createField(DSL.name("numeric_precision"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>information_schema.attributes.numeric_precision_radix</code>.
     */
    public final TableField<Record, Integer> NUMERIC_PRECISION_RADIX = createField(DSL.name("numeric_precision_radix"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>information_schema.attributes.numeric_scale</code>.
     */
    public final TableField<Record, Integer> NUMERIC_SCALE = createField(DSL.name("numeric_scale"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>information_schema.attributes.datetime_precision</code>.
     */
    public final TableField<Record, Integer> DATETIME_PRECISION = createField(DSL.name("datetime_precision"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>information_schema.attributes.interval_type</code>.
     */
    public final TableField<Record, String> INTERVAL_TYPE = createField(DSL.name("interval_type"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>information_schema.attributes.interval_precision</code>.
     */
    public final TableField<Record, Integer> INTERVAL_PRECISION = createField(DSL.name("interval_precision"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>information_schema.attributes.attribute_udt_catalog</code>.
     */
    public final TableField<Record, String> ATTRIBUTE_UDT_CATALOG = createField(DSL.name("attribute_udt_catalog"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>information_schema.attributes.attribute_udt_schema</code>.
     */
    public final TableField<Record, String> ATTRIBUTE_UDT_SCHEMA = createField(DSL.name("attribute_udt_schema"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>information_schema.attributes.attribute_udt_name</code>.
     */
    public final TableField<Record, String> ATTRIBUTE_UDT_NAME = createField(DSL.name("attribute_udt_name"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>information_schema.attributes.scope_catalog</code>.
     */
    public final TableField<Record, String> SCOPE_CATALOG = createField(DSL.name("scope_catalog"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>information_schema.attributes.scope_schema</code>.
     */
    public final TableField<Record, String> SCOPE_SCHEMA = createField(DSL.name("scope_schema"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>information_schema.attributes.scope_name</code>.
     */
    public final TableField<Record, String> SCOPE_NAME = createField(DSL.name("scope_name"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>information_schema.attributes.maximum_cardinality</code>.
     */
    public final TableField<Record, Integer> MAXIMUM_CARDINALITY = createField(DSL.name("maximum_cardinality"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>information_schema.attributes.dtd_identifier</code>.
     */
    public final TableField<Record, String> DTD_IDENTIFIER = createField(DSL.name("dtd_identifier"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>information_schema.attributes.is_derived_reference_attribute</code>.
     */
    public final TableField<Record, String> IS_DERIVED_REFERENCE_ATTRIBUTE = createField(DSL.name("is_derived_reference_attribute"), org.jooq.impl.SQLDataType.VARCHAR(3), this, "");

    private Attributes(Name alias, Table<Record> aliased) {
        this(alias, aliased, null);
    }

    private Attributes(Name alias, Table<Record> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.view());
    }

    /**
     * Create an aliased <code>information_schema.attributes</code> table reference
     */
    public Attributes(String alias) {
        this(DSL.name(alias), ATTRIBUTES);
    }

    /**
     * Create an aliased <code>information_schema.attributes</code> table reference
     */
    public Attributes(Name alias) {
        this(alias, ATTRIBUTES);
    }

    /**
     * Create a <code>information_schema.attributes</code> table reference
     */
    public Attributes() {
        this(DSL.name("attributes"), null);
    }

    public <O extends Record> Attributes(Table<O> child, ForeignKey<O, Record> key) {
        super(child, key, ATTRIBUTES);
    }

    @Override
    public Schema getSchema() {
        return InformationSchema.INFORMATION_SCHEMA;
    }

    @Override
    public Attributes as(String alias) {
        return new Attributes(DSL.name(alias), this);
    }

    @Override
    public Attributes as(Name alias) {
        return new Attributes(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Attributes rename(String name) {
        return new Attributes(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Attributes rename(Name name) {
        return new Attributes(name, null);
    }
}
