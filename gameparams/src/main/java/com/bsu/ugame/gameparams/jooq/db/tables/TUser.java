/*
 * This file is generated by jOOQ.
*/
package com.bsu.ugame.gameparams.jooq.db.tables;


import com.bsu.ugame.gameparams.jooq.db.Gameparams;
import com.bsu.ugame.gameparams.jooq.db.Indexes;
import com.bsu.ugame.gameparams.jooq.db.Keys;
import com.bsu.ugame.gameparams.jooq.db.tables.records.TUserRecord;

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
public class TUser extends TableImpl<TUserRecord> {

    private static final long serialVersionUID = 503397919;

    /**
     * The reference instance of <code>gameparams.t_user</code>
     */
    public static final TUser T_USER = new TUser();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TUserRecord> getRecordType() {
        return TUserRecord.class;
    }

    /**
     * The column <code>gameparams.t_user.id</code>.
     */
    public final TableField<TUserRecord, UInteger> ID = createField("id", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false).identity(true), this, "");

    /**
     * The column <code>gameparams.t_user.name</code>. 用户名
     */
    public final TableField<TUserRecord, String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR(32).nullable(false), this, "用户名");

    /**
     * The column <code>gameparams.t_user.pwd</code>. 用户密码
     */
    public final TableField<TUserRecord, String> PWD = createField("pwd", org.jooq.impl.SQLDataType.VARCHAR(100).nullable(false), this, "用户密码");

    /**
     * The column <code>gameparams.t_user.pwd_salt</code>.
     */
    public final TableField<TUserRecord, String> PWD_SALT = createField("pwd_salt", org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>gameparams.t_user.disable</code>. 用户是否启用，默认启用
     */
    public final TableField<TUserRecord, Boolean> DISABLE = createField("disable", org.jooq.impl.SQLDataType.BIT.nullable(false), this, "用户是否启用，默认启用");

    /**
     * The column <code>gameparams.t_user.regist_time</code>. 注册时间
     */
    public final TableField<TUserRecord, Timestamp> REGIST_TIME = createField("regist_time", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.inline("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "注册时间");

    /**
     * The column <code>gameparams.t_user.last_login_time</code>. 最后登录时间
     */
    public final TableField<TUserRecord, Timestamp> LAST_LOGIN_TIME = createField("last_login_time", org.jooq.impl.SQLDataType.TIMESTAMP, this, "最后登录时间");

    /**
     * The column <code>gameparams.t_user.last_login_ip</code>. 最后登录IP
     */
    public final TableField<TUserRecord, String> LAST_LOGIN_IP = createField("last_login_ip", org.jooq.impl.SQLDataType.VARCHAR(15).nullable(false).defaultValue(org.jooq.impl.DSL.inline("0.0.0.0", org.jooq.impl.SQLDataType.VARCHAR)), this, "最后登录IP");

    /**
     * The column <code>gameparams.t_user.auth</code>. 渠道权限 1:管理员 2:运营商 3:开发商
     */
    public final TableField<TUserRecord, String> AUTH = createField("auth", org.jooq.impl.SQLDataType.VARCHAR(10), this, "渠道权限 1:管理员 2:运营商 3:开发商");

    /**
     * Create a <code>gameparams.t_user</code> table reference
     */
    public TUser() {
        this(DSL.name("t_user"), null);
    }

    /**
     * Create an aliased <code>gameparams.t_user</code> table reference
     */
    public TUser(String alias) {
        this(DSL.name(alias), T_USER);
    }

    /**
     * Create an aliased <code>gameparams.t_user</code> table reference
     */
    public TUser(Name alias) {
        this(alias, T_USER);
    }

    private TUser(Name alias, Table<TUserRecord> aliased) {
        this(alias, aliased, null);
    }

    private TUser(Name alias, Table<TUserRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.T_USER_PRIMARY, Indexes.T_USER_UNI_NAME);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<TUserRecord, UInteger> getIdentity() {
        return Keys.IDENTITY_T_USER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<TUserRecord> getPrimaryKey() {
        return Keys.KEY_T_USER_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<TUserRecord>> getKeys() {
        return Arrays.<UniqueKey<TUserRecord>>asList(Keys.KEY_T_USER_PRIMARY, Keys.KEY_T_USER_UNI_NAME);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TUser as(String alias) {
        return new TUser(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TUser as(Name alias) {
        return new TUser(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public TUser rename(String name) {
        return new TUser(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public TUser rename(Name name) {
        return new TUser(name, null);
    }
}