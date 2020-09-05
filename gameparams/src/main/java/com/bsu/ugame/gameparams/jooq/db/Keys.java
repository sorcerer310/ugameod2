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
import com.bsu.ugame.gameparams.jooq.db.tables.records.RUserGameRecord;
import com.bsu.ugame.gameparams.jooq.db.tables.records.TControlRecord;
import com.bsu.ugame.gameparams.jooq.db.tables.records.TControlvalueRecord;
import com.bsu.ugame.gameparams.jooq.db.tables.records.TGameRecord;
import com.bsu.ugame.gameparams.jooq.db.tables.records.THelpdataRecord;
import com.bsu.ugame.gameparams.jooq.db.tables.records.TJumpdataRecord;
import com.bsu.ugame.gameparams.jooq.db.tables.records.TMoregamesRecord;
import com.bsu.ugame.gameparams.jooq.db.tables.records.TMorejumpRecord;
import com.bsu.ugame.gameparams.jooq.db.tables.records.TPlayerRecord;
import com.bsu.ugame.gameparams.jooq.db.tables.records.TRolespermissionsRecord;
import com.bsu.ugame.gameparams.jooq.db.tables.records.TShareRecord;
import com.bsu.ugame.gameparams.jooq.db.tables.records.TUserRecord;
import com.bsu.ugame.gameparams.jooq.db.tables.records.TUserrolesRecord;

import javax.annotation.Generated;

