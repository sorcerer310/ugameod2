package com.bsu.ugame.wechatgame.wechat;

import com.bsu.ugame.ServletTestTools;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.HashMap;

/**
 * HttpCenter Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>八月 22, 2018</pre>
 */
public class HttpCenterTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: UserReg(@RequestParam("js_code") String code, @RequestParam("encryptedData") String encryptedData, @RequestParam("iv") String iv, @RequestParam("fromappid") String fromappid, @RequestParam("gameid") String gameid)
     */
    @Test
    public void testUserReg() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: getUserInfo(String encryptedData, String sessionKey, String iv)
     */
    @Test
    public void testGetUserInfo() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: register(HashMap<String, Object> data, String gameid, String fromappid)
     */
    @Test
    public void testRegister() throws Exception {

    }

    /**
     * Method: openidReg(@RequestParam("gameid") String gameid, @RequestParam("fromappid") String fromappid, @RequestParam("nickName") String nickName, @RequestParam("gender") Integer gender, @RequestParam("language") String language, @RequestParam("city") String city, @RequestParam("province") String province, @RequestParam("country") String country, @RequestParam("avatarUrl") String avatarUrl)
     */
    @Test
    public void testOpenidReg() throws Exception {
        HashMap<String,String> hm = new HashMap<>();
        hm.put("openid","oploX0aS2TJLYGVs6PZv7r_Mau6o3");
        hm.put("gameid","wxb855786da830909c");
        hm.put("fromappid","testid");
        hm.put("nickName","?小迪?✨");
        hm.put("gender","1");
        hm.put("language","zh_CN");
        hm.put("city","cc");
        hm.put("province","jl");
        hm.put("country","China");
        hm.put("avatarUrl","https://wx.qlogo.cn/mmopen/vi_32/icSZYfgq4NPG2qVqQwDo1xv5GPRUKkibQ1TV3aTRL22H0Ok5icF3L6kw1r5MNUvg05OCNOZYalCHTticrxymxuZXcA/132");
        hm.put("recommendUser","");
        ServletTestTools.printUrl("openidreg",hm,"2");

    }


    /**
     * Method: getGameSecret(String gameid)
     */
    @Test
    public void testGetGameSecret() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = HttpCenter.getClass().getMethod("getGameSecret", String.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

} 
