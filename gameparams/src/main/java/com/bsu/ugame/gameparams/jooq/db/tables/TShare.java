/*
 * This file is generated by jOOQ.
*/
package com.bsu.ugame.gameparams.jooq.db.tables;


import com.bsu.ugame.gameparams.jooq.db.Gameparams;
import com.bsu.ugame.gameparams.jooq.db.Indexes;
import com.bsu.ugame.gameparams.jooq.db.Keys;
import com.bsu.ugame.gameparams.jooq.db.tables.records.TShareRecord;

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
public class TShare extends TableImpl<TShareRecord> {

    private static final long serialVersionUID = -1445975656;

    /**
     * The reference instance of <code>gameparams.t_share</code>
     */
    public static final TShare T_SHARE = new TShare();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TShareRecord> getRecordType() {
        return TShareRecord.class;
    }

    /**
     * The column <code>gameparams.t_share.id</code>.
     */
    public final TableField<TShareRecord, UInteger> ID = createField("id", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false).identity(true), this, "");

    /**
     * The column <code>gameparams.t_share.gameappid</code>. 游戏id
     */
    public final TableField<TShareRecord, String> GAMEAPPID = createField("gameappid", org.jooq.impl.SQLDataType.VARCHAR(50).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "游戏id");

    /**
     * The column <code>gameparams.t_share.sharepositionid</code>. 分享点的id，游戏中有若干分享点，不同的id代表不同的分享点
     */
    public final TableField<TShareRecord, Integer> SHAREPOSITIONID = createField("sharepositionid", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.INTEGER)), this, "分享点的id，游戏中有若干分享点，不同的id代表不同的分享点");

    /**
     * The column <code>gameparams.t_share.imageurl</code>.
     */
    public final TableField<TShareRecord, String> IMAGEURL = createField("imageurl", org.jooq.impl.SQLDataType.VARCHAR(200), this, "");

    /**
     * The column <code>gameparams.t_share.sharecontent</code>.
     */
    public final TableField<TShareRecord, String> SHARECONTENT = createField("sharecontent", org.jooq.impl.SQLDataType.VARCHAR(500), this, "");

    /**
     * The column <code>gameparams.t_share.enabled</code>. 该条数据是否可用
     */
    public final TableField<TShareRecord, Boolean> ENABLED = createField("enabled", org.jooq.impl.SQLDataType.BIT.nullable(false), this, "该条数据是否可用");

    /**
     * The column <code>gameparams.t_share.shareorder</code>. 排序用，无特殊意义
     */
    public final TableField<TShareRecord, Integer> SHAREORDER = createField("shareorder", org.jooq.impl.SQLDataType.INTEGER, this, "排序用，无特殊意义");

    /**
     * Create a <code>gameparams.t_share</code> table reference
     */
    public TShare() {
        this(DSL.name("t_share"), null);
    }

    /**
     * Create an aliased <code>gameparams.t_share</code> table reference
     */
    public TShare(String alias) {
        this(DSL.name(alias), T_SHARE);
    }

    /**
     * Create an aliased <code>gameparams.t_share</code> table reference
     */
    public TShare(Name alias) {
        this(alias, T_SHARE);
    }

    private TShare(Name alias, Table<TShareRecord> aliased) {
        this(alias, aliased, null);
    }

    private TShare(Name alias, Table<TShareRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.T_SHARE_GAMEAPPID, Indexes.T_SHARE_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<TShareRecord, UInteger> getIdentity() {
        return Keys.IDENTITY_T_SHARE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<TShareRecord> getPrimaryKey() {
        return Keys.KEY_T_SHARE_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<TShareRecord>> getKeys() {
        return Arrays.<UniqueKey<TShareRecord>>asList(Keys.KEY_T_SHARE_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TShare as(String alias) {
        return new TShare(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TShare as(Name alias) {
        return new TShare(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public TShare rename(String name) {
        return new TShare(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public TShare rename(Name name) {
        return new TShare(name, null);
    }
}
