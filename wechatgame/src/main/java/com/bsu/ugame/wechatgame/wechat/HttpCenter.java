package com.bsu.ugame.wechatgame.wechat;

import com.bsu.ugame.wechatgame.jooq.db.tables.TGame;
import com.bsu.ugame.wechatgame.jooq.db.tables.TPlayergame;
import com.bsu.ugame.wechatgame.jooq.db.tables.records.TPlayergameRecord;
import com.bsu.ugame.wechatgame.tools.RetMsg;
import com.bsu.ugame.wechatgame.tools.U;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.starsea.aircraft.Jooq.db.tables.records.AircraftPlayerRecord;
//import com.starsea.aircraft.Jooq.db.tables.records.AircraftSwitchRecord;
//import com.starsea.aircraft.tools.JSONArrayCollector;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.impl.DSL;
import org.jooq.types.UInteger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.DataInput;
import java.io.UnsupportedEncodingException;
import java.security.AlgorithmParameters;
import java.security.Security;
import java.util.Arrays;
import java.util.HashMap;

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
        if (state > 0) {
            return RetMsg.success(ares.get("openId").toString()).toString();
        }
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
        Record1<String> record = dslContext.select(tg.SECRECT).from(tg)
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
        String avatarUrl = (String) data.get("avatarUrl");


        try {
            System.out.println("openid:"+openid+" nickname:"+ new String(nickname.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException e) {
            System.out.println("println 2 utf-8 exception");
            e.printStackTrace();
        }


        //如果该用户已注册，则更新最后登录时间并直接返回用户的注册数据id
        TPlayergame p = TPlayergame.T_PLAYERGAME;
        Record1<UInteger> record = dslContext.select(p.ID).from(p).where(p.OPENID.eq(openid)).fetchOne();
        if (record != null && record.size() > 0) {
            UInteger id = record.value1();
            dslContext.update(p).set(p.LASTLOGINTIME,U.getNowTimestamp())
                    .set(p.CURRBOXAPPID,fromappid)
                    .where(p.ID.eq(id))
                    .execute();
            return Integer.parseInt(String.valueOf(id));
        }


        //判断推荐人数据
        if(recommendUser==null || recommendUser.equals("undefined") || recommendUser.equals("null") || recommendUser.equals(""))
            recommendUser = null;


        //如果当前数据不存在
        TPlayergameRecord rid = dslContext.insertInto(p, p.OPENID, p.GAMEAPPID, p.BOXAPPID, p.NICKNAME, p.GENDER, p.COUNTRY, p.CITY, p.PROVINCE
                , p.LANGUAGE,p.AVATARURL,p.RECOMMENDUSER)
//        , p.CREATETIME)
                .values(openid, gameid, fromappid, nickname, Integer.valueOf(gender), country, city, province, language,avatarUrl,recommendUser)
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

//        ObjectMapper amapper = new ObjectMapper();
//        HashMap<String, Object> ares = new HashMap<>();
//        try {
//            ares = amapper.readValue(userinfo, HashMap.class);
//            if (ares == null || ares.get("errcode") != null || ares.get("openId").equals("") || ares.get("openId") == null)
//                return RetMsg.strMsg(1001, "请求用户信息失败。");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return RetMsg.strMsg(1001, "解析数据异常。" + e.toString());
//        }

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


//	public String getNotice(){
//		String pathname = pconfig.getNoticepath(); // 绝对路径或相对路径都可以，这里是绝对路径，写入文件时演示相对路径
//		File filename = new File(pathname); // 要读取以上路径的input。txt文件
//
//		String notice="";
//		try {
//			InputStreamReader reader = new InputStreamReader(
//					new FileInputStream(filename),"UTF-8"); // 建立一个输入流对象reader
//			BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
//			String line = "";
//			line = br.readLine();
//			while (line != null) {
//				notice=notice+line;
//				line = br.readLine(); // 一次读入一行数据
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//
//		if(notice.equals(""))
//			notice="暂无公告";
//
//		return notice;
//	}

//	@RequestMapping("/updatescore")
//	public String update(
//			@RequestParam("score") int score,
//			@RequestParam("playerid") int id
//	){
//		JSONObject js_ret=new JSONObject();
//
//		Record record=dslContext.selectFrom(AIRCRAFT_PLAYER).where(AIRCRAFT_PLAYER.ID.eq(UInteger.valueOf(id))).fetchOne();
//		if(record==null||record.size()==0) {
//			js_ret.put("result",-1);
//			return js_ret.toString();
//		}
//
//		int nscore=((AircraftPlayerRecord) record).getTopscore();
//		if(nscore<score){
//			dslContext.update(AIRCRAFT_PLAYER)
//					.set(AIRCRAFT_PLAYER.TOPSCORE, score)
//					.where(AIRCRAFT_PLAYER.ID.eq(UInteger.valueOf(id)))
//					.execute();
//			js_ret.put("result",1);
//		}else{
//			js_ret.put("result",0);
//
//		}
//
//		return js_ret.toString();
//	}

//	@RequestMapping("/getranking")
//	public String getRanking(
//			@RequestParam("page") int page,
//			@RequestParam("num") int num
//	){
//		JSONObject js_ret=new JSONObject();
//		if(num<=0||page<0){
//			js_ret.put("result",-1);
//		}
//
//		JSONArray ja=dslContext.select(AIRCRAFT_PLAYER.ID,AIRCRAFT_PLAYER.NAME,AIRCRAFT_PLAYER.HEAD,AIRCRAFT_PLAYER.TOPSCORE)
//				.from(AIRCRAFT_PLAYER)
//				.orderBy(AIRCRAFT_PLAYER.TOPSCORE.desc())
//				.fetch().stream()
//				.map(result->{
//					JSONObject jo=new JSONObject();
//					jo.put("id",result.value1());
//					jo.put("name",result.value2());
//					jo.put("head",result.value3());
//					jo.put("topscore",result.value4());
//
//					return jo;
//				}).collect(new JSONArrayCollector<>());
//		int length=0;
//		if(ja!=null&&ja.length()>0){
//			length=ja.length();
//
//			int maxpage=length/num;
//			if(length%num!=0)
//				maxpage++;
//			int size=num;
//			if(page>=maxpage-1) {
//				page = maxpage - 1;
//				size=length%num;
//			}
//			System.out.println("ja length:"+ja.length()+" size:"+size);
//			JSONArray nj=new JSONArray();
//
//			for(int i=page*num;i<page*num+size;i++){
//
//				nj.put(ja.get(i));
//			}
//			js_ret.put("maxpage",maxpage);
//			js_ret.put("result",1);
//			js_ret.put("data",nj);
//		}
//
//		return js_ret.toString();
//	}

//	@RequestMapping("/signin")
//	public String siginIn(
//			@RequestParam("playerid") int id,
//			@RequestParam("type") int type
//	){
//		JSONObject js_ret=new JSONObject();
//
//		Record record=dslContext.selectFrom(AIRCRAFT_PLAYER).where(AIRCRAFT_PLAYER.ID.eq(UInteger.valueOf(id))).fetchOne();
//		if(record==null||record.size()==0) {
//			js_ret.put("result",-1);
//			return js_ret.toString();
//		}
//
//		Timestamp d=((AircraftPlayerRecord) record).getLogintime();
//
//		long time=0;
//		int days=((AircraftPlayerRecord) record).getLogindays();
//		boolean update=false;
//		if(d==null){
//
//
//			if(type==0)
//				days=0;
//			else days=1;
//
//			js_ret.put("result",1);
//			js_ret.put("days",days);
//			update=true;
//		}
//		else
//		{
//			time=d.getTime();
//			if(isSomeDay(time,-1)){	//昨天
//				if(days<10&&type==1)
//					days++;
//
//				js_ret.put("result",1);
//				js_ret.put("days",days);
//				update=true;
//			}else if(isSomeDay(time,0)) {	//今天
//				js_ret.put("result",0);
//				js_ret.put("days",days);
//			}else{	//断签
//				days=1;
//				if(type==0)
//					days=0;
//
//				js_ret.put("result",1);
//				js_ret.put("days",days);
//				update=true;
//			}
//		}
//
//
//		if(update&&type==1) {
//			Timestamp nowtime = new Timestamp(System.currentTimeMillis());
//
//			dslContext.update(AIRCRAFT_PLAYER)
//					.set(AIRCRAFT_PLAYER.LOGINDAYS, days)
//					.set(AIRCRAFT_PLAYER.LOGINTIME, nowtime)
//					.where(AIRCRAFT_PLAYER.ID.eq(UInteger.valueOf(id)))
//					.execute();
//		}
//
//		return js_ret.toString();
//	}

//	public static boolean isSomeDay(long timestamp,int dayDelta){
//
//		Calendar c=Calendar.getInstance();
//
//		clearCalendar(c,Calendar.HOUR_OF_DAY,Calendar.MINUTE,Calendar.SECOND,Calendar.MILLISECOND);
//
//		c.add(Calendar.DAY_OF_MONTH,dayDelta);
//		long firstTime=c.getTimeInMillis();
//
//		c.setTimeInMillis(timestamp);
//		clearCalendar(c,Calendar.HOUR_OF_DAY,Calendar.MINUTE,Calendar.SECOND,Calendar.MILLISECOND);
//
//		return firstTime==c.getTimeInMillis();
//
//	}

//	public static void clearCalendar(Calendar c,int ...fields){
//		for(int f:fields){
//			c.set(f,0);
//		}
//	}

//	public int canRecover(){
//		Record record=dslContext.selectFrom(AIRCRAFT_SWITCH).fetchOne();
//		if(record==null||record.size()==0) {
//			return 0;
//		}
//		int val=((AircraftSwitchRecord) record).getRecover();
//
//		return val;
//	}

}


