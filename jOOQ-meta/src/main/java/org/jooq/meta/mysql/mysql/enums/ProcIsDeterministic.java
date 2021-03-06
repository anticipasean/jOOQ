/*
 * This file is generated by jOOQ.
 */
package org.jooq.meta.mysql.mysql.enums;


import org.jooq.Catalog;
import org.jooq.EnumType;
import org.jooq.Schema;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public enum ProcIsDeterministic implements EnumType {

    YES("YES"),

    NO("NO");

    private final String literal;

    private ProcIsDeterministic(String literal) {
        this.literal = literal;
    }

    @Override
    public Catalog getCatalog() {
        return null;
    }

    @Override
    public Schema getSchema() {
        return null;
    }

    @Override
    public String getName() {
        return "proc_is_deterministic";
    }

    @Override
    public String getLiteral() {
        return literal;
    }
}
