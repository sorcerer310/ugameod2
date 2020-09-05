package com.bsu.ugame.gameparams.api.game;

import com.bsu.ugame.gameparams.collector.JSONArrayCollector;
import com.bsu.ugame.gameparams.jooq.db.tables.RUserGame;
import com.bsu.ugame.gameparams.jooq.db.tables.TGame;
import com.bsu.ugame.gameparams.jooq.db.tables.TUser;
import com.bsu.ugame.gameparams.tools.RetMsg;
import org.jooq.DSLContext;
import org.jooq.types.UInteger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
public class Game {
    @Autowired
    DSLContext dsl;

    /**
     * 查询所有的游戏数据
     * @return
     */
    @GetMapping("/game")
    public String getGame(){
        TGame tg = TGame.T_GAME;
        JSONArray ja = dsl.select(tg.ID,tg.GAMEAPPID,tg.GAMENAME,tg.SECRET).from(tg)
                .fetch().stream()
                .map(record->{
                    JSONObject jo = new JSONObject();
                    jo.put("id",record.value1());
                    jo.put("gameappid",record.value2());
                    jo.put("gamename",record.value3());
                    jo.put("secret",record.value4());
                    return jo;
                }).collect(new JSONArrayCollector<>());

        return RetMsg.strMsgData(1000,"查询游戏信息",ja);
    }


    @GetMapping("/gamebyuserid")
    public String getGameByUserid(Principal user){
        String uname = user.getName();
        TGame tg = TGame.T_GAME;
        TUser tu = TUser.T_USER;
        RUserGame rug = RUserGame.R_USER_GAME;
        JSONArray ja = dsl.select(tg.ID,tg.GAMEAPPID,tg.GAMENAME,tg.SECRET).from(tg)
                .innerJoin(rug).on(rug.GAMEID.eq(tg.ID))
                .innerJoin(tu).on(tu.ID.eq(rug.USERID))
                .where(tu.NAME.eq(uname))
                .fetch().stream()
                .map(record->{
                    JSONObject jo = new JSONObject();
                    jo.put("id",record.value1());
                    jo.put("gameappid",record.value2());
                    jo.put("gamename",record.value3());
                    jo.put("secret",record.value4());
                    return jo;
                }).collect(new JSONArrayCollector<>());

        return RetMsg.strMsgData(1000,"查询游戏信息",ja);
    }

    /**
     * 新建游戏数据
     * @param params
     * @return
     */
    @PostMapping("/game")
    public String addGame(
            @RequestBody String params
    ){
        JSONObject jo = new JSONObject(params).getJSONObject("params");
        String gameappid = jo.getString("gameappid");
        String secret = jo.getString("secret");
        String gamename = jo.getString("gamename");

        TGame tg = TGame.T_GAME;
        int count = dsl.insertInto(tg,tg.GAMEAPPID,tg.SECRET,tg.GAMENAME)
                .values(gameappid,secret,gamename)
                .execute();

        return count>0?RetMsg.strMsg(1000,"新建产品数据成功"):RetMsg.strMsg(1001, "新建产品数据失败");
    }

    /**
     * 更新游戏产品数据
     * @param params
     * @return
     */
    @PutMapping("/game")
    public String modifyGame(
            @RequestBody String params
    ){
        JSONObject jo = new JSONObject(params).getJSONObject("params");
        Integer id = jo.getInt("id");
        String gameappid = jo.getString("gameappid");
        String secret = jo.getString("secret");
        String gamename = jo.getString("gamename");

        TGame tg = TGame.T_GAME;
        int count = dsl.update(tg).set(tg.GAMEAPPID,gameappid)
                .set(tg.SECRET,secret)
                .set(tg.GAMENAME,gamename)
                .where(tg.ID.eq(UInteger.valueOf(id)))
                .execute();

        return count > 0 ? RetMsg.strMsg(1000, "更新产品数据成功") : RetMsg.strMsg(1001, "更新产品数据失败");
    }

    @DeleteMapping("/game/{id}")
    public String deleteGame(
            @PathVariable Integer id
    ){
        TGame tg = TGame.T_GAME;
        int count = dsl.delete(tg).where(tg.ID.eq(UInteger.valueOf(id))).execute();

        return count > 0 ? RetMsg.strMsg(1000, "删除产品数据成功") : RetMsg.strMsg(1001, "删除产品数据失败");
    }

}
