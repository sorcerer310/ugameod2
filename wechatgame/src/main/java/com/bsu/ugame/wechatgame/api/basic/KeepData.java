package com.bsu.ugame.wechatgame.api.basic;

import com.bsu.ugame.wechatgame.collector.JSONArrayCollector;
import com.bsu.ugame.wechatgame.jooq.db.tables.*;
import com.bsu.ugame.wechatgame.tools.RetMsg;
import org.jooq.*;
import org.jooq.types.UInteger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.stream.Stream;

/**
 * 留存数据
 */
@RestController
public class KeepData {
    @Autowired
    DSLContext dsl;

    private NumberFormat nt = NumberFormat.getPercentInstance();

    /**
     * 计算方法：昨天、前天、7日前新增的用户截止到今天的留存情况
     * @param boxid
     * @param gameid
     * @param channelid
     * @param date
     * @param auth
     * @return
     */
    @GetMapping("/keepdata")
    public String keepData(
            @RequestParam(value = "boxid", required = false) Integer boxid,
            @RequestParam(value = "gameid", required = false) Integer gameid,
            @RequestParam("channelid") Integer channelid,
            @RequestParam("date") String date,
            @RequestAttribute("auth") String auth
    ){
        nt.setMinimumFractionDigits(2);
        LocalDate ld = LocalDate.parse(date);
        TDailydata tdd = TDailydata.T_DAILYDATA;
        TPlayergame tpg = TPlayergame.T_PLAYERGAME;
        TBox tb = TBox.T_BOX;
        TGame tg = TGame.T_GAME;
        RChannelBox rcb = RChannelBox.R_CHANNEL_BOX;

        //根据参数情况不同，提前创建条件
        Condition wc = tdd.CREATETIME.between(Timestamp.valueOf(ld.plusDays(1).atStartOfDay()), Timestamp.valueOf(ld.plusDays(2).atStartOfDay()));
        if (boxid != null && !boxid.equals(""))
            wc = wc.and(tb.ID.eq(UInteger.valueOf(boxid)));
        if (gameid != null && !gameid.equals(""))
            wc = wc.and(tg.ID.eq(UInteger.valueOf(gameid)));


        //1:获得指定日期新增人数
        Record1<Integer> rcount = dsl.select(tpg.OPENID.count()).from(tpg)
                .where(tpg.CREATETIME.between(Timestamp.valueOf(ld.plusDays(1).atStartOfDay()), Timestamp.valueOf(ld.plusDays(2).atStartOfDay()))).fetchOne();
        float newuser = rcount.value1();

        //2:带入新增人数获得留存率
        JSONArray ja = null;
        Stream<Record10<String,String,String,String,BigDecimal,BigDecimal,BigDecimal,Timestamp,UInteger,UInteger>> stream = null;

        if(!auth.equals("2")){
            stream = dsl.select(tdd.BOXAPPID,tb.BOXNAME,tdd.BOXAPPID,tg.GAMENAME,tdd.NEXTDAYLEFTRATE,tdd.THREEDAYSLEFTRATE,tdd.SEVENDAYSLEFTRATE,tdd.CREATETIME,tb.ID,tg.ID).from(tdd)
                    .innerJoin(tb).on(tb.BOXAPPID.eq(tdd.BOXAPPID))
                    .innerJoin(tg).on(tg.GAMEAPPID.eq(tdd.GAMEAPPID))
                    .where(wc).orderBy(tdd.NEXTDAYLEFTRATE.desc())
                    .fetch().stream();
        }else{
            wc = wc.and(rcb.CHANNELID.eq(UInteger.valueOf(channelid)));
            stream = dsl.select(tdd.BOXAPPID, tb.BOXNAME, tdd.GAMEAPPID, tg.GAMENAME, tdd.NEXTDAYLEFTRATE, tdd.THREEDAYSLEFTRATE, tdd.SEVENDAYSLEFTRATE,tdd.CREATETIME, tb.ID, tg.ID).from(tdd)
                    .innerJoin(tb).on(tb.BOXAPPID.eq(tdd.BOXAPPID))
                    .innerJoin(tg).on(tg.GAMEAPPID.eq(tdd.GAMEAPPID))
                    .innerJoin(rcb).on(rcb.BOXID.eq(tb.ID))
                    .where(wc).orderBy(tdd.NEXTDAYLEFTRATE.desc())
                    .fetch().stream();
        }
        ja = stream.map(record ->{


            JSONObject jo = new JSONObject();
            jo.put("boxappid",record.value1());
            jo.put("boxname",record.value2());
            jo.put("gameappid",record.value3());
            jo.put("gamename",record.value4());
            jo.put("nextdayleft",nt.format(record.value5()));
            jo.put("threedaysleft",nt.format(record.value6()));
            jo.put("sevendaysleft",nt.format(record.value7()));
            jo.put("createtime",record.value8());
            jo.put("boxid",record.value9());
            jo.put("gameid",record.value10());

            return jo;
        }).collect(new JSONArrayCollector<>());

        return RetMsg.strMsgData(1000,"查询留存数据成功",ja);
    }

