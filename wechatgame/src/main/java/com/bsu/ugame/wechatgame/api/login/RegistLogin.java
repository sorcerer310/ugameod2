package com.bsu.ugame.wechatgame.api.login;

import com.bsu.ugame.wechatgame.jooq.db.tables.TChannel;
import com.bsu.ugame.wechatgame.tools.RetMsg;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.types.UInteger;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.util.UUID;
import java.util.concurrent.TimeUnit;


/**
 * 基础的注册与登录
 * Created by fengchong on 2017/10/1.
 */
@RestController
public class RegistLogin {
    private Logger logger_err = LoggerFactory.getLogger("ERROR_FILE");

    @Autowired
    DSLContext dsl;
    @Autowired
    StringRedisTemplate redis;

    @RequestMapping("/channel/login")
    public String login(
            @RequestParam("name") String name,
            @RequestParam("pwd") String pwd
    ) {
        JSONObject jo_ret = null;

        TChannel ta = TChannel.T_CHANNEL;
        Record2<UInteger,String> record = dsl.select(ta.ID,ta.AUTH).from(ta)
                .where(ta.ACCOUNT.eq(name).and(ta.PASSWORD.eq(pwd)))
                .fetchOne();

        if (record != null && record.size() >= 1) {
            //更新登录时间与登录ip
            UInteger id = record.value1();
            String auth = record.value2();
//                updateLoginIPAndTime(id);

            //创建新token，更新已登录时间
            //ugameod2为业务相关前缀
//            String token = createToken("ugameod2_"+id.toString());
            String token = createToken(id.toString(),auth);
            JSONObject jo_data = new JSONObject();
            jo_data.put("channelid",id);
            jo_data.put("token",token);
            jo_data.put("auth",auth);
            jo_ret = RetMsg.msgData(1000,"登录成功!",jo_data);
        }else{
            jo_ret = RetMsg.msg(1001,"登录失败，密码错误或用户不存在");
        }

        return jo_ret.toString();
    }

    /**
     * 创建token
     * @param userid    用户id
     * @param auth      用户权限
     * @return  返回创建好的token
     */
    private String createToken(String userid,String auth) {
        String token = UUID.randomUUID().toString().replace("-", "");
        JSONObject jo = new JSONObject();
        jo.put("name","ugameod2");
        jo.put("userid",userid);
        jo.put("auth",auth);
        redis.opsForValue().set("user_token." + token, jo.toString(), 15, TimeUnit.DAYS);                                    //token保留15天
        return token;
    }

    /**
     * 更新id用户的最后登录时间与最后登录ip
     *
     * @param
     * @return
     * @throws UnknownHostException
     */
    /*
    private int updateLoginIPAndTime(UInteger id) throws UnknownHostException {
        Timestamp login_time = U.getNowTimestamp();
        String ip = InetAddress.getLocalHost().getHostAddress();
        int ret = dsl.update(TUser.T_USER).set(TUser.T_USER.LAST_LOGIN_IP, ip)
                .set(TUser.T_USER.LAST_LOGIN_TIME, login_time)
                .where(TUser.T_USER.ID.eq(id))
                .execute();
        return ret;
    }
*/

    @RequestMapping("/user/regist")
    public String regist(
            @RequestParam("name") String name,
            @RequestParam("pwd") String pwd
    ) {
        JSONObject jo_ret = new JSONObject();
        /*
        try {
            TUserRecord tur = dsl.insertInto(T_USER, T_USER.NAME, T_USER.PWD_HASH, T_USER.LAST_LOGIN_TIME, T_USER.REGIST_TIME, T_USER.LAST_LOGIN_IP)
                    .values(name, pwd, U.getNowTimestamp(), U.getNowTimestamp(), InetAddress.getLocalHost().getHostAddress())
                    .returning(T_USER.ID)
                    .fetchOne();
            if (tur.size() > 0) {
                //为区分多个系统的id，增加前缀来表示当前id为基础系统id
                String token = createToken("basic_" + tur.getId().toString());
                JSONObject jo_data = new JSONObject();
                jo_data.put("token", token);
                jo_ret = RetMsg.msgData(1000, "注册成功！", jo_data);
            } else {
                jo_ret = RetMsg.msg(1001, "注册失败，注册数据未能正确录入系统");
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
            logger_err.info(e.toString());
        }
        */
        return jo_ret.toString();
    }

}
