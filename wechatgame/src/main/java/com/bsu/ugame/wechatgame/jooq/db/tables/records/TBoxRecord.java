/*
 * This file is generated by jOOQ.
*/
package com.bsu.ugame.wechatgame.jooq.db.tables.records;


import com.bsu.ugame.wechatgame.jooq.db.tables.TBox;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;
import org.jooq.types.UInteger;


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
public class TBoxRecord extends UpdatableRecordImpl<TBoxRecord> implements Record3<UInteger, String, String> {

    private static final long serialVersionUID = 626391210;

    /**
     * Setter for <code>login.t_box.id</code>.
     */
    public void setId(UInteger value) {
        set(0, value);
    }

    /**
     * Getter for <code>login.t_box.id</code>.
     */
    public UInteger getId() {
        return (UInteger) get(0);
    }

    /**
     * Setter for <code>login.t_box.boxname</code>. 游戏盒子app名称
     */
    public void setBoxname(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>login.t_box.boxname</code>. 游戏盒子app名称
     */
    public String getBoxname() {
        return (String) get(1);
    }

    /**
     * Setter for <code>login.t_box.boxappid</code>. 渠道盒子程序的appid
     */
    public void setBoxappid(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>login.t_box.boxappid</code>. 渠道盒子程序的appid
     */
    public String getBoxappid() {
        return (String) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<UInteger> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<UInteger, String, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<UInteger, String, String> valuesRow() {
        return (Row3) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<UInteger> field1() {
        return TBox.T_BOX.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return TBox.T_BOX.BOXNAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return TBox.T_BOX.BOXAPPID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UInteger component1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getBoxname();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getBoxappid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UInteger value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getBoxname();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getBoxappid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TBoxRecord value1(UInteger value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TBoxRecord value2(String value) {
        setBoxname(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TBoxRecord value3(String value) {
        setBoxappid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TBoxRecord values(UInteger value1, String value2, String value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TBoxRecord
     */
    public TBoxRecord() {
        super(TBox.T_BOX);
    }

    /**
     * Create a detached, initialised TBoxRecord
     */
    public TBoxRecord(UInteger id, String boxname, String boxappid) {
        super(TBox.T_BOX);

        set(0, id);
        set(1, boxname);
        set(2, boxappid);
    }
}