    /**
     * (已废弃)
     * 计算方法：今天的新增数据在将来的 次日、3日后、7日后的留存数据
     * @param boxid
     * @param gameid
     * @param channelid
     * @param date
     * @param auth
     * @return
     */
    @GetMapping("/keepdata_todayadd")
    public String keepDataTodayAdd(
            @RequestParam(value = "boxid", required = false) Integer boxid,
            @RequestParam(value = "gameid", required = false) Integer gameid,
            @RequestParam("channelid") Integer channelid,
            @RequestParam("date") String date,
            @RequestAttribute("auth") String auth
    ) {
        nt.setMinimumFractionDigits(2);
        LocalDate ld = LocalDate.parse(date);
        TDailydata tdd = TDailydata.T_DAILYDATA;
        TPlayergame tpg = TPlayergame.T_PLAYERGAME;
        TBox tb = TBox.T_BOX;
        TGame tg = TGame.T_GAME;
        RChannelBox rcb = RChannelBox.R_CHANNEL_BOX;

        //根据参数情况不同，提前创建条件
        Condition wc = tdd.CREATETIME.between(Timestamp.valueOf(ld.plusDays(1).atStartOfDay()), Timestamp.valueOf(ld.plusDays(2).atStartOfDay()));
        if (boxid != null && !boxid.equals(""))
            wc = wc.and(tb.ID.eq(UInteger.valueOf(boxid)));
        if (gameid != null && !gameid.equals(""))
            wc = wc.and(tg.ID.eq(UInteger.valueOf(gameid)));

        //1:获得指定日期次日活跃人数
        Record1<Integer> rnextday = dsl.select(tpg.OPENID.count()).from(tpg)

                .where(tpg.LASTLOGINTIME.between(Timestamp.valueOf(ld.plusDays(2).atStartOfDay()), Timestamp.valueOf(ld.plusDays(3).atStartOfDay())).and(wc)).fetchOne();
        float nextActivationUser = rnextday.value1();

        //2:获得指定日期3日活跃人数
        Record1<Integer> rthreeday = dsl.select(tpg.OPENID.count()).from(tpg)
                .where(tpg.LASTLOGINTIME.between(Timestamp.valueOf(ld.plusDays(3).atStartOfDay()),Timestamp.valueOf(ld.plusDays(4).atStartOfDay())).and(wc)).fetchOne();
        float threeActivationUser = rthreeday.value1();

        //3:获得指定日期7日活跃人数
        Record1<Integer> rsevenday = dsl.select(tpg.OPENID.count()).from(tpg)
                .where(tpg.LASTLOGINTIME.between(Timestamp.valueOf(ld.plusDays(7).atStartOfDay()),Timestamp.valueOf(ld.plusDays(8).atStartOfDay())).and(wc)).fetchOne();
        float sevenActivationUser = rthreeday.value1();

        //4:获得今天的新增人数
        JSONArray ja = null;
        Stream<Record7<String,String,String,String,Timestamp,UInteger,UInteger>> stream = null;

        if(!auth.equals("2")){
            stream = dsl.select(tdd.BOXAPPID,tb.BOXNAME,tdd.BOXAPPID,tg.GAMENAME,tdd.CREATETIME,tb.ID,tg.ID).from(tdd)
                    .innerJoin(tb).on(tb.BOXAPPID.eq(tdd.BOXAPPID))
                    .innerJoin(tg).on(tg.GAMEAPPID.eq(tdd.GAMEAPPID))
                    .where(wc).orderBy(tdd.NEXTDAYLEFT.desc())
                    .fetch().stream();
        }else{
            wc = wc.and(rcb.CHANNELID.eq(UInteger.valueOf(channelid)));
            stream = dsl.select(tdd.BOXAPPID, tb.BOXNAME, tdd.GAMEAPPID, tg.GAMENAME,tdd.CREATETIME, tb.ID, tg.ID).from(tdd)
                    .innerJoin(tb).on(tb.BOXAPPID.eq(tdd.BOXAPPID))
                    .innerJoin(tg).on(tg.GAMEAPPID.eq(tdd.GAMEAPPID))
                    .innerJoin(rcb).on(rcb.BOXID.eq(tb.ID))
                    .where(wc).orderBy(tdd.NEXTDAYLEFT.desc())
                    .fetch().stream();
        }
        ja = stream.map(record ->{


            JSONObject jo = new JSONObject();
            jo.put("boxappid",record.value1());
            jo.put("boxname",record.value2());
            jo.put("gameappid",record.value3());
            jo.put("gamename",record.value4());
            jo.put("createtime",record.value5());
            jo.put("boxid",record.value6());
            jo.put("gameid",record.value7());

            return jo;
        }).collect(new JSONArrayCollector<>());

        return RetMsg.strMsgData(1000,"查询成功",ja);
    }
}
