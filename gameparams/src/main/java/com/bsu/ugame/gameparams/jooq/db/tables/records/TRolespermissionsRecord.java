/*
 * This file is generated by jOOQ.
*/
package com.bsu.ugame.gameparams.jooq.db.tables.records;


import com.bsu.ugame.gameparams.jooq.db.tables.TRolespermissions;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.0"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TRolespermissionsRecord extends UpdatableRecordImpl<TRolespermissionsRecord> implements Record3<Long, String, String> {

    private static final long serialVersionUID = -627122059;

    /**
     * Setter for <code>gameparams.t_rolespermissions.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>gameparams.t_rolespermissions.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>gameparams.t_rolespermissions.role_name</code>.
     */
    public void setRoleName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>gameparams.t_rolespermissions.role_name</code>.
     */
    public String getRoleName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>gameparams.t_rolespermissions.permission</code>.
     */
    public void setPermission(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>gameparams.t_rolespermissions.permission</code>.
     */
    public String getPermission() {
        return (String) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Long, String, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Long, String, String> valuesRow() {
        return (Row3) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return TRolespermissions.T_ROLESPERMISSIONS.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return TRolespermissions.T_ROLESPERMISSIONS.ROLE_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return TRolespermissions.T_ROLESPERMISSIONS.PERMISSION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getRoleName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getPermission();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getRoleName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getPermission();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TRolespermissionsRecord value1(Long value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TRolespermissionsRecord value2(String value) {
        setRoleName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TRolespermissionsRecord value3(String value) {
        setPermission(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TRolespermissionsRecord values(Long value1, String value2, String value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TRolespermissionsRecord
     */
    public TRolespermissionsRecord() {
        super(TRolespermissions.T_ROLESPERMISSIONS);
    }

    /**
     * Create a detached, initialised TRolespermissionsRecord
     */
    public TRolespermissionsRecord(Long id, String roleName, String permission) {
        super(TRolespermissions.T_ROLESPERMISSIONS);

        set(0, id);
        set(1, roleName);
        set(2, permission);
    }
}
