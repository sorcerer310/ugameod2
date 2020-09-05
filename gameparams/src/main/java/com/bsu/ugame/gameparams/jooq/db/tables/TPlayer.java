/*
 * This file is generated by jOOQ.
*/
package com.bsu.ugame.gameparams.jooq.db.tables;


import com.bsu.ugame.gameparams.jooq.db.Gameparams;
import com.bsu.ugame.gameparams.jooq.db.Indexes;
import com.bsu.ugame.gameparams.jooq.db.Keys;
import com.bsu.ugame.gameparams.jooq.db.tables.records.TPlayerRecord;

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
public class TPlayer extends TableImpl<TPlayerRecord> {

    private static final long serialVersionUID = 2068518345;

    /**
     * The reference instance of <code>gameparams.t_player</code>
     */
    public static final TPlayer T_PLAYER = new TPlayer();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TPlayerRecord> getRecordType() {
        return TPlayerRecord.class;
    }

    /**
     * The column <code>gameparams.t_player.id</code>.
     */
    public final TableField<TPlayerRecord, UInteger> ID = createField("id", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false).identity(true), this, "");

    /**
     * The column <code>gameparams.t_player.gameappid</code>. 游戏appid
     */
    public final TableField<TPlayerRecord, String> GAMEAPPID = createField("gameappid", org.jooq.impl.SQLDataType.VARCHAR(50), this, "游戏appid");

    /**
     * The column <code>gameparams.t_player.nickname</code>. 昵称
     */
    public final TableField<TPlayerRecord, String> NICKNAME = createField("nickname", org.jooq.impl.SQLDataType.VARCHAR(50), this, "昵称");

    /**
     * The column <code>gameparams.t_player.avatarurl</code>. 头像url
     */
    public final TableField<TPlayerRecord, String> AVATARURL = createField("avatarurl", org.jooq.impl.SQLDataType.VARCHAR(200), this, "头像url");

    /**
     * The column <code>gameparams.t_player.gender</code>. 性别
     */
    public final TableField<TPlayerRecord, Integer> GENDER = createField("gender", org.jooq.impl.SQLDataType.INTEGER, this, "性别");

    /**
     * The column <code>gameparams.t_player.openid</code>.
     */
    public final TableField<TPlayerRecord, String> OPENID = createField("openid", org.jooq.impl.SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>gameparams.t_player.createtime</code>. 创建时间
     */
    public final TableField<TPlayerRecord, Timestamp> CREATETIME = createField("createtime", org.jooq.impl.SQLDataType.TIMESTAMP, this, "创建时间");

    /**
     * The column <code>gameparams.t_player.lastlogintime</code>. 最后登录时间
     */
    public final TableField<TPlayerRecord, Timestamp> LASTLOGINTIME = createField("lastlogintime", org.jooq.impl.SQLDataType.TIMESTAMP, this, "最后登录时间");

    /**
     * The column <code>gameparams.t_player.signin</code>. 是否签到
     */
    public final TableField<TPlayerRecord, Boolean> SIGNIN = createField("signin", org.jooq.impl.SQLDataType.BIT, this, "是否签到");

    /**
     * The column <code>gameparams.t_player.invite</code>. 邀请新用户数量
     */
    public final TableField<TPlayerRecord, UInteger> INVITE = createField("invite", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.INTEGERUNSIGNED)), this, "邀请新用户数量");

    /**
     * The column <code>gameparams.t_player.videocount</code>. 访问视频次数，上限为10，需要每天清0
     */
    public final TableField<TPlayerRecord, Integer> VIDEOCOUNT = createField("videocount", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.INTEGER)), this, "访问视频次数，上限为10，需要每天清0");

    /**
     * The column <code>gameparams.t_player.gold</code>. 用户金币数
     */
    public final TableField<TPlayerRecord, UInteger> GOLD = createField("gold", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.INTEGERUNSIGNED)), this, "用户金币数");

    /**
     * The column <code>gameparams.t_player.diamond</code>. 钻石数
     */
    public final TableField<TPlayerRecord, UInteger> DIAMOND = createField("diamond", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.INTEGERUNSIGNED)), this, "钻石数");

    /**
     * The column <code>gameparams.t_player.rankingsscore</code>. 排名分数
     */
    public final TableField<TPlayerRecord, Integer> RANKINGSSCORE = createField("rankingsscore", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.INTEGER)), this, "排名分数");

    /**
     * The column <code>gameparams.t_player.province</code>. 省份
     */
    public final TableField<TPlayerRecord, String> PROVINCE = createField("province", org.jooq.impl.SQLDataType.VARCHAR(40), this, "省份");

    /**
     * The column <code>gameparams.t_player.city</code>. 城市
     */
    public final TableField<TPlayerRecord, String> CITY = createField("city", org.jooq.impl.SQLDataType.VARCHAR(40), this, "城市");

    /**
     * The column <code>gameparams.t_player.boxappid</code>. 用户来源渠道appid
     */
    public final TableField<TPlayerRecord, String> BOXAPPID = createField("boxappid", org.jooq.impl.SQLDataType.VARCHAR(50), this, "用户来源渠道appid");

    /**
     * The column <code>gameparams.t_player.currentboxappid</code>. 用户当前的渠道app的id
     */
    public final TableField<TPlayerRecord, String> CURRENTBOXAPPID = createField("currentboxappid", org.jooq.impl.SQLDataType.VARCHAR(50), this, "用户当前的渠道app的id");

    /**
     * Create a <code>gameparams.t_player</code> table reference
     */
    public TPlayer() {
        this(DSL.name("t_player"), null);
    }

    /**
     * Create an aliased <code>gameparams.t_player</code> table reference
     */
    public TPlayer(String alias) {
        this(DSL.name(alias), T_PLAYER);
    }

    /**
     * Create an aliased <code>gameparams.t_player</code> table reference
     */
    public TPlayer(Name alias) {
        this(alias, T_PLAYER);
    }

    private TPlayer(Name alias, Table<TPlayerRecord> aliased) {
        this(alias, aliased, null);
    }

    private TPlayer(Name alias, Table<TPlayerRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.T_PLAYER_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<TPlayerRecord, UInteger> getIdentity() {
        return Keys.IDENTITY_T_PLAYER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<TPlayerRecord> getPrimaryKey() {
        return Keys.KEY_T_PLAYER_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<TPlayerRecord>> getKeys() {
        return Arrays.<UniqueKey<TPlayerRecord>>asList(Keys.KEY_T_PLAYER_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TPlayer as(String alias) {
        return new TPlayer(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TPlayer as(Name alias) {
        return new TPlayer(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public TPlayer rename(String name) {
        return new TPlayer(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public TPlayer rename(Name name) {
        return new TPlayer(name, null);
    }
}
