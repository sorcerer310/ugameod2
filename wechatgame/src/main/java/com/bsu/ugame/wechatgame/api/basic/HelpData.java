package com.bsu.ugame.wechatgame.api.basic;

import com.bsu.ugame.wechatgame.collector.JSONArrayCollector;
import com.bsu.ugame.wechatgame.jooq.db.tables.THelpdata;
import com.bsu.ugame.wechatgame.tools.RetMsg;
import org.jooq.DSLContext;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 互助数据
 */
@RestController
public class HelpData {
    @Autowired
    DSLContext dsl;

    /**
     * 写入互助数据
     * @param gameappid         游戏appid
     * @param originatorid      发起请求帮助者id
     * @param helptypeid        帮助类型位置id
     * @param helpid            帮助者id
     * @param helpnickname    帮助者昵称
     * @param helphead        帮助者头像
     * @return
     */
    @GetMapping("/sendhelpdata")
    public String postHelpData(
            @RequestParam("gameappid") String gameappid,
            @RequestParam("originatorid") String originatorid,
            @RequestParam("helptypeid") Integer helptypeid,
            @RequestParam("helpid") String helpid,
            @RequestParam(value="helpnickname",defaultValue = "",required = false) String helpnickname,
            @RequestParam(value="helphead",defaultValue = "",required = false) String helphead
    ){
        THelpdata thd = THelpdata.T_HELPDATA;
        int count = dsl.insertInto(thd,thd.GAMEAPPID,thd.ORIGINATORID,thd.HELPTYPEID,thd.HELPID
                ,thd.HELPNICKNAME,thd.HELPHEAD)
                .values(gameappid,originatorid,helptypeid,helpid,helpnickname,helphead)
                .execute();

        return count>0? RetMsg.strMsg(1000,"写入互助数据成功!"):RetMsg.strMsg(1001,"写入互助数据失败!");
    }

    /**
     * 获得帮助数据
     * @param gameappid     游戏appid
     * @param originatorid  发起帮助人的id
     * @param helptypeid    帮助的id
     * @return
     */
    @GetMapping("/gethelpdata")
    public String getHelpData(
            @RequestParam("gameappid") String gameappid,
            @RequestParam("originatorid") String originatorid,
            @RequestParam("helptypeid") Integer helptypeid
    ){
        THelpdata thd = THelpdata.T_HELPDATA;
        JSONArray ja = dsl.select(thd.HELPID,thd.HELPNICKNAME,thd.HELPHEAD).from(thd)
                .where(thd.GAMEAPPID.eq(gameappid).and(thd.ORIGINATORID.eq(originatorid)).and(thd.HELPTYPEID.eq(helptypeid)))
                .fetch().stream()
                .map(record->{
                    JSONObject jo = new JSONObject();
                    jo.put("helpid",record.value1());
                    jo.put("helpnickname",record.value2());
                    jo.put("helphead",record.value3());
                    return jo;
                })
                .collect(new JSONArrayCollector<>());

        return RetMsg.strMsgData(1000,"获得帮助数据成功！",ja);
    }
}
