package com.bsu.ugame.wechatgame.api.basic;

import com.bsu.ugame.wechatgame.collector.JSONArrayCollector;
import com.bsu.ugame.wechatgame.jooq.db.tables.RChannelBox;
import com.bsu.ugame.wechatgame.jooq.db.tables.TBox;
import com.bsu.ugame.wechatgame.jooq.db.tables.TDailydata;
import com.bsu.ugame.wechatgame.jooq.db.tables.TGame;
import com.bsu.ugame.wechatgame.tools.RetMsg;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Record9;
import org.jooq.types.UInteger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.stream.Stream;

/**
 * 日新增数据
 */
@RestController
public class DailyData {
    @Autowired
    DSLContext dsl;

    /**
     * 日常新增数据
     * @param boxid
     * @param gameid
     * @param channelid
     * @param date
     * @param auth
     * @return
     */
    @GetMapping("/dailydata")
    public String gameDailyData(
            @RequestParam(value = "boxid", required = false) Integer boxid,
            @RequestParam(value = "gameid", required = false) Integer gameid,
            @RequestParam("channelid") Integer channelid,
            @RequestParam("date") String date,
            @RequestAttribute("auth") String auth
    ) {
        LocalDate ld = LocalDate.parse(date);

        TDailydata tdd = TDailydata.T_DAILYDATA;
        TBox tb = TBox.T_BOX;
        TGame tg = TGame.T_GAME;
        RChannelBox rcb = RChannelBox.R_CHANNEL_BOX;

        //根据参数情况不同，提前创建条件
        Condition wcondition = tdd.CREATETIME.between(Timestamp.valueOf(ld.plusDays(1).atStartOfDay()), Timestamp.valueOf(ld.plusDays(2).atStartOfDay()));
        if (boxid != null && !boxid.equals(""))
            wcondition = wcondition.and(tb.ID.eq(UInteger.valueOf(boxid)));
        if (gameid != null && !gameid.equals(""))
            wcondition = wcondition.and(tg.ID.eq(UInteger.valueOf(gameid)));

        JSONArray ja = null;
        Stream<Record9<String, String, String, String, Integer, Integer, Timestamp, UInteger, UInteger>> stream = null;

        if (!auth.equals("2")) {
            stream = dsl.select(tdd.BOXAPPID, tb.BOXNAME, tdd.BOXAPPID, tg.GAMENAME, tdd.USERNUM, tdd.ACTIVEUSERNUM, tdd.CREATETIME, tb.ID, tg.ID).from(tdd)
                    .innerJoin(tb).on(tb.BOXAPPID.eq(tdd.BOXAPPID))
                    .innerJoin(tg).on(tg.GAMEAPPID.eq(tdd.GAMEAPPID))
                    .where(wcondition).orderBy(tdd.USERNUM.desc()).fetch().stream();
        } else {
            wcondition = wcondition.and(rcb.CHANNELID.eq(UInteger.valueOf(channelid)));
            stream = dsl.select(tdd.BOXAPPID, tb.BOXNAME, tdd.GAMEAPPID, tg.GAMENAME, tdd.USERNUM, tdd.ACTIVEUSERNUM, tdd.CREATETIME, tb.ID, tg.ID).from(tdd)
                    .innerJoin(tb).on(tb.BOXAPPID.eq(tdd.BOXAPPID))
                    .innerJoin(tg).on(tg.GAMEAPPID.eq(tdd.GAMEAPPID))
                    .innerJoin(rcb).on(rcb.BOXID.eq(tb.ID))
                    .where(wcondition).orderBy(tdd.USERNUM.desc())
                    .fetch().stream();
        }
        ja = stream.map(result -> {
            JSONObject jo = new JSONObject();
            jo.put("boxappid", result.value1());
            jo.put("boxname", result.value2());
            jo.put("gameappid", result.value3());
            jo.put("gamename", result.value4());
            jo.put("usernum", result.value5());
            jo.put("activeusernum", result.value6());
            jo.put("createtime", result.value7());
            jo.put("boxid", result.value8());
            jo.put("gameid", result.value9());
            return jo;
        }).collect(new JSONArrayCollector<>());

        return RetMsg.strMsgData(1000, "查询每日数据成功", ja);
    }
}
