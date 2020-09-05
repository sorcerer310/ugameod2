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

import javax.annotation.Generated;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.AbstractKeys;


/**
 * A class modelling indexes of tables of the <code>gameparams</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.0"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index R_USER_GAME_PRIMARY = Indexes0.R_USER_GAME_PRIMARY;
    public static final Index R_USER_GAME_UNI_USERID_GAMEAPPID = Indexes0.R_USER_GAME_UNI_USERID_GAMEAPPID;
    public static final Index T_CONTROL_GAMEAPPID = Indexes0.T_CONTROL_GAMEAPPID;
    public static final Index T_CONTROL_GAMEAPPID_2 = Indexes0.T_CONTROL_GAMEAPPID_2;
    public static final Index T_CONTROL_GAMEAPPID_3 = Indexes0.T_CONTROL_GAMEAPPID_3;
    public static final Index T_CONTROL_GAMEAPPID_4 = Indexes0.T_CONTROL_GAMEAPPID_4;
    public static final Index T_CONTROL_GAMEAPPID_5 = Indexes0.T_CONTROL_GAMEAPPID_5;
    public static final Index T_CONTROL_GAMEAPPID_6 = Indexes0.T_CONTROL_GAMEAPPID_6;
    public static final Index T_CONTROL_I_GAMEAPPID = Indexes0.T_CONTROL_I_GAMEAPPID;
    public static final Index T_CONTROL_PRIMARY = Indexes0.T_CONTROL_PRIMARY;
    public static final Index T_CONTROLVALUE_PRIMARY = Indexes0.T_CONTROLVALUE_PRIMARY;
    public static final Index T_CONTROLVALUE_UNI_GAMEAPPID_VERSION = Indexes0.T_CONTROLVALUE_UNI_GAMEAPPID_VERSION;
    public static final Index T_GAME_GAMEAPPID = Indexes0.T_GAME_GAMEAPPID;
    public static final Index T_GAME_PRIMARY = Indexes0.T_GAME_PRIMARY;
    public static final Index T_GAME_UNI_GAMEAPPID = Indexes0.T_GAME_UNI_GAMEAPPID;
    public static final Index T_HELPDATA_PRIMARY = Indexes0.T_HELPDATA_PRIMARY;
    public static final Index T_JUMPDATA_PRIMARY = Indexes0.T_JUMPDATA_PRIMARY;
    public static final Index T_MOREGAMES_PRIMARY = Indexes0.T_MOREGAMES_PRIMARY;
    public static final Index T_MOREJUMP_PRIMARY = Indexes0.T_MOREJUMP_PRIMARY;
    public static final Index T_MOREJUMP_UNI_GAMEAPPID_OBJECTAPPID_USERID = Indexes0.T_MOREJUMP_UNI_GAMEAPPID_OBJECTAPPID_USERID;
    public static final Index T_PLAYER_PRIMARY = Indexes0.T_PLAYER_PRIMARY;
    public static final Index T_ROLESPERMISSIONS_IDX_ROLES_PERMISSIONS = Indexes0.T_ROLESPERMISSIONS_IDX_ROLES_PERMISSIONS;
    public static final Index T_ROLESPERMISSIONS_PRIMARY = Indexes0.T_ROLESPERMISSIONS_PRIMARY;
    public static final Index T_SHARE_GAMEAPPID = Indexes0.T_SHARE_GAMEAPPID;
    public static final Index T_SHARE_PRIMARY = Indexes0.T_SHARE_PRIMARY;
    public static final Index T_USER_PRIMARY = Indexes0.T_USER_PRIMARY;
    public static final Index T_USER_UNI_NAME = Indexes0.T_USER_UNI_NAME;
    public static final Index T_USERROLES_IDX_USER_ROLES = Indexes0.T_USERROLES_IDX_USER_ROLES;
    public static final Index T_USERROLES_PRIMARY = Indexes0.T_USERROLES_PRIMARY;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 extends AbstractKeys {
        public static Index R_USER_GAME_PRIMARY = createIndex("PRIMARY", RUserGame.R_USER_GAME, new OrderField[] { RUserGame.R_USER_GAME.ID }, true);
        public static Index R_USER_GAME_UNI_USERID_GAMEAPPID = createIndex("UNI_USERID_GAMEAPPID", RUserGame.R_USER_GAME, new OrderField[] { RUserGame.R_USER_GAME.USERID, RUserGame.R_USER_GAME.GAMEID }, true);
        public static Index T_CONTROL_GAMEAPPID = createIndex("gameappid", TControl.T_CONTROL, new OrderField[] { TControl.T_CONTROL.GAMEAPPID }, false);
        public static Index T_CONTROL_GAMEAPPID_2 = createIndex("gameappid_2", TControl.T_CONTROL, new OrderField[] { TControl.T_CONTROL.GAMEAPPID }, false);
        public static Index T_CONTROL_GAMEAPPID_3 = createIndex("gameappid_3", TControl.T_CONTROL, new OrderField[] { TControl.T_CONTROL.GAMEAPPID }, false);
        public static Index T_CONTROL_GAMEAPPID_4 = createIndex("gameappid_4", TControl.T_CONTROL, new OrderField[] { TControl.T_CONTROL.GAMEAPPID }, false);
        public static Index T_CONTROL_GAMEAPPID_5 = createIndex("gameappid_5", TControl.T_CONTROL, new OrderField[] { TControl.T_CONTROL.GAMEAPPID }, false);
        public static Index T_CONTROL_GAMEAPPID_6 = createIndex("gameappid_6", TControl.T_CONTROL, new OrderField[] { TControl.T_CONTROL.GAMEAPPID }, false);
        public static Index T_CONTROL_I_GAMEAPPID = createIndex("I_GAMEAPPID", TControl.T_CONTROL, new OrderField[] { TControl.T_CONTROL.GAMEAPPID }, false);
        public static Index T_CONTROL_PRIMARY = createIndex("PRIMARY", TControl.T_CONTROL, new OrderField[] { TControl.T_CONTROL.ID }, true);
        public static Index T_CONTROLVALUE_PRIMARY = createIndex("PRIMARY", TControlvalue.T_CONTROLVALUE, new OrderField[] { TControlvalue.T_CONTROLVALUE.ID }, true);
        public static Index T_CONTROLVALUE_UNI_GAMEAPPID_VERSION = createIndex("UNI_GAMEAPPID_VERSION", TControlvalue.T_CONTROLVALUE, new OrderField[] { TControlvalue.T_CONTROLVALUE.GAMEAPPID, TControlvalue.T_CONTROLVALUE.VERSION }, true);
        public static Index T_GAME_GAMEAPPID = createIndex("gameappid", TGame.T_GAME, new OrderField[] { TGame.T_GAME.GAMEAPPID }, false);
        public static Index T_GAME_PRIMARY = createIndex("PRIMARY", TGame.T_GAME, new OrderField[] { TGame.T_GAME.ID }, true);
        public static Index T_GAME_UNI_GAMEAPPID = createIndex("UNI_GAMEAPPID", TGame.T_GAME, new OrderField[] { TGame.T_GAME.GAMEAPPID }, true);
        public static Index T_HELPDATA_PRIMARY = createIndex("PRIMARY", THelpdata.T_HELPDATA, new OrderField[] { THelpdata.T_HELPDATA.ID }, true);
        public static Index T_JUMPDATA_PRIMARY = createIndex("PRIMARY", TJumpdata.T_JUMPDATA, new OrderField[] { TJumpdata.T_JUMPDATA.ID }, true);
        public static Index T_MOREGAMES_PRIMARY = createIndex("PRIMARY", TMoregames.T_MOREGAMES, new OrderField[] { TMoregames.T_MOREGAMES.ID }, true);
        public static Index T_MOREJUMP_PRIMARY = createIndex("PRIMARY", TMorejump.T_MOREJUMP, new OrderField[] { TMorejump.T_MOREJUMP.ID }, true);
        public static Index T_MOREJUMP_UNI_GAMEAPPID_OBJECTAPPID_USERID = createIndex("UNI_GAMEAPPID_OBJECTAPPID_USERID", TMorejump.T_MOREJUMP, new OrderField[] { TMorejump.T_MOREJUMP.GAMEAPPID, TMorejump.T_MOREJUMP.OBJECTAPPID, TMorejump.T_MOREJUMP.USERID }, true);
        public static Index T_PLAYER_PRIMARY = createIndex("PRIMARY", TPlayer.T_PLAYER, new OrderField[] { TPlayer.T_PLAYER.ID }, true);
        public static Index T_ROLESPERMISSIONS_IDX_ROLES_PERMISSIONS = createIndex("idx_roles_permissions", TRolespermissions.T_ROLESPERMISSIONS, new OrderField[] { TRolespermissions.T_ROLESPERMISSIONS.ROLE_NAME, TRolespermissions.T_ROLESPERMISSIONS.PERMISSION }, true);
        public static Index T_ROLESPERMISSIONS_PRIMARY = createIndex("PRIMARY", TRolespermissions.T_ROLESPERMISSIONS, new OrderField[] { TRolespermissions.T_ROLESPERMISSIONS.ID }, true);
        public static Index T_SHARE_GAMEAPPID = createIndex("gameappid", TShare.T_SHARE, new OrderField[] { TShare.T_SHARE.GAMEAPPID }, false);
        public static Index T_SHARE_PRIMARY = createIndex("PRIMARY", TShare.T_SHARE, new OrderField[] { TShare.T_SHARE.ID }, true);
        public static Index T_USER_PRIMARY = createIndex("PRIMARY", TUser.T_USER, new OrderField[] { TUser.T_USER.ID }, true);
        public static Index T_USER_UNI_NAME = createIndex("UNI_NAME", TUser.T_USER, new OrderField[] { TUser.T_USER.NAME }, true);
        public static Index T_USERROLES_IDX_USER_ROLES = createIndex("idx_user_roles", TUserroles.T_USERROLES, new OrderField[] { TUserroles.T_USERROLES.USERNAME, TUserroles.T_USERROLES.ROLE_NAME }, true);
        public static Index T_USERROLES_PRIMARY = createIndex("PRIMARY", TUserroles.T_USERROLES, new OrderField[] { TUserroles.T_USERROLES.ID }, true);
    }
}
