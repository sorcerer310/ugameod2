/*
 * This file is generated by jOOQ.
*/
package com.bsu.ugame.gameparams.jooq.db.tables;


import com.bsu.ugame.gameparams.jooq.db.Gameparams;
import com.bsu.ugame.gameparams.jooq.db.Indexes;
import com.bsu.ugame.gameparams.jooq.db.Keys;
import com.bsu.ugame.gameparams.jooq.db.tables.records.THelpdataRecord;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;
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
public class THelpdata extends TableImpl<THelpdataRecord> {

    private static final long serialVersionUID = 2050749488;

    /**
     * The reference instance of <code>gameparams.t_helpdata</code>
     */
    public static final THelpdata T_HELPDATA = new THelpdata();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<THelpdataRecord> getRecordType() {
        return THelpdataRecord.class;
    }

    /**
     * The column <code>gameparams.t_helpdata.id</code>.
     */
    public final TableField<THelpdataRecord, UInteger> ID = createField("id", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false).identity(true), this, "");

    /**
     * The column <code>gameparams.t_helpdata.gameappid</code>.
     */
    public final TableField<THelpdataRecord, String> GAMEAPPID = createField("gameappid", org.jooq.impl.SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>gameparams.t_helpdata.helptypeid</code>. 互助类型点ID，表示哪个互助功能
     */
    public final TableField<THelpdataRecord, Integer> HELPTYPEID = createField("helptypeid", org.jooq.impl.SQLDataType.INTEGER, this, "互助类型点ID，表示哪个互助功能");

    /**
     * The column <code>gameparams.t_helpdata.requestid</code>. 发起者ID
     */
    public final TableField<THelpdataRecord, String> REQUESTID = createField("requestid", org.jooq.impl.SQLDataType.VARCHAR(50), this, "发起者ID");

    /**
     * The column <code>gameparams.t_helpdata.responseid</code>.
     */
    public final TableField<THelpdataRecord, String> RESPONSEID = createField("responseid", org.jooq.impl.SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>gameparams.t_helpdata.responsenickname</code>. 响应者昵称
     */
    public final TableField<THelpdataRecord, String> RESPONSENICKNAME = createField("responsenickname", org.jooq.impl.SQLDataType.VARCHAR(50), this, "响应者昵称");

    /**
     * The column <code>gameparams.t_helpdata.responsehead</code>. 响应者头像URL
     */
    public final TableField<THelpdataRecord, String> RESPONSEHEAD = createField("responsehead", org.jooq.impl.SQLDataType.VARCHAR(400), this, "响应者头像URL");

    /**
     * The column <code>gameparams.t_helpdata.createtime</code>. 数据生成时间
     */
    public final TableField<THelpdataRecord, Timestamp> CREATETIME = createField("createtime", org.jooq.impl.SQLDataType.TIMESTAMP.defaultValue(org.jooq.impl.DSL.inline("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "数据生成时间");

    /**
     * Create a <code>gameparams.t_helpdata</code> table reference
     */
    public THelpdata() {
        this(DSL.name("t_helpdata"), null);
    }

    /**
     * Create an aliased <code>gameparams.t_helpdata</code> table reference
     */
    public THelpdata(String alias) {
        this(DSL.name(alias), T_HELPDATA);
    }

    /**
     * Create an aliased <code>gameparams.t_helpdata</code> table reference
     */
    public THelpdata(Name alias) {
        this(alias, T_HELPDATA);
    }

    private THelpdata(Name alias, Table<THelpdataRecord> aliased) {
        this(alias, aliased, null);
    }

    private THelpdata(Name alias, Table<THelpdataRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Gameparams.GAMEPARAMS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.T_HELPDATA_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<THelpdataRecord, UInteger> getIdentity() {
        return Keys.IDENTITY_T_HELPDATA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<THelpdataRecord> getPrimaryKey() {
        return Keys.KEY_T_HELPDATA_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<THelpdataRecord>> getKeys() {
        return Arrays.<UniqueKey<THelpdataRecord>>asList(Keys.KEY_T_HELPDATA_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public THelpdata as(String alias) {
        return new THelpdata(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public THelpdata as(Name alias) {
        return new THelpdata(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public THelpdata rename(String name) {
        return new THelpdata(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public THelpdata rename(Name name) {
        return new THelpdata(name, null);
    }
}