/*
 * This file is generated by jOOQ.
*/
package com.bsu.ugame.gameparams.jooq.db.tables.records;


import com.bsu.ugame.gameparams.jooq.db.tables.THelpdata;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record8;
import org.jooq.Row8;
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
public class THelpdataRecord extends UpdatableRecordImpl<THelpdataRecord> implements Record8<UInteger, String, Integer, String, String, String, String, Timestamp> {

    private static final long serialVersionUID = 1701005511;

    /**
     * Setter for <code>gameparams.t_helpdata.id</code>.
     */
    public void setId(UInteger value) {
        set(0, value);
    }

    /**
     * Getter for <code>gameparams.t_helpdata.id</code>.
     */
    public UInteger getId() {
        return (UInteger) get(0);
    }

    /**
     * Setter for <code>gameparams.t_helpdata.gameappid</code>.
     */
    public void setGameappid(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>gameparams.t_helpdata.gameappid</code>.
     */
    public String getGameappid() {
        return (String) get(1);
    }

    /**
     * Setter for <code>gameparams.t_helpdata.helptypeid</code>. 互助类型点ID，表示哪个互助功能
     */
    public void setHelptypeid(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>gameparams.t_helpdata.helptypeid</code>. 互助类型点ID，表示哪个互助功能
     */
    public Integer getHelptypeid() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>gameparams.t_helpdata.requestid</code>. 发起者ID
     */
    public void setRequestid(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>gameparams.t_helpdata.requestid</code>. 发起者ID
     */
    public String getRequestid() {
        return (String) get(3);
    }

    /**
     * Setter for <code>gameparams.t_helpdata.responseid</code>.
     */
    public void setResponseid(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>gameparams.t_helpdata.responseid</code>.
     */
    public String getResponseid() {
        return (String) get(4);
    }

    /**
     * Setter for <code>gameparams.t_helpdata.responsenickname</code>. 响应者昵称
     */
    public void setResponsenickname(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>gameparams.t_helpdata.responsenickname</code>. 响应者昵称
     */
    public String getResponsenickname() {
        return (String) get(5);
    }

    /**
     * Setter for <code>gameparams.t_helpdata.responsehead</code>. 响应者头像URL
     */
    public void setResponsehead(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>gameparams.t_helpdata.responsehead</code>. 响应者头像URL
     */
    public String getResponsehead() {
        return (String) get(6);
    }

    /**
     * Setter for <code>gameparams.t_helpdata.createtime</code>. 数据生成时间
     */
    public void setCreatetime(Timestamp value) {
        set(7, value);
    }

    /**
     * Getter for <code>gameparams.t_helpdata.createtime</code>. 数据生成时间
     */
    public Timestamp getCreatetime() {
        return (Timestamp) get(7);
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
    // Record8 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row8<UInteger, String, Integer, String, String, String, String, Timestamp> fieldsRow() {
        return (Row8) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row8<UInteger, String, Integer, String, String, String, String, Timestamp> valuesRow() {
        return (Row8) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<UInteger> field1() {
        return THelpdata.T_HELPDATA.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return THelpdata.T_HELPDATA.GAMEAPPID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field3() {
        return THelpdata.T_HELPDATA.HELPTYPEID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return THelpdata.T_HELPDATA.REQUESTID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return THelpdata.T_HELPDATA.RESPONSEID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return THelpdata.T_HELPDATA.RESPONSENICKNAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return THelpdata.T_HELPDATA.RESPONSEHEAD;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field8() {
        return THelpdata.T_HELPDATA.CREATETIME;
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
        return getGameappid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component3() {
        return getHelptypeid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getRequestid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getResponseid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component6() {
        return getResponsenickname();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component7() {
        return getResponsehead();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component8() {
        return getCreatetime();
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
        return getGameappid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value3() {
        return getHelptypeid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getRequestid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getResponseid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getResponsenickname();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value7() {
        return getResponsehead();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value8() {
        return getCreatetime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public THelpdataRecord value1(UInteger value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public THelpdataRecord value2(String value) {
        setGameappid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public THelpdataRecord value3(Integer value) {
        setHelptypeid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public THelpdataRecord value4(String value) {
        setRequestid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public THelpdataRecord value5(String value) {
        setResponseid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public THelpdataRecord value6(String value) {
        setResponsenickname(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public THelpdataRecord value7(String value) {
        setResponsehead(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public THelpdataRecord value8(Timestamp value) {
        setCreatetime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public THelpdataRecord values(UInteger value1, String value2, Integer value3, String value4, String value5, String value6, String value7, Timestamp value8) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached THelpdataRecord
     */
    public THelpdataRecord() {
        super(THelpdata.T_HELPDATA);
    }

    /**
     * Create a detached, initialised THelpdataRecord
     */
    public THelpdataRecord(UInteger id, String gameappid, Integer helptypeid, String requestid, String responseid, String responsenickname, String responsehead, Timestamp createtime) {
        super(THelpdata.T_HELPDATA);

        set(0, id);
        set(1, gameappid);
        set(2, helptypeid);
        set(3, requestid);
        set(4, responseid);
        set(5, responsenickname);
        set(6, responsehead);
        set(7, createtime);
    }
}
