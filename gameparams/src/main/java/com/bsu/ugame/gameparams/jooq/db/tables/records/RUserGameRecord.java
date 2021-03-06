/*
 * This file is generated by jOOQ.
*/
package com.bsu.ugame.gameparams.jooq.db.tables.records;


import com.bsu.ugame.gameparams.jooq.db.tables.RUserGame;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
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
public class RUserGameRecord extends UpdatableRecordImpl<RUserGameRecord> implements Record3<UInteger, UInteger, UInteger> {

    private static final long serialVersionUID = -20292795;

    /**
     * Setter for <code>gameparams.r_user_game.id</code>.
     */
    public void setId(UInteger value) {
        set(0, value);
    }

    /**
     * Getter for <code>gameparams.r_user_game.id</code>.
     */
    public UInteger getId() {
        return (UInteger) get(0);
    }

    /**
     * Setter for <code>gameparams.r_user_game.userid</code>.
     */
    public void setUserid(UInteger value) {
        set(1, value);
    }

    /**
     * Getter for <code>gameparams.r_user_game.userid</code>.
     */
    public UInteger getUserid() {
        return (UInteger) get(1);
    }

    /**
     * Setter for <code>gameparams.r_user_game.gameid</code>.
     */
    public void setGameid(UInteger value) {
        set(2, value);
    }

    /**
     * Getter for <code>gameparams.r_user_game.gameid</code>.
     */
    public UInteger getGameid() {
        return (UInteger) get(2);
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
    // Record3 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<UInteger, UInteger, UInteger> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<UInteger, UInteger, UInteger> valuesRow() {
        return (Row3) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<UInteger> field1() {
        return RUserGame.R_USER_GAME.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<UInteger> field2() {
        return RUserGame.R_USER_GAME.USERID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<UInteger> field3() {
        return RUserGame.R_USER_GAME.GAMEID;
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
    public UInteger component2() {
        return getUserid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UInteger component3() {
        return getGameid();
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
    public UInteger value2() {
        return getUserid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UInteger value3() {
        return getGameid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RUserGameRecord value1(UInteger value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RUserGameRecord value2(UInteger value) {
        setUserid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RUserGameRecord value3(UInteger value) {
        setGameid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RUserGameRecord values(UInteger value1, UInteger value2, UInteger value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached RUserGameRecord
     */
    public RUserGameRecord() {
        super(RUserGame.R_USER_GAME);
    }

    /**
     * Create a detached, initialised RUserGameRecord
     */
    public RUserGameRecord(UInteger id, UInteger userid, UInteger gameid) {
        super(RUserGame.R_USER_GAME);

        set(0, id);
        set(1, userid);
        set(2, gameid);
    }
}
