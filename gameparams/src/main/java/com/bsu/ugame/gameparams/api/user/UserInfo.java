package com.bsu.ugame.gameparams.api.user;

import com.bsu.ugame.gameparams.jooq.db.tables.TUser;
import com.bsu.ugame.gameparams.tools.RetMsg;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserInfo {
    @Autowired
    DSLContext dsl;

    @GetMapping("/user/getAuthByUser")
    public String getAuthByUser(Principal principal){
        String username = principal.getName();
        TUser tu = TUser.T_USER;
        Record1<String> record1 = dsl.select(tu.AUTH).from(tu).where(tu.NAME.eq(username))
                .fetchOne();

        JSONArray ja = new JSONArray();
        JSONObject jo = new JSONObject();
        jo.put("auth",record1.value1());
        ja.put(jo);

        return RetMsg.strMsgData(1000,"查询用户权限成功",ja);
    }

}
