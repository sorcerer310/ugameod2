/*
 * This file is generated by jOOQ.
*/
package com.bsu.ugame.wechatgame.jooq.db;


import com.bsu.ugame.wechatgame.jooq.db.tables.RBoxGame;
import com.bsu.ugame.wechatgame.jooq.db.tables.RChannelBox;
import com.bsu.ugame.wechatgame.jooq.db.tables.RChannelauth3Game;
import com.bsu.ugame.wechatgame.jooq.db.tables.TBox;
import com.bsu.ugame.wechatgame.jooq.db.tables.TChannel;
import com.bsu.ugame.wechatgame.jooq.db.tables.TDailydata;
import com.bsu.ugame.wechatgame.jooq.db.tables.TGame;
import com.bsu.ugame.wechatgame.jooq.db.tables.THelpdata;
import com.bsu.ugame.wechatgame.jooq.db.tables.TPlayergame;
import com.bsu.ugame.wechatgame.jooq.db.tables.TPlayergameCopy;

import javax.annotation.Generated;


/**
 * Convenience access to all tables in login
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.0"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * The table <code>login.r_box_game</code>.
     */
    public static final RBoxGame R_BOX_GAME = com.bsu.ugame.wechatgame.jooq.db.tables.RBoxGame.R_BOX_GAME;

    /**
     * 该表为auth为3的开发商对应表
     */
    public static final RChannelauth3Game R_CHANNELAUTH3_GAME = com.bsu.ugame.wechatgame.jooq.db.tables.RChannelauth3Game.R_CHANNELAUTH3_GAME;

    /**
     * The table <code>login.r_channel_box</code>.
     */
    public static final RChannelBox R_CHANNEL_BOX = com.bsu.ugame.wechatgame.jooq.db.tables.RChannelBox.R_CHANNEL_BOX;

    /**
     * The table <code>login.t_box</code>.
     */
    public static final TBox T_BOX = com.bsu.ugame.wechatgame.jooq.db.tables.TBox.T_BOX;

    /**
     * The table <code>login.t_channel</code>.
     */
    public static final TChannel T_CHANNEL = com.bsu.ugame.wechatgame.jooq.db.tables.TChannel.T_CHANNEL;

    /**
     * The table <code>login.t_dailydata</code>.
     */
    public static final TDailydata T_DAILYDATA = com.bsu.ugame.wechatgame.jooq.db.tables.TDailydata.T_DAILYDATA;

    /**
     * The table <code>login.t_game</code>.
     */
    public static final TGame T_GAME = com.bsu.ugame.wechatgame.jooq.db.tables.TGame.T_GAME;

    /**
     * The table <code>login.t_helpdata</code>.
     */
    public static final THelpdata T_HELPDATA = com.bsu.ugame.wechatgame.jooq.db.tables.THelpdata.T_HELPDATA;

    /**
     * 玩家玩游戏产生的跟踪数据
     */
    public static final TPlayergame T_PLAYERGAME = com.bsu.ugame.wechatgame.jooq.db.tables.TPlayergame.T_PLAYERGAME;

    /**
     * 玩家玩游戏产生的跟踪数据
     */
    public static final TPlayergameCopy T_PLAYERGAME_COPY = com.bsu.ugame.wechatgame.jooq.db.tables.TPlayergameCopy.T_PLAYERGAME_COPY;
}
