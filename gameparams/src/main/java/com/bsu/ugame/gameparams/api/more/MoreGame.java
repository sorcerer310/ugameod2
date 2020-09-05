package com.bsu.ugame.gameparams.api.more;

import com.bsu.ugame.gameparams.collector.JSONArrayCollector;
import com.bsu.ugame.gameparams.jooq.db.tables.TMoregames;
import com.bsu.ugame.gameparams.tools.RetMsg;
import org.jooq.DSLContext;
import org.jooq.Record6;
import org.jooq.SelectJoinStep;
import org.jooq.types.UInteger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

/**
 * 跳转游戏
 */
@RestController
public class MoreGame {
    @Autowired
    private DSLContext dsl;

    /**
     * 根据gameappid查询跳转游戏数据
     * @param gameappid
     * @return
     */
    @GetMapping("/moregame")
    public String queryMoreGame(
            @RequestParam(value="gameappid",required=false)String gameappid
    ){
        TMoregames tmg = TMoregames.T_MOREGAMES;
        SelectJoinStep<Record6<UInteger,String,String,String,Integer,String>> sjs =dsl.select(tmg.ID,tmg.ICONURL,tmg.TITLE,tmg.JUMPAPPID,tmg.POSITION,tmg.PATH)
                .from(tmg);
        if(gameappid!=null && !gameappid.equals(""))
            sjs.where(tmg.GAMEAPPID.eq(String.valueOf(gameappid)));

        JSONArray ja = sjs.fetch().stream()
                .map(record->{
                    JSONObject jo = new JSONObject();
                    jo.put("id",record.value1());
                    jo.put("iconurl",record.value2());
                    jo.put("title",record.value3());
                    jo.put("jumpappid",record.value4());
                    jo.put("position",record.value5());
                    jo.put("path",record.value6());

                    return jo;
                }).collect(new JSONArrayCollector<>());

        return RetMsg.strMsgData(1000,"查询跳转游戏数据成功",ja);
    }

    /**
     * 根据id查询跳转游戏的数据
     * @param id
     * @return
     */
    @GetMapping("/moregame/{id}")
    public String queryMoreGameById(
            @PathVariable Integer id
    ){
        TMoregames tmg = TMoregames.T_MOREGAMES;
        JSONArray ja = dsl.select(tmg.ID,tmg.GAMEAPPID,tmg.ICONURL,tmg.TITLE,tmg.JUMPAPPID,tmg.POSITION,tmg.PATH)
                .from(tmg).where(tmg.ID.eq(UInteger.valueOf(id)))
                .fetch().stream()
                .map(record->{
                    JSONObject jo = new JSONObject();
                    jo.put("id",record.value1());
                    jo.put("gameappid",record.value2());
                    jo.put("iconurl",record.value3());
                    jo.put("title",record.value4());
                    jo.put("jumpappid",record.value5());
                    jo.put("position",record.value6());
                    jo.put("path",record.value7());
                    return jo;
                }).collect(new JSONArrayCollector<>());

        return RetMsg.strMsgData(1000,"查询跳转游戏数据成功",ja);
    }

    /**
     * 新建跳转游戏数据
     * @param params
     * @return
     */
    @PostMapping("/moregame")
    public String addMoreGame(
            @RequestBody String params
    ){
        JSONObject jo = new JSONObject(params).getJSONObject("params");
        String gameappid = jo.getString("gameappid");
        String iconurl = jo.getString("iconurl");
        String title = jo.getString("title");
        String jumpappid = jo.getString("jumpappid");
        Integer position = jo.getInt("position");
        String path = jo.getString("path");

        TMoregames tmg = TMoregames.T_MOREGAMES;
        int count = dsl.insertInto(tmg,tmg.GAMEAPPID,tmg.ICONURL,tmg.TITLE,tmg.JUMPAPPID,tmg.POSITION,tmg.PATH)
                .values(gameappid,iconurl,title,jumpappid,position,path)
                .execute();

        return count>0?RetMsg.strMsg(1000,"新建跳转游戏数据成功"):RetMsg.strMsg(1001, "新建跳转游戏数据失败");
    }

    /**
     * 更新跳转游戏
     * @param params
     * @return
     */
    @PutMapping("/moregame")
    public String modifyMoreGame(
            @RequestBody String params
    ){
        JSONObject jo = new JSONObject(params).getJSONObject("params");
        Integer id = jo.getInt("id");
        String iconurl = jo.getString("iconurl");
        String title = jo.getString("title");
        String jumpappid = jo.getString("jumpappid");
        Integer position = jo.getInt("position");
        String path = jo.getString("path");

        TMoregames tmg = TMoregames.T_MOREGAMES;
        int count = dsl.update(tmg).set(tmg.ICONURL,iconurl)
                .set(tmg.TITLE,title)
                .set(tmg.JUMPAPPID,jumpappid)
                .set(tmg.POSITION,position)
                .set(tmg.PATH,path)
                .where(tmg.ID.eq(UInteger.valueOf(id)))
                .execute();

        return count > 0 ? RetMsg.strMsg(1000, "更新跳转游戏数据成功") : RetMsg.strMsg(1001, "更新跳转游戏数据失败");
    }

    /**
     * 删除跳转游戏
     * @param id
     * @return
     */
    @DeleteMapping("/moregame/{id}")
    public String deleteMoreGame(
            @PathVariable Integer id
    ){
        TMoregames tmg = TMoregames.T_MOREGAMES;
        int count = dsl.delete(tmg).where(tmg.ID.eq(UInteger.valueOf(id))).execute();

        return count > 0 ? RetMsg.strMsg(1000, "删除跳转游戏数据成功") : RetMsg.strMsg(1001, "删除跳转游戏数据失败");
    }
}

















