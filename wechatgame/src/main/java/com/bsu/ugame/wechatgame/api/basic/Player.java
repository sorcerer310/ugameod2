package com.bsu.ugame.wechatgame.api.basic;

import com.bsu.ugame.wechatgame.collector.JSONArrayCollector;
import com.bsu.ugame.wechatgame.jooq.db.tables.TPlayergame;
import com.bsu.ugame.wechatgame.tools.RetMsg;
import org.jooq.DSLContext;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 玩家相关的接口
 */
@RestController
public class Player {
    @Autowired
    DSLContext dsl;

    @GetMapping("/player/recommended")
    public String queryRecommended(
            @RequestParam String gameappid,
            @RequestParam String openid
    ){
        TPlayergame tpg = TPlayergame.T_PLAYERGAME;

        JSONArray ja = dsl.select(tpg.NICKNAME,tpg.AVATARURL,tpg.OPENID).from(tpg).where(tpg.GAMEAPPID.eq(gameappid).and(tpg.RECOMMENDUSER.eq(openid)))
                .fetch().stream()
                .map(records->{
                    JSONObject jo = new JSONObject();
                    jo.put("nickname",records.value1());
                    jo.put("avatarurl",records.value2());
                    jo.put("openid",records.value3());

                    return jo;
                }).collect(new JSONArrayCollector<>());

        return RetMsg.strMsgData(1000,"查询邀请的玩家成功",ja);
    }
}
