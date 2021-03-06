/*
 * This file is generated by jOOQ.
*/
package com.bsu.ugame.wechatgame.jooq.db.tables;


import com.bsu.ugame.wechatgame.jooq.db.Indexes;
import com.bsu.ugame.wechatgame.jooq.db.Keys;
import com.bsu.ugame.wechatgame.jooq.db.Login;
import com.bsu.ugame.wechatgame.jooq.db.tables.records.TDailydataRecord;

import java.math.BigDecimal;
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
public class TDailydata extends TableImpl<TDailydataRecord> {

    private static final long serialVersionUID = -1368557118;

    /**
     * The reference instance of <code>login.t_dailydata</code>
     */
    public static final TDailydata T_DAILYDATA = new TDailydata();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TDailydataRecord> getRecordType() {
        return TDailydataRecord.class;
    }

    /**
     * The column <code>login.t_dailydata.id</code>.
     */
    public final TableField<TDailydataRecord, UInteger> ID = createField("id", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false).identity(true), this, "");

    /**
     * The column <code>login.t_dailydata.boxappid</code>.
     */
    public final TableField<TDailydataRecord, String> BOXAPPID = createField("boxappid", org.jooq.impl.SQLDataType.VARCHAR(50).nullable(false), this, "");

    /**
     * The column <code>login.t_dailydata.usernum</code>.
     */
    public final TableField<TDailydataRecord, Integer> USERNUM = createField("usernum", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>login.t_dailydata.gameappid</code>.
     */
    public final TableField<TDailydataRecord, String> GAMEAPPID = createField("gameappid", org.jooq.impl.SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>login.t_dailydata.createTime</code>.
     */
    public final TableField<TDailydataRecord, Timestamp> CREATETIME = createField("createTime", org.jooq.impl.SQLDataType.TIMESTAMP.defaultValue(org.jooq.impl.DSL.inline("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "");

    /**
     * The column <code>login.t_dailydata.activeUserNum</code>. 用户每日活跃数，统计数量为t_playergame中lastLoginTime为昨日的数量
     */
    public final TableField<TDailydataRecord, Integer> ACTIVEUSERNUM = createField("activeUserNum", org.jooq.impl.SQLDataType.INTEGER.defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.INTEGER)), this, "用户每日活跃数，统计数量为t_playergame中lastLoginTime为昨日的数量");

    /**
     * The column <code>login.t_dailydata.nextDayLeft</code>. 截止到今天，次日新增用户留存的数量(暂不使用)
     */
    public final TableField<TDailydataRecord, Integer> NEXTDAYLEFT = createField("nextDayLeft", org.jooq.impl.SQLDataType.INTEGER.defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.INTEGER)), this, "截止到今天，次日新增用户留存的数量(暂不使用)");

    /**
     * The column <code>login.t_dailydata.threeDaysLeft</code>. 截止到今天，3日前新增用户留存的数量(暂不使用)
     */
    public final TableField<TDailydataRecord, Integer> THREEDAYSLEFT = createField("threeDaysLeft", org.jooq.impl.SQLDataType.INTEGER.defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.INTEGER)), this, "截止到今天，3日前新增用户留存的数量(暂不使用)");

    /**
     * The column <code>login.t_dailydata.sevenDaysLeft</code>. 截止到今天，七日前新增用户留存的数量(暂不使用)
     */
    public final TableField<TDailydataRecord, Integer> SEVENDAYSLEFT = createField("sevenDaysLeft", org.jooq.impl.SQLDataType.INTEGER.defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.INTEGER)), this, "截止到今天，七日前新增用户留存的数量(暂不使用)");

    /**
     * The column <code>login.t_dailydata.nextDayLeftRate</code>. 以当前createTime新增为准，次日留存率
     */
    public final TableField<TDailydataRecord, BigDecimal> NEXTDAYLEFTRATE = createField("nextDayLeftRate", org.jooq.impl.SQLDataType.DECIMAL(10, 2).defaultValue(org.jooq.impl.DSL.inline("0.00", org.jooq.impl.SQLDataType.DECIMAL)), this, "以当前createTime新增为准，次日留存率");

    /**
     * The column <code>login.t_dailydata.threeDaysLeftRate</code>. 以当前createTime新增为准，3日留存率
     */
    public final TableField<TDailydataRecord, BigDecimal> THREEDAYSLEFTRATE = createField("threeDaysLeftRate", org.jooq.impl.SQLDataType.DECIMAL(10, 2).defaultValue(org.jooq.impl.DSL.inline("0.00", org.jooq.impl.SQLDataType.DECIMAL)), this, "以当前createTime新增为准，3日留存率");

    /**
     * The column <code>login.t_dailydata.sevenDaysLeftRate</code>. 以当前createTime新增为准，7日留存率
     */
    public final TableField<TDailydataRecord, BigDecimal> SEVENDAYSLEFTRATE = createField("sevenDaysLeftRate", org.jooq.impl.SQLDataType.DECIMAL(10, 2).defaultValue(org.jooq.impl.DSL.inline("0.00", org.jooq.impl.SQLDataType.DECIMAL)), this, "以当前createTime新增为准，7日留存率");

    /**
     * Create a <code>login.t_dailydata</code> table reference
     */
    public TDailydata() {
        this(DSL.name("t_dailydata"), null);
    }

    /**
     * Create an aliased <code>login.t_dailydata</code> table reference
     */
    public TDailydata(String alias) {
        this(DSL.name(alias), T_DAILYDATA);
    }

    /**
     * Create an aliased <code>login.t_dailydata</code> table reference
     */
    public TDailydata(Name alias) {
        this(alias, T_DAILYDATA);
    }

    private TDailydata(Name alias, Table<TDailydataRecord> aliased) {
        this(alias, aliased, null);
    }

    private TDailydata(Name alias, Table<TDailydataRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.T_DAILYDATA_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<TDailydataRecord, UInteger> getIdentity() {
        return Keys.IDENTITY_T_DAILYDATA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<TDailydataRecord> getPrimaryKey() {
        return Keys.KEY_T_DAILYDATA_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<TDailydataRecord>> getKeys() {
        return Arrays.<UniqueKey<TDailydataRecord>>asList(Keys.KEY_T_DAILYDATA_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TDailydata as(String alias) {
        return new TDailydata(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TDailydata as(Name alias) {
        return new TDailydata(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public TDailydata rename(String name) {
        return new TDailydata(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public TDailydata rename(Name name) {
        return new TDailydata(name, null);
    }
}
