package com.bsu.ugame.wechatgame.api.basic;

import com.bsu.ugame.wechatgame.collector.JSONArrayCollector;
import com.bsu.ugame.wechatgame.jooq.db.tables.*;
import com.bsu.ugame.wechatgame.jooq.db.tables.records.TGameRecord;
import com.bsu.ugame.wechatgame.tools.RetMsg;
import org.jooq.*;
import org.jooq.types.UInteger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.joda.LocalDateTimeParser;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.stream.Stream;

/**
 * 游戏数据
 */
@RestController
public class GameData {
    @Autowired
    DSLContext dsl;


    /**
     * 渠道对应的game app
     *
     * @param channelid 渠道id
     * @return
     */
    @GetMapping("/channel/game")
    public String channelGame(
            @RequestParam("channelid") String channelid,
            @RequestParam(value = "boxid", required = false) Integer boxid,
            @RequestAttribute("auth") String auth
    ) {
        RChannelBox rcb = RChannelBox.R_CHANNEL_BOX;
        RBoxGame rbg = RBoxGame.R_BOX_GAME;
        TGame tg = TGame.T_GAME;

        //根据权限设置查询条件
        Stream<Record3<UInteger, String, String>> stream = null;

        if (!auth.equals("2")) {
            stream = dsl.select(tg.ID, tg.GAMENAME, tg.GAMEAPPID).from(tg)
                    .fetch().stream();
        } else {
            Condition c = rcb.CHANNELID.eq(UInteger.valueOf(channelid));
            if (boxid != null && !boxid.equals(""))
                c = c.and(rcb.BOXID.eq(UInteger.valueOf(boxid)));

            stream = dsl.select(tg.ID, tg.GAMENAME, tg.GAMEAPPID).from(tg)
                    .innerJoin(rbg).on(tg.ID.eq(rbg.GAMEID))
                    .innerJoin(rcb).on(rbg.BOXID.eq(rcb.BOXID))
                    .where(c)
                    .fetch().stream();
        }

        JSONArray ja = stream.map(result -> {
            JSONObject jo = new JSONObject();
            jo.put("gameid", result.value1());
            jo.put("gamename", result.value2());
            jo.put("gameappid", result.value3());
            return jo;
        }).collect(new JSONArrayCollector<>());

        return RetMsg.strMsgData(1000, "查询游戏数据成功", ja);
    }



    /**
     * 根据盒子id获得当前盒子下的游戏
     *
     * @param boxid
     * @return
     */
    @GetMapping("/game/{boxid}")
    public String getGameByBoxid(
            @PathVariable Integer boxid
    ) {
        TGame tg = TGame.T_GAME;
        RBoxGame rbg = RBoxGame.R_BOX_GAME;
        return RetMsg.strMsgData(1000, "查询成功", dsl.select(tg.ID, tg.GAMENAME, tg.GAMEAPPID, tg.SECRECT)
                .from(tg)
                .innerJoin(rbg).on(rbg.GAMEID.eq(tg.ID))
                .where(rbg.BOXID.eq(UInteger.valueOf(boxid)))
                .fetch().stream()
                .map(record -> {
                    JSONObject jo = new JSONObject();
                    jo.put("gameid", record.value1());
                    jo.put("gamename", record.value2());
                    jo.put("gameappid", record.value3());
                    jo.put("secrect", record.value4());

                    return jo;
                }).collect(new JSONArrayCollector<>()));
    }

    /**
     * @param boxid
     * @return
     */
    @PostMapping("/game/{boxid}")
    public String addGameData(
            @PathVariable Integer boxid,
            @RequestBody String params
    ) {
        JSONObject jo_params = new JSONObject(params).getJSONObject("params");
        String gamename = jo_params.getString("gamename");
        String gameappid = jo_params.getString("gameappid");
        String secrect = jo_params.getString("secrect");

        TGame tg = TGame.T_GAME;
        RBoxGame rbg = RBoxGame.R_BOX_GAME;
        //1:增加游戏数据
        TGameRecord tgr = dsl.insertInto(tg,tg.GAMENAME,tg.GAMEAPPID,tg.SECRECT)
                .values(gamename,gameappid,secrect)
                .returning(tg.ID).fetchOne();
        //2:增加游戏与盒子的关系数据
        int count = dsl.insertInto(rbg,rbg.BOXID,rbg.GAMEID)
                .values(UInteger.valueOf(boxid),tgr.value1())
                .execute();

        return count > 0 ? RetMsg.strMsg(1000, "新建游戏数据成功") : RetMsg.strMsg(1001, "新建游戏数据失败");
    }

    @PutMapping("/game/{gameid}")
    public String modifyGameData(
            @PathVariable Integer gameid,
            @RequestBody String params
    ){
        JSONObject jo_params = new JSONObject(params).getJSONObject("params");
        String gamename = jo_params.getString("gamename");
        String gameappid = jo_params.getString("gameappid");
        String secrect = jo_params.getString("secrect");

        TGame tg = TGame.T_GAME;
        int count = dsl.update(tg).set(tg.GAMENAME,gamename)
                .set(tg.GAMEAPPID,gameappid)
                .set(tg.SECRECT,secrect)
                .where(tg.ID.eq(UInteger.valueOf(gameid)))
                .execute();
        return count > 0 ? RetMsg.strMsg(1000, "更新游戏数据成功") : RetMsg.strMsg(1001, "更新游戏数据失败");
    }

    @DeleteMapping("/game/{boxid}/{gameid}")
    public String deleteGameData(
            @PathVariable Integer boxid,
            @PathVariable Integer gameid
    ){
        TGame tg = TGame.T_GAME;
        RBoxGame rbg = RBoxGame.R_BOX_GAME;
        //1:删除游戏与盒子的关系
        dsl.delete(rbg).where(rbg.BOXID.eq(UInteger.valueOf(boxid)).and(rbg.GAMEID.eq(UInteger.valueOf(gameid))))
                .execute();
        //2:删除游戏数据
        int count = dsl.delete(tg).where(tg.ID.eq(UInteger.valueOf(gameid))).execute();

        return count > 0 ? RetMsg.strMsg(1000, "删除游戏数据成功") : RetMsg.strMsg(1001, "删除游戏数据失败");
    }
}


















