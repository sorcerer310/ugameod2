/*
 * This file is generated by jOOQ.
*/
package com.bsu.ugame.wechatgame.jooq.db.tables.records;


import com.bsu.ugame.wechatgame.jooq.db.tables.TChannel;

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
public class TChannelRecord extends UpdatableRecordImpl<TChannelRecord> implements Record7<UInteger, String, String, String, String, String, String> {

    private static final long serialVersionUID = -334071988;

    /**
     * Setter for <code>login.t_channel.id</code>.
     */
    public void setId(UInteger value) {
        set(0, value);
    }

    /**
     * Getter for <code>login.t_channel.id</code>.
     */
    public UInteger getId() {
        return (UInteger) get(0);
    }

    /**
     * Setter for <code>login.t_channel.channelname</code>. 渠道名称
     */
    public void setChannelname(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>login.t_channel.channelname</code>. 渠道名称
     */
    public String getChannelname() {
        return (String) get(1);
    }

    /**
     * Setter for <code>login.t_channel.account</code>. 渠道登录账号
     */
    public void setAccount(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>login.t_channel.account</code>. 渠道登录账号
     */
    public String getAccount() {
        return (String) get(2);
    }

    /**
     * Setter for <code>login.t_channel.password</code>. 登录密码
     */
    public void setPassword(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>login.t_channel.password</code>. 登录密码
     */
    public String getPassword() {
        return (String) get(3);
    }

    /**
     * Setter for <code>login.t_channel.email</code>. 渠道邮箱
     */
    public void setEmail(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>login.t_channel.email</code>. 渠道邮箱
     */
    public String getEmail() {
        return (String) get(4);
    }

    /**
     * Setter for <code>login.t_channel.phone</code>. 渠道联系电话
     */
    public void setPhone(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>login.t_channel.phone</code>. 渠道联系电话
     */
    public String getPhone() {
        return (String) get(5);
    }

    /**
     * Setter for <code>login.t_channel.auth</code>. 渠道权限 1:管理员 2:运营商 3:开发商
     */
    public void setAuth(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>login.t_channel.auth</code>. 渠道权限 1:管理员 2:运营商 3:开发商
     */
    public String getAuth() {
        return (String) get(6);
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
    public Row7<UInteger, String, String, String, String, String, String> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row7<UInteger, String, String, String, String, String, String> valuesRow() {
        return (Row7) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<UInteger> field1() {
        return TChannel.T_CHANNEL.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return TChannel.T_CHANNEL.CHANNELNAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return TChannel.T_CHANNEL.ACCOUNT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return TChannel.T_CHANNEL.PASSWORD;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return TChannel.T_CHANNEL.EMAIL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return TChannel.T_CHANNEL.PHONE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return TChannel.T_CHANNEL.AUTH;
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
        return getChannelname();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getAccount();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getPassword();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getEmail();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component6() {
        return getPhone();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component7() {
        return getAuth();
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
        return getChannelname();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getAccount();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getPassword();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getEmail();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getPhone();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value7() {
        return getAuth();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TChannelRecord value1(UInteger value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TChannelRecord value2(String value) {
        setChannelname(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TChannelRecord value3(String value) {
        setAccount(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TChannelRecord value4(String value) {
        setPassword(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TChannelRecord value5(String value) {
        setEmail(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TChannelRecord value6(String value) {
        setPhone(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TChannelRecord value7(String value) {
        setAuth(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TChannelRecord values(UInteger value1, String value2, String value3, String value4, String value5, String value6, String value7) {
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
     * Create a detached TChannelRecord
     */
    public TChannelRecord() {
        super(TChannel.T_CHANNEL);
    }

    /**
     * Create a detached, initialised TChannelRecord
     */
    public TChannelRecord(UInteger id, String channelname, String account, String password, String email, String phone, String auth) {
        super(TChannel.T_CHANNEL);

        set(0, id);
        set(1, channelname);
        set(2, account);
        set(3, password);
        set(4, email);
        set(5, phone);
        set(6, auth);
    }
}
