package com.bsu.ugame.gameparams.wechat;

import com.bsu.ugame.gameparams.jooq.db.tables.TGame;
import com.bsu.ugame.gameparams.jooq.db.tables.TPlayer;
import com.bsu.ugame.gameparams.jooq.db.tables.records.TPlayerRecord;
import com.bsu.ugame.gameparams.tools.RetMsg;
import com.bsu.ugame.gameparams.tools.U;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.types.UInteger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.AlgorithmParameters;
import java.security.Security;
import java.util.Arrays;
import java.util.HashMap;

//import com.starsea.aircraft.Jooq.db.tables.records.AircraftPlayerRecord;
//import com.starsea.aircraft.Jooq.db.tables.records.AircraftSwitchRecord;
//import com.starsea.aircraft.tools.JSONArrayCollector;

//import static com.starsea.aircraft.Jooq.db.tables.AircraftPlayer.AIRCRAFT_PLAYER;
//import static com.starsea.aircraft.Jooq.db.tables.AircraftSwitch.AIRCRAFT_SWITCH;

@RestController
public class HttpCenter {

    @Autowired
    DSLContext dslContext;

    @RequestMapping("/userreg")
    public String UserReg(
            @RequestParam("js_code") String code,                                                                       //客户端传递的微信登录临时code标识
            @RequestParam("encryptedData") String encryptedData,                                                        //客户端传递的用户加密数据
            @RequestParam("iv") String iv,                                                                              //客户端传递的微信登录的加密初始向量
            @RequestParam("fromappid") String fromappid,                                                                //来源渠道的appid
            @RequestParam("gameid") String gameid,                                                                       //要记录数据的游戏的appid
            @RequestParam(value = "recommendUser",required = false) String recmooendUser                                //记录推荐人的openid
    ) {

        //首先根据appid,secret,js_code,grant_type获得openid

        HttpClient httpClient = new HttpClient();
        String url = "https://api.weixin.qq.com/sns/jscode2session";
        HttpMethod method = HttpMethod.POST;
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
//		params.add("appid", pconfig.getId());
//		params.add("secret", pconfig.getSer());


        params.add("appid", gameid);
        params.add("secret", getGameSecret(gameid));
        params.add("js_code", code);
        params.add("grant_type", "authorization");
        JSONObject js_ret = new JSONObject();

        //发送http请求并返回结果
        String result = httpClient.client(url, method, params);
        ObjectMapper mapper = new ObjectMapper();
        HashMap<String, Object> res = null;
        try {
            res = mapper.readValue(result, HashMap.class);
//            if (res == null || res.get("errcode") == null)
//                return RetMsg.strMsg(1001, "请求微信服务器失败。");

        } catch (Exception e) {
            e.printStackTrace();
            return RetMsg.strMsg(1001, "请求微信服务器异常。" + e.toString());
        }


        //从wechat服务器获得session_key
        String session = (String) res.get("session_key");
        //解析出用户信息
        String userinfo = getUserInfo(encryptedData, session, iv);

        ObjectMapper amapper = new ObjectMapper();
        HashMap<String, Object> ares = null;

        int state = 0;
        try {
            ares = amapper.readValue(userinfo, HashMap.class);
            if (ares == null || ares.get("errcode") != null || ares.get("openId").equals("") || ares.get("openId") == null)
                return RetMsg.strMsg(1001, "请求用户信息失败。");

            //1:将用户数据写入数据库
            System.out.print("userreg: ");
            state = register(ares, gameid, fromappid.equals("undefined") == true ? "default" : fromappid,recmooendUser);

        } catch (Exception e) {
            e.printStackTrace();
            return RetMsg.strMsg(1001, "解析返回数据异常。" + e.toString());
        }



        //2:返回是否正确操作的状态值
        if (state > 0)
            return RetMsg.success().toString();
        else
            return RetMsg.strMsg(1001, "操作失败，数据库中没有openid为:" + ares.get("openId").toString() + "的用户数据。");


//			String notice=this.getNotice();
//        js_ret.put("openid", ares.get("openId"));
//			js_ret.put("notice",notice);
//        return js_ret.toString();

//        js_ret.put("result", -1);
//        return js_ret.toString();
    }

    /**
     * 通过渠道来源小程序的appid查询对应的游戏appid与secret
     *
     * @param gameid 小游戏的id
     * @return 返回该gameid对应secret
     */
    private String getGameSecret(String gameid) {
        TGame tg = TGame.T_GAME;
        Record1<String> record = dslContext.select(tg.SECRET).from(tg)
                .where(tg.GAMEAPPID.eq(gameid))
                .fetchOne();

        if (record.size() > 0)
            return record.value1();
        else
            return "";
    }

