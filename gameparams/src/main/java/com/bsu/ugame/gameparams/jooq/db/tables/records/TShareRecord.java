/*
 * This file is generated by jOOQ.
*/
package com.bsu.ugame.gameparams.jooq.db.tables.records;


import com.bsu.ugame.gameparams.jooq.db.tables.TShare;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record7;
import org.jooq.Row7;
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
public class TShareRecord extends UpdatableRecordImpl<TShareRecord> implements Record7<UInteger, String, Integer, String, String, Boolean, Integer> {

    private static final long serialVersionUID = 636323088;

    /**
     * Setter for <code>gameparams.t_share.id</code>.
     */
    public void setId(UInteger value) {
        set(0, value);
    }

    /**
     * Getter for <code>gameparams.t_share.id</code>.
     */
    public UInteger getId() {
        return (UInteger) get(0);
    }

    /**
     * Setter for <code>gameparams.t_share.gameappid</code>. 游戏id
     */
    public void setGameappid(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>gameparams.t_share.gameappid</code>. 游戏id
     */
    public String getGameappid() {
        return (String) get(1);
    }

    /**
     * Setter for <code>gameparams.t_share.sharepositionid</code>. 分享点的id，游戏中有若干分享点，不同的id代表不同的分享点
     */
    public void setSharepositionid(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>gameparams.t_share.sharepositionid</code>. 分享点的id，游戏中有若干分享点，不同的id代表不同的分享点
     */
    public Integer getSharepositionid() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>gameparams.t_share.imageurl</code>.
     */
    public void setImageurl(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>gameparams.t_share.imageurl</code>.
     */
    public String getImageurl() {
        return (String) get(3);
    }

    /**
     * Setter for <code>gameparams.t_share.sharecontent</code>.
     */
    public void setSharecontent(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>gameparams.t_share.sharecontent</code>.
     */
    public String getSharecontent() {
        return (String) get(4);
    }

    /**
     * Setter for <code>gameparams.t_share.enabled</code>. 该条数据是否可用
     */
    public void setEnabled(Boolean value) {
        set(5, value);
    }

    /**
     * Getter for <code>gameparams.t_share.enabled</code>. 该条数据是否可用
     */
    public Boolean getEnabled() {
        return (Boolean) get(5);
    }

    /**
     * Setter for <code>gameparams.t_share.shareorder</code>. 排序用，无特殊意义
     */
    public void setShareorder(Integer value) {
        set(6, value);
    }

    /**
     * Getter for <code>gameparams.t_share.shareorder</code>. 排序用，无特殊意义
     */
    public Integer getShareorder() {
        return (Integer) get(6);
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
    // Record7 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row7<UInteger, String, Integer, String, String, Boolean, Integer> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row7<UInteger, String, Integer, String, String, Boolean, Integer> valuesRow() {
        return (Row7) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<UInteger> field1() {
        return TShare.T_SHARE.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return TShare.T_SHARE.GAMEAPPID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field3() {
        return TShare.T_SHARE.SHAREPOSITIONID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return TShare.T_SHARE.IMAGEURL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return TShare.T_SHARE.SHARECONTENT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Boolean> field6() {
        return TShare.T_SHARE.ENABLED;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field7() {
        return TShare.T_SHARE.SHAREORDER;
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
        return getSharepositionid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getImageurl();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getSharecontent();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean component6() {
        return getEnabled();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component7() {
        return getShareorder();
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
        return getSharepositionid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getImageurl();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getSharecontent();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean value6() {
        return getEnabled();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value7() {
        return getShareorder();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TShareRecord value1(UInteger value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TShareRecord value2(String value) {
        setGameappid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TShareRecord value3(Integer value) {
        setSharepositionid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TShareRecord value4(String value) {
        setImageurl(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TShareRecord value5(String value) {
        setSharecontent(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TShareRecord value6(Boolean value) {
        setEnabled(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TShareRecord value7(Integer value) {
        setShareorder(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TShareRecord values(UInteger value1, String value2, Integer value3, String value4, String value5, Boolean value6, Integer value7) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TShareRecord
     */
    public TShareRecord() {
        super(TShare.T_SHARE);
    }

    /**
     * Create a detached, initialised TShareRecord
     */
    public TShareRecord(UInteger id, String gameappid, Integer sharepositionid, String imageurl, String sharecontent, Boolean enabled, Integer shareorder) {
        super(TShare.T_SHARE);

        set(0, id);
        set(1, gameappid);
        set(2, sharepositionid);
        set(3, imageurl);
        set(4, sharecontent);
        set(5, enabled);
        set(6, shareorder);
    }
}