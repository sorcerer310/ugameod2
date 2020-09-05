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
public class Login extends SchemaImpl {

    private static final long serialVersionUID = -706512960;

    /**
     * The reference instance of <code>login</code>
     */
    public static final Login LOGIN = new Login();

    /**
     * The table <code>login.r_box_game</code>.
     */
    public final RBoxGame R_BOX_GAME = com.bsu.ugame.wechatgame.jooq.db.tables.RBoxGame.R_BOX_GAME;

    /**
     * 该表为auth为3的开发商对应表
     */
    public final RChannelauth3Game R_CHANNELAUTH3_GAME = com.bsu.ugame.wechatgame.jooq.db.tables.RChannelauth3Game.R_CHANNELAUTH3_GAME;

    /**
     * The table <code>login.r_channel_box</code>.
     */
    public final RChannelBox R_CHANNEL_BOX = com.bsu.ugame.wechatgame.jooq.db.tables.RChannelBox.R_CHANNEL_BOX;

    /**
     * The table <code>login.t_box</code>.
     */
    public final TBox T_BOX = com.bsu.ugame.wechatgame.jooq.db.tables.TBox.T_BOX;

    /**
     * The table <code>login.t_channel</code>.
     */
    public final TChannel T_CHANNEL = com.bsu.ugame.wechatgame.jooq.db.tables.TChannel.T_CHANNEL;

    /**
     * The table <code>login.t_dailydata</code>.
     */
    public final TDailydata T_DAILYDATA = com.bsu.ugame.wechatgame.jooq.db.tables.TDailydata.T_DAILYDATA;

    /**
     * The table <code>login.t_game</code>.
     */
    public final TGame T_GAME = com.bsu.ugame.wechatgame.jooq.db.tables.TGame.T_GAME;

    /**
     * The table <code>login.t_helpdata</code>.
     */
    public final THelpdata T_HELPDATA = com.bsu.ugame.wechatgame.jooq.db.tables.THelpdata.T_HELPDATA;

    /**
     * 玩家玩游戏产生的跟踪数据
     */
    public final TPlayergame T_PLAYERGAME = com.bsu.ugame.wechatgame.jooq.db.tables.TPlayergame.T_PLAYERGAME;

    /**
     * 玩家玩游戏产生的跟踪数据
     */
    public final TPlayergameCopy T_PLAYERGAME_COPY = com.bsu.ugame.wechatgame.jooq.db.tables.TPlayergameCopy.T_PLAYERGAME_COPY;

    /**
     * No further instances allowed
     */
    private Login() {
        super("login", null);
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
            RBoxGame.R_BOX_GAME,
            RChannelauth3Game.R_CHANNELAUTH3_GAME,
            RChannelBox.R_CHANNEL_BOX,
            TBox.T_BOX,
            TChannel.T_CHANNEL,
            TDailydata.T_DAILYDATA,
            TGame.T_GAME,
            THelpdata.T_HELPDATA,
            TPlayergame.T_PLAYERGAME,
            TPlayergameCopy.T_PLAYERGAME_COPY);
    }
}
