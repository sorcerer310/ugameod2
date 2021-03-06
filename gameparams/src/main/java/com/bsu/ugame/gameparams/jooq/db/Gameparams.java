/*
 * This file is generated by jOOQ.
*/
package com.bsu.ugame.gameparams.jooq.db;


import com.bsu.ugame.gameparams.jooq.db.tables.RUserGame;
import com.bsu.ugame.gameparams.jooq.db.tables.TControl;
import com.bsu.ugame.gameparams.jooq.db.tables.TControlvalue;
import com.bsu.ugame.gameparams.jooq.db.tables.TGame;
import com.bsu.ugame.gameparams.jooq.db.tables.THelpdata;
import com.bsu.ugame.gameparams.jooq.db.tables.TJumpdata;
import com.bsu.ugame.gameparams.jooq.db.tables.TMoregames;
import com.bsu.ugame.gameparams.jooq.db.tables.TMorejump;
import com.bsu.ugame.gameparams.jooq.db.tables.TPlayer;
import com.bsu.ugame.gameparams.jooq.db.tables.TRolespermissions;
import com.bsu.ugame.gameparams.jooq.db.tables.TShare;
import com.bsu.ugame.gameparams.jooq.db.tables.TUser;
import com.bsu.ugame.gameparams.jooq.db.tables.TUserroles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


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
public class Gameparams extends SchemaImpl {

    private static final long serialVersionUID = -1088420328;

    /**
     * The reference instance of <code>gameparams</code>
     */
    public static final Gameparams GAMEPARAMS = new Gameparams();

    /**
     * The table <code>gameparams.r_user_game</code>.
     */
    public final RUserGame R_USER_GAME = com.bsu.ugame.gameparams.jooq.db.tables.RUserGame.R_USER_GAME;

    /**
     * The table <code>gameparams.t_control</code>.
     */
    public final TControl T_CONTROL = com.bsu.ugame.gameparams.jooq.db.tables.TControl.T_CONTROL;

    /**
     * The table <code>gameparams.t_controlvalue</code>.
     */
    public final TControlvalue T_CONTROLVALUE = com.bsu.ugame.gameparams.jooq.db.tables.TControlvalue.T_CONTROLVALUE;

    /**
     * 保存游戏信息。产品的基础信息。
     */
    public final TGame T_GAME = com.bsu.ugame.gameparams.jooq.db.tables.TGame.T_GAME;

    /**
     * The table <code>gameparams.t_helpdata</code>.
     */
    public final THelpdata T_HELPDATA = com.bsu.ugame.gameparams.jooq.db.tables.THelpdata.T_HELPDATA;

    /**
     * The table <code>gameparams.t_jumpdata</code>.
     */
    public final TJumpdata T_JUMPDATA = com.bsu.ugame.gameparams.jooq.db.tables.TJumpdata.T_JUMPDATA;

    /**
     * The table <code>gameparams.t_moregames</code>.
     */
    public final TMoregames T_MOREGAMES = com.bsu.ugame.gameparams.jooq.db.tables.TMoregames.T_MOREGAMES;

    /**
     * The table <code>gameparams.t_morejump</code>.
     */
    public final TMorejump T_MOREJUMP = com.bsu.ugame.gameparams.jooq.db.tables.TMorejump.T_MOREJUMP;

    /**
     * The table <code>gameparams.t_player</code>.
     */
    public final TPlayer T_PLAYER = com.bsu.ugame.gameparams.jooq.db.tables.TPlayer.T_PLAYER;

    /**
     * The table <code>gameparams.t_rolespermissions</code>.
     */
    public final TRolespermissions T_ROLESPERMISSIONS = com.bsu.ugame.gameparams.jooq.db.tables.TRolespermissions.T_ROLESPERMISSIONS;

    /**
     * The table <code>gameparams.t_share</code>.
     */
    public final TShare T_SHARE = com.bsu.ugame.gameparams.jooq.db.tables.TShare.T_SHARE;

    /**
     * The table <code>gameparams.t_user</code>.
     */
    public final TUser T_USER = com.bsu.ugame.gameparams.jooq.db.tables.TUser.T_USER;

    /**
     * The table <code>gameparams.t_userroles</code>.
     */
    public final TUserroles T_USERROLES = com.bsu.ugame.gameparams.jooq.db.tables.TUserroles.T_USERROLES;

    /**
     * No further instances allowed
     */
    private Gameparams() {
        super("gameparams", null);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
            RUserGame.R_USER_GAME,
            TControl.T_CONTROL,
            TControlvalue.T_CONTROLVALUE,
            TGame.T_GAME,
            THelpdata.T_HELPDATA,
            TJumpdata.T_JUMPDATA,
            TMoregames.T_MOREGAMES,
            TMorejump.T_MOREJUMP,
            TPlayer.T_PLAYER,
            TRolespermissions.T_ROLESPERMISSIONS,
            TShare.T_SHARE,
            TUser.T_USER,
            TUserroles.T_USERROLES);
    }
}
