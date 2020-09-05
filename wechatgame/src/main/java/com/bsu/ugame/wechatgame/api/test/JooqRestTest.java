package com.bsu.ugame.wechatgame.api.test;

import com.bsu.ugame.wechatgame.config.AuthorSettings;
import org.jooq.DSLContext;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//import com.bsu.ugameod.jooq.db.tables.TUser;

/**
 * 数据库测试
 * Created by fengchong on 2017/5/21.
 */
@Controller
public class JooqRestTest {
    @Autowired
    DSLContext dsl;

    @RequestMapping("/jooqtest")
    @ResponseBody
    public String JooqTest(){
        JSONObject jo = new JSONObject();
//        jo.put("images",dsl.select(TUser.T_USER.ID).from(TUser.T_USER)
//                .where(TUser.T_USER.ID.eq(UInteger.valueOf(1)))
//                .fetch().stream()
//                .map(record1->record1.value1())
//                .collect(new JSONArrayCollector<>()));

        return jo.toString();
    }
}
