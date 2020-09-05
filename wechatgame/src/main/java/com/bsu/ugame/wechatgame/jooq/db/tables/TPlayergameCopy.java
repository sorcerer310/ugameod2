/*
 * This file is generated by jOOQ.
*/
package com.bsu.ugame.wechatgame.jooq.db.tables;


import com.bsu.ugame.wechatgame.jooq.db.Indexes;
import com.bsu.ugame.wechatgame.jooq.db.Keys;
import com.bsu.ugame.wechatgame.jooq.db.Login;
import com.bsu.ugame.wechatgame.jooq.db.tables.records.TPlayergameCopyRecord;

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
 * 玩家玩游戏产生的跟踪数据
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.0"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TPlayergameCopy extends TableImpl<TPlayergameCopyRecord> {

    private static final long serialVersionUID = -2038420485;

    /**
     * The reference instance of <code>login.t_playergame_copy</code>
     */
    public static final TPlayergameCopy T_PLAYERGAME_COPY = new TPlayergameCopy();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TPlayergameCopyRecord> getRecordType() {
        return TPlayergameCopyRecord.class;
    }

    /**
     * The column <code>login.t_playergame_copy.id</code>.
     */
    public final TableField<TPlayergameCopyRecord, UInteger> ID = createField("id", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false).identity(true), this, "");

    /**
     * The column <code>login.t_playergame_copy.gameappid</code>.
     */
    public final TableField<TPlayergameCopyRecord, String> GAMEAPPID = createField("gameappid", org.jooq.impl.SQLDataType.VARCHAR(50).nullable(false), this, "");

    /**
     * The column <code>login.t_playergame_copy.recommendUser</code>. 记录玩家的推荐人openid
     */
    public final TableField<TPlayergameCopyRecord, String> RECOMMENDUSER = createField("recommendUser", org.jooq.impl.SQLDataType.VARCHAR(50), this, "记录玩家的推荐人openid");

    /**
     * The column <code>login.t_playergame_copy.openid</code>. 用户openid
     */
    public final TableField<TPlayergameCopyRecord, String> OPENID = createField("openid", org.jooq.impl.SQLDataType.VARCHAR(50).nullable(false), this, "用户openid");

    /**
     * The column <code>login.t_playergame_copy.boxappid</code>. 游戏来源渠道appid
     */
    public final TableField<TPlayergameCopyRecord, String> BOXAPPID = createField("boxappid", org.jooq.impl.SQLDataType.VARCHAR(50).nullable(false), this, "游戏来源渠道appid");

    /**
     * The column <code>login.t_playergame_copy.currboxappid</code>. 当前的来源box的appid
     */
    public final TableField<TPlayergameCopyRecord, String> CURRBOXAPPID = createField("currboxappid", org.jooq.impl.SQLDataType.VARCHAR(50), this, "当前的来源box的appid");

    /**
     * The column <code>login.t_playergame_copy.nickname</code>.
     */
    public final TableField<TPlayergameCopyRecord, String> NICKNAME = createField("nickname", org.jooq.impl.SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>login.t_playergame_copy.gender</code>. 性别
     */
    public final TableField<TPlayergameCopyRecord, Integer> GENDER = createField("gender", org.jooq.impl.SQLDataType.INTEGER, this, "性别");

    /**
     * The column <code>login.t_playergame_copy.country</code>.
     */
    public final TableField<TPlayergameCopyRecord, String> COUNTRY = createField("country", org.jooq.impl.SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>login.t_playergame_copy.city</code>. 城市
     */
    public final TableField<TPlayergameCopyRecord, String> CITY = createField("city", org.jooq.impl.SQLDataType.VARCHAR(20), this, "城市");

    /**
     * The column <code>login.t_playergame_copy.province</code>. 省份
     */
    public final TableField<TPlayergameCopyRecord, String> PROVINCE = createField("province", org.jooq.impl.SQLDataType.VARCHAR(40), this, "省份");

    /**
     * The column <code>login.t_playergame_copy.language</code>. 语言
     */
    public final TableField<TPlayergameCopyRecord, String> LANGUAGE = createField("language", org.jooq.impl.SQLDataType.VARCHAR(10), this, "语言");

    /**
     * The column <code>login.t_playergame_copy.createTime</code>. 创建时间
     */
    public final TableField<TPlayergameCopyRecord, Timestamp> CREATETIME = createField("createTime", org.jooq.impl.SQLDataType.TIMESTAMP.defaultValue(org.jooq.impl.DSL.inline("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "创建时间");

    /**
     * The column <code>login.t_playergame_copy.lastLoginTime</code>. 玩家最后一次登录游戏时间
     */
    public final TableField<TPlayergameCopyRecord, Timestamp> LASTLOGINTIME = createField("lastLoginTime", org.jooq.impl.SQLDataType.TIMESTAMP.defaultValue(org.jooq.impl.DSL.inline("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "玩家最后一次登录游戏时间");

    /**
     * Create a <code>login.t_playergame_copy</code> table reference
     */
    public TPlayergameCopy() {
        this(DSL.name("t_playergame_copy"), null);
    }

    /**
     * Create an aliased <code>login.t_playergame_copy</code> table reference
     */
    public TPlayergameCopy(String alias) {
        this(DSL.name(alias), T_PLAYERGAME_COPY);
    }

    /**
     * Create an aliased <code>login.t_playergame_copy</code> table reference
     */
    public TPlayergameCopy(Name alias) {
        this(alias, T_PLAYERGAME_COPY);
    }

    private TPlayergameCopy(Name alias, Table<TPlayergameCopyRecord> aliased) {
        this(alias, aliased, null);
    }

    private TPlayergameCopy(Name alias, Table<TPlayergameCopyRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "玩家玩游戏产生的跟踪数据");
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
        return Arrays.<Index>asList(Indexes.T_PLAYERGAME_COPY_IDX_BOXAPPID, Indexes.T_PLAYERGAME_COPY_IDX_GAMEAPPID, Indexes.T_PLAYERGAME_COPY_PRIMARY, Indexes.T_PLAYERGAME_COPY_UNI_OPENID_GAMEAPPID_BOXAPPID);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<TPlayergameCopyRecord, UInteger> getIdentity() {
        return Keys.IDENTITY_T_PLAYERGAME_COPY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<TPlayergameCopyRecord> getPrimaryKey() {
        return Keys.KEY_T_PLAYERGAME_COPY_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<TPlayergameCopyRecord>> getKeys() {
        return Arrays.<UniqueKey<TPlayergameCopyRecord>>asList(Keys.KEY_T_PLAYERGAME_COPY_PRIMARY, Keys.KEY_T_PLAYERGAME_COPY_UNI_OPENID_GAMEAPPID_BOXAPPID);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TPlayergameCopy as(String alias) {
        return new TPlayergameCopy(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TPlayergameCopy as(Name alias) {
        return new TPlayergameCopy(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public TPlayergameCopy rename(String name) {
        return new TPlayergameCopy(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public TPlayergameCopy rename(Name name) {
        return new TPlayergameCopy(name, null);
    }
}