    /**
     * 根据数据解密用户数据信息
     *
     * @param encryptedData
     * @param sessionKey
     * @param iv
     * @return
     */
    public static String getUserInfo(String encryptedData, String sessionKey, String iv) {
        // 被加密的数据
        byte[] dataByte = Base64.decode(encryptedData);
        // 加密秘钥
        byte[] keyByte = Base64.decode(sessionKey);
        // 偏移量
        byte[] ivByte = Base64.decode(iv);

        try {
            // 如果密钥不足16位，那么就补足.  这个if 中的内容很重要
            int base = 16;
            if (keyByte.length % base != 0) {
                int groups = keyByte.length / base + (keyByte.length % base != 0 ? 1 : 0);
                byte[] temp = new byte[groups * base];
                Arrays.fill(temp, (byte) 0);
                System.arraycopy(keyByte, 0, temp, 0, keyByte.length);
                keyByte = temp;
            }
            // 初始化
            Security.addProvider(new BouncyCastleProvider());
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding", "BC");
            SecretKeySpec spec = new SecretKeySpec(keyByte, "AES");
            AlgorithmParameters parameters = AlgorithmParameters.getInstance("AES");
            parameters.init(new IvParameterSpec(ivByte));
            cipher.init(Cipher.DECRYPT_MODE, spec, parameters);// 初始化
            byte[] resultByte = cipher.doFinal(dataByte);
            if (null != resultByte && resultByte.length > 0) {
                String result = new String(resultByte, "UTF-8");
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据用户信息，向t_playergame中写入数据
     * @param data
     * @param gameid
     * @param fromappid
     * @param recommendUser
     * @return
     */
    public int register(HashMap<String, Object> data, String gameid, String fromappid,String recommendUser) {
        String openid = (String) data.get("openId");
        String nickname = (String) data.get("nickName");
        int gender = (int) data.get("gender");
        String country = (String) data.get("country");
        String city = (String) data.get("city");
        String province = (String) data.get("province");
        String language = (String) data.get("language");


        try {
            System.out.println("openid:"+openid+" nickname:"+ new String(nickname.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException e) {
            System.out.println("println 2 utf-8 exception");
            e.printStackTrace();
        }


        //如果该用户已注册，则更新最后登录时间并直接返回用户的注册数据id
        TPlayer p = TPlayer.T_PLAYER;
        Record1<UInteger> record = dslContext.select(p.ID).from(p).where(p.OPENID.eq(openid)).fetchOne();
        if (record != null && record.size() > 0) {
            UInteger id = record.value1();
            dslContext.update(p).set(p.LASTLOGINTIME,U.getNowTimestamp())
                    .set(p.CURRENTBOXAPPID,fromappid)
                    .where(p.ID.eq(id))
                    .execute();
            return Integer.parseInt(String.valueOf(id));
        }


        //判断推荐人数据
        if(recommendUser==null || recommendUser.equals("undefined") || recommendUser.equals("null") || recommendUser.equals(""))
            recommendUser = null;


        //如果当前数据不存在
        TPlayerRecord rid = dslContext.insertInto(p, p.OPENID, p.GAMEAPPID, p.BOXAPPID, p.NICKNAME, p.GENDER, p.CITY, p.PROVINCE
                )
//        , p.CREATETIME)
                .values(openid, gameid, fromappid, nickname, Integer.valueOf(gender), city, province)
//        , U.getNowTimestamp())
                .returning(p.ID)
                .fetchOne();

        return rid.getId().intValue();
    }


    @RequestMapping("/openidreg")
    public String openidReg(
            @RequestParam("openid") String openid,
            @RequestParam("gameid") String gameid,
            @RequestParam("fromappid") String fromappid,
            @RequestParam("nickName") String nickName,
            @RequestParam("gender") Integer gender,
            @RequestParam("language") String language,
            @RequestParam("city") String city,
            @RequestParam("province") String province,
            @RequestParam("country") String country,
            @RequestParam("avatarUrl") String avatarUrl,
            @RequestParam(value = "recommendUser",required = false) String recommendUser
    ) {

        HashMap<String, Object> ares = new HashMap<>();
        ares.put("openId",openid);
        ares.put("nickName",nickName);
        ares.put("gender",gender);
        ares.put("language",language);
        ares.put("city",city);
        ares.put("province",province);
        ares.put("country",country);
        ares.put("avatarUrl",avatarUrl);

        System.out.print("openidreg: ");
        int state = register(ares, gameid, fromappid.equals("undefined") == true ? "default" : fromappid,recommendUser);
//        System.out.println("openidreg openid:"+openid+" nickname:"+nickName);

        //2:返回是否正确操作的状态值
        if (state > 0)
            return RetMsg.success().toString();
        else
            return RetMsg.strMsg(1001, "操作失败，数据库中没有openid为:" + ares.get("openId").toString() + "的用户数据。");

    }

}


