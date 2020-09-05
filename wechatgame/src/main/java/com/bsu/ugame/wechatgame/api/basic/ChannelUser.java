package com.bsu.ugame.wechatgame.api.basic;

import com.bsu.ugame.wechatgame.collector.JSONArrayCollector;
import com.bsu.ugame.wechatgame.jooq.db.tables.TChannel;
import com.bsu.ugame.wechatgame.tools.RetMsg;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.types.UInteger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 渠道用户登录等操作
 */
@RestController
public class ChannelUser {
    @Autowired
    private DSLContext dsl;
    @Autowired
    private StringRedisTemplate redis;
    @Autowired
    private HttpServletRequest req;

    @PostMapping("wechatgame/login")
    public String wechatGameLogin(
            @RequestParam String name,
            @RequestParam String pwd
    ){
        TChannel ta = TChannel.T_CHANNEL;
        Record1<UInteger> record = dsl.select(ta.ID).from(ta)
                .where(ta.ACCOUNT.eq(name).and(ta.PASSWORD.eq(pwd)).and(ta.AUTH.eq("2")))
                .fetchOne();

        if(record!=null && record.size()>0)
            return RetMsg.strMsg(1000,"登录成功");
        else
            return RetMsg.strMsg(1001,"登录失败");
    }

    /**
     * 查询所有的用户数据
     * @return
     */
    @GetMapping("/channel/all")
    public String getChannelUser(){
       TChannel tc = TChannel.T_CHANNEL;
       JSONArray ja = dsl.select(tc.ID,tc.ACCOUNT,tc.CHANNELNAME,tc.EMAIL,tc.PHONE)
               .from(tc)
               .fetch().stream()
               .map(record->{
                   JSONObject jo = new JSONObject();
                   jo.put("id",record.value1());
                   jo.put("account",record.value2());
                   jo.put("channelname",record.value3());
                   jo.put("email",record.value4());
                   jo.put("phone",record.value5());
                   return jo;
               }).collect(new JSONArrayCollector<>());
        return RetMsg.strMsgData(1000,"查询成功",ja);
    }

    /**
     * 根据权限获得渠道用户
     * 如果权限为1，获得所有用户，如果权限为2只获得自己的用户
     * @return
     */
    @GetMapping("/channel/auth")
    public String getChannelAuth(
            @RequestAttribute String userid
    ){
        //从attribute中获得权限
        int auth = Integer.parseInt(req.getAttribute("auth").toString());
        if(auth==1)
            return getChannelUser();
        else{
            return getChannelUserById(Integer.valueOf(userid));
        }
    }

    /**
     * 根据id查询用户资料
     * @return
     */
    @GetMapping("/channel/{channelid}")
    public String getChannelUserById(
            @PathVariable Integer channelid
    ){

        TChannel tc = TChannel.T_CHANNEL;
        Record5<UInteger,String,String,String,String> record = dsl.select(tc.ID,tc.ACCOUNT,tc.CHANNELNAME,tc.EMAIL,tc.PHONE)
                .from(tc).where(tc.ID.eq(UInteger.valueOf(channelid)))
                .fetchOne();

        JSONObject jo = new JSONObject();
        jo.put("id",record.value1());
        jo.put("account",record.value2());
        jo.put("channelname",record.value3());
        jo.put("email",record.value4());
        jo.put("phone",record.value5());

        return RetMsg.strMsgData(1000,"查询成功",jo);
    }

    /**
     * 增加渠道数据
     * @return
     */
    @PostMapping("/channel")
    public String addChannelUser(
            @RequestBody String params
    ){
        JSONObject jo = new JSONObject(params).getJSONObject("params");
        String account = jo.getString("account");
        String password = jo.getString("password");
        String channelname = jo.getString("channelname");
        String email = jo.getString("email");
        String phone = jo.getString("phone");

        if(account==null || account.equals("") || password==null || password.equals(""))
            return RetMsg.strMsg(1001,"账号或密码不能为空");

        TChannel tc = TChannel.T_CHANNEL;
        int count = dsl.insertInto(tc,tc.ACCOUNT,tc.PASSWORD,tc.CHANNELNAME,tc.EMAIL,tc.PHONE,tc.AUTH)
                .values(account,password,channelname,email,phone,"2")
                .execute();

        return count>0?RetMsg.strMsg(1000,"添加渠道数据成功"):RetMsg.strMsg(1001,"添加渠道数据失败");
    }

    /**
     * 更新渠道数据
     * @param id
     * @return
     */
    @PutMapping("/channel/{id}")
    public String updateChannelUser(
            @PathVariable("id") Integer id,
            @RequestBody String data
    ){
        JSONObject jo = new JSONObject(data).getJSONObject("params");
        String channelname = jo.getString("channelname");
        String email = jo.getString("email");
        String phone = jo.getString("phone");

        TChannel tc = TChannel.T_CHANNEL;
        int count = dsl.update(tc).set(tc.CHANNELNAME,channelname)
                .set(tc.EMAIL,email)
                .set(tc.PHONE,phone)
                .where(tc.ID.eq(UInteger.valueOf(id)))
                .execute();

        return count>0?RetMsg.strMsg(1000,"更新渠道数据成功"):RetMsg.strMsg(1001,"更新渠道数据失败");
    }

    /**
     * 删除渠道数据
     * @param id
     * @return
     */
    @DeleteMapping("/channel/{id}")
    public String deleteChannelUser(
            @PathVariable("id") Integer id
    ){
        TChannel tc = TChannel.T_CHANNEL;
        int count = dsl.delete(tc).where(tc.ID.eq(UInteger.valueOf(id)))
                .execute();

        return count>0?RetMsg.strMsg(1000,"删除渠道数据成功"):RetMsg.strMsg(1001,"删除渠道数据失败");
    }

}
