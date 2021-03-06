/*
 * This file is generated by jOOQ.
*/
package com.bsu.ugame.gameparams.jooq.db.tables;


import com.bsu.ugame.gameparams.jooq.db.Gameparams;
import com.bsu.ugame.gameparams.jooq.db.Indexes;
import com.bsu.ugame.gameparams.jooq.db.Keys;
import com.bsu.ugame.gameparams.jooq.db.tables.records.TMorejumpRecord;

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
public class TMorejump extends TableImpl<TMorejumpRecord> {

    private static final long serialVersionUID = -617396957;

    /**
     * The reference instance of <code>gameparams.t_morejump</code>
     */
    public static final TMorejump T_MOREJUMP = new TMorejump();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TMorejumpRecord> getRecordType() {
        return TMorejumpRecord.class;
    }

    /**
     * The column <code>gameparams.t_morejump.id</code>.
     */
    public final TableField<TMorejumpRecord, UInteger> ID = createField("id", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false).identity(true), this, "");

    /**
     * The column <code>gameparams.t_morejump.gameappid</code>. 游戏appid
     */
    public final TableField<TMorejumpRecord, String> GAMEAPPID = createField("gameappid", org.jooq.impl.SQLDataType.VARCHAR(50), this, "游戏appid");

    /**
     * The column <code>gameparams.t_morejump.objectappid</code>. 目标appid，跳到了哪个app
     */
    public final TableField<TMorejumpRecord, String> OBJECTAPPID = createField("objectappid", org.jooq.impl.SQLDataType.VARCHAR(50), this, "目标appid，跳到了哪个app");

    /**
     * The column <code>gameparams.t_morejump.userid</code>. 跳转的用户数量
     */
    public final TableField<TMorejumpRecord, String> USERID = createField("userid", org.jooq.impl.SQLDataType.VARCHAR(50), this, "跳转的用户数量");

    /**
     * The column <code>gameparams.t_morejump.createtime</code>.
     */
    public final TableField<TMorejumpRecord, Timestamp> CREATETIME = createField("createtime", org.jooq.impl.SQLDataType.TIMESTAMP.defaultValue(org.jooq.impl.DSL.inline("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "");

    /**
     * Create a <code>gameparams.t_morejump</code> table reference
     */
    public TMorejump() {
        this(DSL.name("t_morejump"), null);
    }

    /**
     * Create an aliased <code>gameparams.t_morejump</code> table reference
     */
    public TMorejump(String alias) {
        this(DSL.name(alias), T_MOREJUMP);
    }

    /**
     * Create an aliased <code>gameparams.t_morejump</code> table reference
     */
    public TMorejump(Name alias) {
        this(alias, T_MOREJUMP);
    }

    private TMorejump(Name alias, Table<TMorejumpRecord> aliased) {
        this(alias, aliased, null);
    }

    private TMorejump(Name alias, Table<TMorejumpRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.T_MOREJUMP_PRIMARY, Indexes.T_MOREJUMP_UNI_GAMEAPPID_OBJECTAPPID_USERID);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<TMorejumpRecord, UInteger> getIdentity() {
        return Keys.IDENTITY_T_MOREJUMP;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<TMorejumpRecord> getPrimaryKey() {
        return Keys.KEY_T_MOREJUMP_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<TMorejumpRecord>> getKeys() {
        return Arrays.<UniqueKey<TMorejumpRecord>>asList(Keys.KEY_T_MOREJUMP_PRIMARY, Keys.KEY_T_MOREJUMP_UNI_GAMEAPPID_OBJECTAPPID_USERID);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TMorejump as(String alias) {
        return new TMorejump(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TMorejump as(Name alias) {
        return new TMorejump(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public TMorejump rename(String name) {
        return new TMorejump(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public TMorejump rename(Name name) {
        return new TMorejump(name, null);
    }
}
