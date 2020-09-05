package com.bsu.ugame.wechatgame.api.basic;

import com.bsu.ugame.wechatgame.collector.JSONArrayCollector;
import com.bsu.ugame.wechatgame.jooq.db.tables.RChannelauth3Game;
import com.bsu.ugame.wechatgame.jooq.db.tables.TDailydata;
import com.bsu.ugame.wechatgame.jooq.db.tables.TGame;
import com.bsu.ugame.wechatgame.tools.RetMsg;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.types.UInteger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.LocalDate;

/**
 * 与开发者相关的一些方法
 */
@RestController
public class ChannelAuth3 {
    @Autowired
    DSLContext dsl;

    /**
     * 根据开发者的channelid查询游戏数据
     * @param channelid
     * @return
     */
    @GetMapping("channelauth3/game/{channelid}")
    public String getChannelauth3Game(
            @PathVariable Integer channelid
    ){
        TGame tg = TGame.T_GAME;
        RChannelauth3Game rc3g = RChannelauth3Game.R_CHANNELAUTH3_GAME;
        return RetMsg.strMsgData(1000,"查询成功",dsl.select(tg.ID,tg.GAMENAME,tg.GAMEAPPID,tg.SECRECT).from(tg)
                .innerJoin(rc3g).on(tg.ID.eq(rc3g.GAMEID))
                .where(rc3g.CHANNELID.eq(UInteger.valueOf(channelid)))
                .fetch().stream()
                .map(record->{
                    JSONObject jo = new JSONObject();
                    jo.put("gameid",record.value1());
                    jo.put("gamename",record.value2());
                    jo.put("gameappid",record.value3());
                    jo.put("secrect",record.value4());
                    return jo;
                }).collect(new JSONArrayCollector<>()));
    }


    /**
     * 查看开发商的数据
     * @param gameappid
     * @param channelid
     * @param date
     * @return
     */
    @GetMapping("cpdailydata")
    public String cpDailyData(
            @RequestParam(value="gameappid",required = false) String gameappid,
            @RequestParam("channelid") Integer channelid,
            @RequestParam("date") String date
    ){
        LocalDate ld = LocalDate.parse(date);

        TDailydata td = TDailydata.T_DAILYDATA;
        TGame tg = TGame.T_GAME;
        RChannelauth3Game rcg = RChannelauth3Game.R_CHANNELAUTH3_GAME;

        Condition wc = td.CREATETIME.between(Timestamp.valueOf(ld.plusDays(1).atStartOfDay()), Timestamp.valueOf(ld.plusDays(2).atStartOfDay()))
                .and(rcg.CHANNELID.eq(UInteger.valueOf(channelid)));
        if(gameappid != null && !gameappid.equals(""))
            wc = wc.and(td.GAMEAPPID.eq(gameappid));

        return RetMsg.strMsgData(1000,"查询成功",dsl.select(tg.GAMENAME,td.USERNUM.sum(),td.ACTIVEUSERNUM.sum(),td.CREATETIME.min())
                .from(td)
                .innerJoin(tg).on(tg.GAMEAPPID.eq(td.GAMEAPPID))
                .innerJoin(rcg).on(rcg.GAMEID.eq(tg.ID))
                .where(wc)
                .groupBy(tg.GAMENAME)
                .fetch().stream()
                .map(record->{
                    JSONObject jo = new JSONObject();
                    jo.put("gamename",record.value1());
                    jo.put("usernum",record.value2());
                    jo.put("activeusernum",record.value3());
                    jo.put("createtime",record.value4());

                    return jo;
                }).collect(new JSONArrayCollector<>()));

    }
}
