import org.jooq.Identity;
import org.jooq.UniqueKey;
import org.jooq.impl.AbstractKeys;
import org.jooq.types.UInteger;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>gameparams</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.0"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<RUserGameRecord, UInteger> IDENTITY_R_USER_GAME = Identities0.IDENTITY_R_USER_GAME;
    public static final Identity<TControlRecord, UInteger> IDENTITY_T_CONTROL = Identities0.IDENTITY_T_CONTROL;
    public static final Identity<TControlvalueRecord, UInteger> IDENTITY_T_CONTROLVALUE = Identities0.IDENTITY_T_CONTROLVALUE;
    public static final Identity<TGameRecord, UInteger> IDENTITY_T_GAME = Identities0.IDENTITY_T_GAME;
    public static final Identity<THelpdataRecord, UInteger> IDENTITY_T_HELPDATA = Identities0.IDENTITY_T_HELPDATA;
    public static final Identity<TJumpdataRecord, UInteger> IDENTITY_T_JUMPDATA = Identities0.IDENTITY_T_JUMPDATA;
    public static final Identity<TMoregamesRecord, UInteger> IDENTITY_T_MOREGAMES = Identities0.IDENTITY_T_MOREGAMES;
    public static final Identity<TMorejumpRecord, UInteger> IDENTITY_T_MOREJUMP = Identities0.IDENTITY_T_MOREJUMP;
    public static final Identity<TPlayerRecord, UInteger> IDENTITY_T_PLAYER = Identities0.IDENTITY_T_PLAYER;
    public static final Identity<TRolespermissionsRecord, Long> IDENTITY_T_ROLESPERMISSIONS = Identities0.IDENTITY_T_ROLESPERMISSIONS;
    public static final Identity<TShareRecord, UInteger> IDENTITY_T_SHARE = Identities0.IDENTITY_T_SHARE;
    public static final Identity<TUserRecord, UInteger> IDENTITY_T_USER = Identities0.IDENTITY_T_USER;
    public static final Identity<TUserrolesRecord, Long> IDENTITY_T_USERROLES = Identities0.IDENTITY_T_USERROLES;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<RUserGameRecord> KEY_R_USER_GAME_PRIMARY = UniqueKeys0.KEY_R_USER_GAME_PRIMARY;
    public static final UniqueKey<RUserGameRecord> KEY_R_USER_GAME_UNI_USERID_GAMEAPPID = UniqueKeys0.KEY_R_USER_GAME_UNI_USERID_GAMEAPPID;
    public static final UniqueKey<TControlRecord> KEY_T_CONTROL_PRIMARY = UniqueKeys0.KEY_T_CONTROL_PRIMARY;
    public static final UniqueKey<TControlvalueRecord> KEY_T_CONTROLVALUE_PRIMARY = UniqueKeys0.KEY_T_CONTROLVALUE_PRIMARY;
    public static final UniqueKey<TControlvalueRecord> KEY_T_CONTROLVALUE_UNI_GAMEAPPID_VERSION = UniqueKeys0.KEY_T_CONTROLVALUE_UNI_GAMEAPPID_VERSION;
    public static final UniqueKey<TGameRecord> KEY_T_GAME_PRIMARY = UniqueKeys0.KEY_T_GAME_PRIMARY;
    public static final UniqueKey<TGameRecord> KEY_T_GAME_UNI_GAMEAPPID = UniqueKeys0.KEY_T_GAME_UNI_GAMEAPPID;
    public static final UniqueKey<THelpdataRecord> KEY_T_HELPDATA_PRIMARY = UniqueKeys0.KEY_T_HELPDATA_PRIMARY;
    public static final UniqueKey<TJumpdataRecord> KEY_T_JUMPDATA_PRIMARY = UniqueKeys0.KEY_T_JUMPDATA_PRIMARY;
    public static final UniqueKey<TMoregamesRecord> KEY_T_MOREGAMES_PRIMARY = UniqueKeys0.KEY_T_MOREGAMES_PRIMARY;
    public static final UniqueKey<TMorejumpRecord> KEY_T_MOREJUMP_PRIMARY = UniqueKeys0.KEY_T_MOREJUMP_PRIMARY;
    public static final UniqueKey<TMorejumpRecord> KEY_T_MOREJUMP_UNI_GAMEAPPID_OBJECTAPPID_USERID = UniqueKeys0.KEY_T_MOREJUMP_UNI_GAMEAPPID_OBJECTAPPID_USERID;
    public static final UniqueKey<TPlayerRecord> KEY_T_PLAYER_PRIMARY = UniqueKeys0.KEY_T_PLAYER_PRIMARY;
    public static final UniqueKey<TRolespermissionsRecord> KEY_T_ROLESPERMISSIONS_PRIMARY = UniqueKeys0.KEY_T_ROLESPERMISSIONS_PRIMARY;
    public static final UniqueKey<TRolespermissionsRecord> KEY_T_ROLESPERMISSIONS_IDX_ROLES_PERMISSIONS = UniqueKeys0.KEY_T_ROLESPERMISSIONS_IDX_ROLES_PERMISSIONS;
    public static final UniqueKey<TShareRecord> KEY_T_SHARE_PRIMARY = UniqueKeys0.KEY_T_SHARE_PRIMARY;
    public static final UniqueKey<TUserRecord> KEY_T_USER_PRIMARY = UniqueKeys0.KEY_T_USER_PRIMARY;
    public static final UniqueKey<TUserRecord> KEY_T_USER_UNI_NAME = UniqueKeys0.KEY_T_USER_UNI_NAME;
    public static final UniqueKey<TUserrolesRecord> KEY_T_USERROLES_PRIMARY = UniqueKeys0.KEY_T_USERROLES_PRIMARY;
    public static final UniqueKey<TUserrolesRecord> KEY_T_USERROLES_IDX_USER_ROLES = UniqueKeys0.KEY_T_USERROLES_IDX_USER_ROLES;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 extends AbstractKeys {
        public static Identity<RUserGameRecord, UInteger> IDENTITY_R_USER_GAME = createIdentity(RUserGame.R_USER_GAME, RUserGame.R_USER_GAME.ID);
        public static Identity<TControlRecord, UInteger> IDENTITY_T_CONTROL = createIdentity(TControl.T_CONTROL, TControl.T_CONTROL.ID);
        public static Identity<TControlvalueRecord, UInteger> IDENTITY_T_CONTROLVALUE = createIdentity(TControlvalue.T_CONTROLVALUE, TControlvalue.T_CONTROLVALUE.ID);
        public static Identity<TGameRecord, UInteger> IDENTITY_T_GAME = createIdentity(TGame.T_GAME, TGame.T_GAME.ID);
        public static Identity<THelpdataRecord, UInteger> IDENTITY_T_HELPDATA = createIdentity(THelpdata.T_HELPDATA, THelpdata.T_HELPDATA.ID);
        public static Identity<TJumpdataRecord, UInteger> IDENTITY_T_JUMPDATA = createIdentity(TJumpdata.T_JUMPDATA, TJumpdata.T_JUMPDATA.ID);
        public static Identity<TMoregamesRecord, UInteger> IDENTITY_T_MOREGAMES = createIdentity(TMoregames.T_MOREGAMES, TMoregames.T_MOREGAMES.ID);
        public static Identity<TMorejumpRecord, UInteger> IDENTITY_T_MOREJUMP = createIdentity(TMorejump.T_MOREJUMP, TMorejump.T_MOREJUMP.ID);
        public static Identity<TPlayerRecord, UInteger> IDENTITY_T_PLAYER = createIdentity(TPlayer.T_PLAYER, TPlayer.T_PLAYER.ID);
        public static Identity<TRolespermissionsRecord, Long> IDENTITY_T_ROLESPERMISSIONS = createIdentity(TRolespermissions.T_ROLESPERMISSIONS, TRolespermissions.T_ROLESPERMISSIONS.ID);
        public static Identity<TShareRecord, UInteger> IDENTITY_T_SHARE = createIdentity(TShare.T_SHARE, TShare.T_SHARE.ID);
        public static Identity<TUserRecord, UInteger> IDENTITY_T_USER = createIdentity(TUser.T_USER, TUser.T_USER.ID);
        public static Identity<TUserrolesRecord, Long> IDENTITY_T_USERROLES = createIdentity(TUserroles.T_USERROLES, TUserroles.T_USERROLES.ID);
    }

    private static class UniqueKeys0 extends AbstractKeys {
        public static final UniqueKey<RUserGameRecord> KEY_R_USER_GAME_PRIMARY = createUniqueKey(RUserGame.R_USER_GAME, "KEY_r_user_game_PRIMARY", RUserGame.R_USER_GAME.ID);
        public static final UniqueKey<RUserGameRecord> KEY_R_USER_GAME_UNI_USERID_GAMEAPPID = createUniqueKey(RUserGame.R_USER_GAME, "KEY_r_user_game_UNI_USERID_GAMEAPPID", RUserGame.R_USER_GAME.USERID, RUserGame.R_USER_GAME.GAMEID);
        public static final UniqueKey<TControlRecord> KEY_T_CONTROL_PRIMARY = createUniqueKey(TControl.T_CONTROL, "KEY_t_control_PRIMARY", TControl.T_CONTROL.ID);
        public static final UniqueKey<TControlvalueRecord> KEY_T_CONTROLVALUE_PRIMARY = createUniqueKey(TControlvalue.T_CONTROLVALUE, "KEY_t_controlvalue_PRIMARY", TControlvalue.T_CONTROLVALUE.ID);
        public static final UniqueKey<TControlvalueRecord> KEY_T_CONTROLVALUE_UNI_GAMEAPPID_VERSION = createUniqueKey(TControlvalue.T_CONTROLVALUE, "KEY_t_controlvalue_UNI_GAMEAPPID_VERSION", TControlvalue.T_CONTROLVALUE.GAMEAPPID, TControlvalue.T_CONTROLVALUE.VERSION);
        public static final UniqueKey<TGameRecord> KEY_T_GAME_PRIMARY = createUniqueKey(TGame.T_GAME, "KEY_t_game_PRIMARY", TGame.T_GAME.ID);
        public static final UniqueKey<TGameRecord> KEY_T_GAME_UNI_GAMEAPPID = createUniqueKey(TGame.T_GAME, "KEY_t_game_UNI_GAMEAPPID", TGame.T_GAME.GAMEAPPID);
        public static final UniqueKey<THelpdataRecord> KEY_T_HELPDATA_PRIMARY = createUniqueKey(THelpdata.T_HELPDATA, "KEY_t_helpdata_PRIMARY", THelpdata.T_HELPDATA.ID);
        public static final UniqueKey<TJumpdataRecord> KEY_T_JUMPDATA_PRIMARY = createUniqueKey(TJumpdata.T_JUMPDATA, "KEY_t_jumpdata_PRIMARY", TJumpdata.T_JUMPDATA.ID);
        public static final UniqueKey<TMoregamesRecord> KEY_T_MOREGAMES_PRIMARY = createUniqueKey(TMoregames.T_MOREGAMES, "KEY_t_moregames_PRIMARY", TMoregames.T_MOREGAMES.ID);
        public static final UniqueKey<TMorejumpRecord> KEY_T_MOREJUMP_PRIMARY = createUniqueKey(TMorejump.T_MOREJUMP, "KEY_t_morejump_PRIMARY", TMorejump.T_MOREJUMP.ID);
        public static final UniqueKey<TMorejumpRecord> KEY_T_MOREJUMP_UNI_GAMEAPPID_OBJECTAPPID_USERID = createUniqueKey(TMorejump.T_MOREJUMP, "KEY_t_morejump_UNI_GAMEAPPID_OBJECTAPPID_USERID", TMorejump.T_MOREJUMP.GAMEAPPID, TMorejump.T_MOREJUMP.OBJECTAPPID, TMorejump.T_MOREJUMP.USERID);
        public static final UniqueKey<TPlayerRecord> KEY_T_PLAYER_PRIMARY = createUniqueKey(TPlayer.T_PLAYER, "KEY_t_player_PRIMARY", TPlayer.T_PLAYER.ID);
        public static final UniqueKey<TRolespermissionsRecord> KEY_T_ROLESPERMISSIONS_PRIMARY = createUniqueKey(TRolespermissions.T_ROLESPERMISSIONS, "KEY_t_rolespermissions_PRIMARY", TRolespermissions.T_ROLESPERMISSIONS.ID);
        public static final UniqueKey<TRolespermissionsRecord> KEY_T_ROLESPERMISSIONS_IDX_ROLES_PERMISSIONS = createUniqueKey(TRolespermissions.T_ROLESPERMISSIONS, "KEY_t_rolespermissions_idx_roles_permissions", TRolespermissions.T_ROLESPERMISSIONS.ROLE_NAME, TRolespermissions.T_ROLESPERMISSIONS.PERMISSION);
        public static final UniqueKey<TShareRecord> KEY_T_SHARE_PRIMARY = createUniqueKey(TShare.T_SHARE, "KEY_t_share_PRIMARY", TShare.T_SHARE.ID);
        public static final UniqueKey<TUserRecord> KEY_T_USER_PRIMARY = createUniqueKey(TUser.T_USER, "KEY_t_user_PRIMARY", TUser.T_USER.ID);
        public static final UniqueKey<TUserRecord> KEY_T_USER_UNI_NAME = createUniqueKey(TUser.T_USER, "KEY_t_user_UNI_NAME", TUser.T_USER.NAME);
        public static final UniqueKey<TUserrolesRecord> KEY_T_USERROLES_PRIMARY = createUniqueKey(TUserroles.T_USERROLES, "KEY_t_userroles_PRIMARY", TUserroles.T_USERROLES.ID);
        public static final UniqueKey<TUserrolesRecord> KEY_T_USERROLES_IDX_USER_ROLES = createUniqueKey(TUserroles.T_USERROLES, "KEY_t_userroles_idx_user_roles", TUserroles.T_USERROLES.USERNAME, TUserroles.T_USERROLES.ROLE_NAME);
    }
}