/*
 * This file is generated by jOOQ.
*/
package com.bsu.ugame.wechatgame.jooq.db.tables;


import com.bsu.ugame.wechatgame.jooq.db.Indexes;
import com.bsu.ugame.wechatgame.jooq.db.Keys;
import com.bsu.ugame.wechatgame.jooq.db.Login;
import com.bsu.ugame.wechatgame.jooq.db.tables.records.RBoxGameRecord;

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
public class RBoxGame extends TableImpl<RBoxGameRecord> {

    private static final long serialVersionUID = 687589651;

    /**
     * The reference instance of <code>login.r_box_game</code>
     */
    public static final RBoxGame R_BOX_GAME = new RBoxGame();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<RBoxGameRecord> getRecordType() {
        return RBoxGameRecord.class;
    }

    /**
     * The column <code>login.r_box_game.id</code>.
     */
    public final TableField<RBoxGameRecord, UInteger> ID = createField("id", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false).identity(true), this, "");

    /**
     * The column <code>login.r_box_game.boxid</code>. 盒子id
     */
    public final TableField<RBoxGameRecord, UInteger> BOXID = createField("boxid", org.jooq.impl.SQLDataType.INTEGERUNSIGNED, this, "盒子id");

    /**
     * The column <code>login.r_box_game.gameid</code>. 游戏id
     */
    public final TableField<RBoxGameRecord, UInteger> GAMEID = createField("gameid", org.jooq.impl.SQLDataType.INTEGERUNSIGNED, this, "游戏id");

    /**
     * Create a <code>login.r_box_game</code> table reference
     */
    public RBoxGame() {
        this(DSL.name("r_box_game"), null);
    }

    /**
     * Create an aliased <code>login.r_box_game</code> table reference
     */
    public RBoxGame(String alias) {
        this(DSL.name(alias), R_BOX_GAME);
    }

    /**
     * Create an aliased <code>login.r_box_game</code> table reference
     */
    public RBoxGame(Name alias) {
        this(alias, R_BOX_GAME);
    }

    private RBoxGame(Name alias, Table<RBoxGameRecord> aliased) {
        this(alias, aliased, null);
    }

    private RBoxGame(Name alias, Table<RBoxGameRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.R_BOX_GAME_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<RBoxGameRecord, UInteger> getIdentity() {
        return Keys.IDENTITY_R_BOX_GAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<RBoxGameRecord> getPrimaryKey() {
        return Keys.KEY_R_BOX_GAME_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<RBoxGameRecord>> getKeys() {
        return Arrays.<UniqueKey<RBoxGameRecord>>asList(Keys.KEY_R_BOX_GAME_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RBoxGame as(String alias) {
        return new RBoxGame(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RBoxGame as(Name alias) {
        return new RBoxGame(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public RBoxGame rename(String name) {
        return new RBoxGame(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public RBoxGame rename(Name name) {
        return new RBoxGame(name, null);
    }
}
