/*
 * This file is generated by jOOQ.
*/
package com.bsu.ugame.wechatgame.jooq.db.tables;


import com.bsu.ugame.wechatgame.jooq.db.Indexes;
import com.bsu.ugame.wechatgame.jooq.db.Keys;
import com.bsu.ugame.wechatgame.jooq.db.Login;
import com.bsu.ugame.wechatgame.jooq.db.tables.records.TBoxRecord;

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
public class TBox extends TableImpl<TBoxRecord> {

    private static final long serialVersionUID = -167660597;

    /**
     * The reference instance of <code>login.t_box</code>
     */
    public static final TBox T_BOX = new TBox();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TBoxRecord> getRecordType() {
        return TBoxRecord.class;
    }

    /**
     * The column <code>login.t_box.id</code>.
     */
    public final TableField<TBoxRecord, UInteger> ID = createField("id", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false).identity(true), this, "");

    /**
     * The column <code>login.t_box.boxname</code>. 游戏盒子app名称
     */
    public final TableField<TBoxRecord, String> BOXNAME = createField("boxname", org.jooq.impl.SQLDataType.VARCHAR(32).defaultValue(org.jooq.impl.DSL.inline("未登记来源", org.jooq.impl.SQLDataType.VARCHAR)), this, "游戏盒子app名称");

    /**
     * The column <code>login.t_box.boxappid</code>. 渠道盒子程序的appid
     */
    public final TableField<TBoxRecord, String> BOXAPPID = createField("boxappid", org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "渠道盒子程序的appid");

    /**
     * Create a <code>login.t_box</code> table reference
     */
    public TBox() {
        this(DSL.name("t_box"), null);
    }

    /**
     * Create an aliased <code>login.t_box</code> table reference
     */
    public TBox(String alias) {
        this(DSL.name(alias), T_BOX);
    }

    /**
     * Create an aliased <code>login.t_box</code> table reference
     */
    public TBox(Name alias) {
        this(alias, T_BOX);
    }

    private TBox(Name alias, Table<TBoxRecord> aliased) {
        this(alias, aliased, null);
    }

    private TBox(Name alias, Table<TBoxRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Login.LOGIN;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.T_BOX_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<TBoxRecord, UInteger> getIdentity() {
        return Keys.IDENTITY_T_BOX;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<TBoxRecord> getPrimaryKey() {
        return Keys.KEY_T_BOX_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<TBoxRecord>> getKeys() {
        return Arrays.<UniqueKey<TBoxRecord>>asList(Keys.KEY_T_BOX_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TBox as(String alias) {
        return new TBox(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TBox as(Name alias) {
        return new TBox(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public TBox rename(String name) {
        return new TBox(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public TBox rename(Name name) {
        return new TBox(name, null);
    }
}
