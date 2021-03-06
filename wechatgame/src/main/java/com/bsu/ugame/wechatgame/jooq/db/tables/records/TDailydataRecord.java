/*
 * This file is generated by jOOQ.
*/
package com.bsu.ugame.wechatgame.jooq.db.tables.records;


import com.bsu.ugame.wechatgame.jooq.db.tables.TDailydata;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record12;
import org.jooq.Row12;
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
public class TDailydataRecord extends UpdatableRecordImpl<TDailydataRecord> implements Record12<UInteger, String, Integer, String, Timestamp, Integer, Integer, Integer, Integer, BigDecimal, BigDecimal, BigDecimal> {

    private static final long serialVersionUID = 1907801983;

    /**
     * Setter for <code>login.t_dailydata.id</code>.
     */
    public void setId(UInteger value) {
        set(0, value);
    }

    /**
     * Getter for <code>login.t_dailydata.id</code>.
     */
    public UInteger getId() {
        return (UInteger) get(0);
    }

    /**
     * Setter for <code>login.t_dailydata.boxappid</code>.
     */
    public void setBoxappid(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>login.t_dailydata.boxappid</code>.
     */
    public String getBoxappid() {
        return (String) get(1);
    }

    /**
     * Setter for <code>login.t_dailydata.usernum</code>.
     */
    public void setUsernum(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>login.t_dailydata.usernum</code>.
     */
    public Integer getUsernum() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>login.t_dailydata.gameappid</code>.
     */
    public void setGameappid(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>login.t_dailydata.gameappid</code>.
     */
    public String getGameappid() {
        return (String) get(3);
    }

    /**
     * Setter for <code>login.t_dailydata.createTime</code>.
     */
    public void setCreatetime(Timestamp value) {
        set(4, value);
    }

    /**
     * Getter for <code>login.t_dailydata.createTime</code>.
     */
    public Timestamp getCreatetime() {
        return (Timestamp) get(4);
    }

    /**
     * Setter for <code>login.t_dailydata.activeUserNum</code>. 用户每日活跃数，统计数量为t_playergame中lastLoginTime为昨日的数量
     */
    public void setActiveusernum(Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>login.t_dailydata.activeUserNum</code>. 用户每日活跃数，统计数量为t_playergame中lastLoginTime为昨日的数量
     */
    public Integer getActiveusernum() {
        return (Integer) get(5);
    }

    /**
     * Setter for <code>login.t_dailydata.nextDayLeft</code>. 截止到今天，次日新增用户留存的数量(暂不使用)
     */
    public void setNextdayleft(Integer value) {
        set(6, value);
    }

    /**
     * Getter for <code>login.t_dailydata.nextDayLeft</code>. 截止到今天，次日新增用户留存的数量(暂不使用)
     */
    public Integer getNextdayleft() {
        return (Integer) get(6);
    }

    /**
     * Setter for <code>login.t_dailydata.threeDaysLeft</code>. 截止到今天，3日前新增用户留存的数量(暂不使用)
     */
    public void setThreedaysleft(Integer value) {
        set(7, value);
    }

    /**
     * Getter for <code>login.t_dailydata.threeDaysLeft</code>. 截止到今天，3日前新增用户留存的数量(暂不使用)
     */
    public Integer getThreedaysleft() {
        return (Integer) get(7);
    }

    /**
     * Setter for <code>login.t_dailydata.sevenDaysLeft</code>. 截止到今天，七日前新增用户留存的数量(暂不使用)
     */
    public void setSevendaysleft(Integer value) {
        set(8, value);
    }

    /**
     * Getter for <code>login.t_dailydata.sevenDaysLeft</code>. 截止到今天，七日前新增用户留存的数量(暂不使用)
     */
    public Integer getSevendaysleft() {
        return (Integer) get(8);
    }

    /**
     * Setter for <code>login.t_dailydata.nextDayLeftRate</code>. 以当前createTime新增为准，次日留存率
     */
    public void setNextdayleftrate(BigDecimal value) {
        set(9, value);
    }

    /**
     * Getter for <code>login.t_dailydata.nextDayLeftRate</code>. 以当前createTime新增为准，次日留存率
     */
    public BigDecimal getNextdayleftrate() {
        return (BigDecimal) get(9);
    }

    /**
     * Setter for <code>login.t_dailydata.threeDaysLeftRate</code>. 以当前createTime新增为准，3日留存率
     */
    public void setThreedaysleftrate(BigDecimal value) {
        set(10, value);
    }

    /**
     * Getter for <code>login.t_dailydata.threeDaysLeftRate</code>. 以当前createTime新增为准，3日留存率
     */
    public BigDecimal getThreedaysleftrate() {
        return (BigDecimal) get(10);
    }

    /**
     * Setter for <code>login.t_dailydata.sevenDaysLeftRate</code>. 以当前createTime新增为准，7日留存率
     */
    public void setSevendaysleftrate(BigDecimal value) {
        set(11, value);
    }

    /**
     * Getter for <code>login.t_dailydata.sevenDaysLeftRate</code>. 以当前createTime新增为准，7日留存率
     */
    public BigDecimal getSevendaysleftrate() {
        return (BigDecimal) get(11);
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
    // Record12 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row12<UInteger, String, Integer, String, Timestamp, Integer, Integer, Integer, Integer, BigDecimal, BigDecimal, BigDecimal> fieldsRow() {
        return (Row12) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row12<UInteger, String, Integer, String, Timestamp, Integer, Integer, Integer, Integer, BigDecimal, BigDecimal, BigDecimal> valuesRow() {
        return (Row12) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<UInteger> field1() {
        return TDailydata.T_DAILYDATA.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return TDailydata.T_DAILYDATA.BOXAPPID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field3() {
        return TDailydata.T_DAILYDATA.USERNUM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return TDailydata.T_DAILYDATA.GAMEAPPID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field5() {
        return TDailydata.T_DAILYDATA.CREATETIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field6() {
        return TDailydata.T_DAILYDATA.ACTIVEUSERNUM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field7() {
        return TDailydata.T_DAILYDATA.NEXTDAYLEFT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field8() {
        return TDailydata.T_DAILYDATA.THREEDAYSLEFT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field9() {
        return TDailydata.T_DAILYDATA.SEVENDAYSLEFT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<BigDecimal> field10() {
        return TDailydata.T_DAILYDATA.NEXTDAYLEFTRATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<BigDecimal> field11() {
        return TDailydata.T_DAILYDATA.THREEDAYSLEFTRATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<BigDecimal> field12() {
        return TDailydata.T_DAILYDATA.SEVENDAYSLEFTRATE;
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
        return getBoxappid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component3() {
        return getUsernum();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getGameappid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component5() {
        return getCreatetime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component6() {
        return getActiveusernum();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component7() {
        return getNextdayleft();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component8() {
        return getThreedaysleft();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component9() {
        return getSevendaysleft();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal component10() {
        return getNextdayleftrate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal component11() {
        return getThreedaysleftrate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal component12() {
        return getSevendaysleftrate();
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
        return getBoxappid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value3() {
        return getUsernum();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getGameappid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value5() {
        return getCreatetime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value6() {
        return getActiveusernum();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value7() {
        return getNextdayleft();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value8() {
        return getThreedaysleft();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value9() {
        return getSevendaysleft();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal value10() {
        return getNextdayleftrate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal value11() {
        return getThreedaysleftrate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal value12() {
        return getSevendaysleftrate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TDailydataRecord value1(UInteger value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TDailydataRecord value2(String value) {
        setBoxappid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TDailydataRecord value3(Integer value) {
        setUsernum(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TDailydataRecord value4(String value) {
        setGameappid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TDailydataRecord value5(Timestamp value) {
        setCreatetime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TDailydataRecord value6(Integer value) {
        setActiveusernum(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TDailydataRecord value7(Integer value) {
        setNextdayleft(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TDailydataRecord value8(Integer value) {
        setThreedaysleft(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TDailydataRecord value9(Integer value) {
        setSevendaysleft(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TDailydataRecord value10(BigDecimal value) {
        setNextdayleftrate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TDailydataRecord value11(BigDecimal value) {
        setThreedaysleftrate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TDailydataRecord value12(BigDecimal value) {
        setSevendaysleftrate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TDailydataRecord values(UInteger value1, String value2, Integer value3, String value4, Timestamp value5, Integer value6, Integer value7, Integer value8, Integer value9, BigDecimal value10, BigDecimal value11, BigDecimal value12) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TDailydataRecord
     */
    public TDailydataRecord() {
        super(TDailydata.T_DAILYDATA);
    }

    /**
     * Create a detached, initialised TDailydataRecord
     */
    public TDailydataRecord(UInteger id, String boxappid, Integer usernum, String gameappid, Timestamp createtime, Integer activeusernum, Integer nextdayleft, Integer threedaysleft, Integer sevendaysleft, BigDecimal nextdayleftrate, BigDecimal threedaysleftrate, BigDecimal sevendaysleftrate) {
        super(TDailydata.T_DAILYDATA);

        set(0, id);
        set(1, boxappid);
        set(2, usernum);
        set(3, gameappid);
        set(4, createtime);
        set(5, activeusernum);
        set(6, nextdayleft);
        set(7, threedaysleft);
        set(8, sevendaysleft);
        set(9, nextdayleftrate);
        set(10, threedaysleftrate);
        set(11, sevendaysleftrate);
    }
}
