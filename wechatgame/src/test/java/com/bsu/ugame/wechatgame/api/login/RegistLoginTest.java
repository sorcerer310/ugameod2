package com.bsu.ugame.wechatgame.api.login;

import com.bsu.ugame.ServletTestTools;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.HashMap;

/**
 * RegistLogin Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>八月 27, 2018</pre>
 */
public class RegistLoginTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: login(@RequestParam("name") String name, @RequestParam("pwd") String pwd)
     */
    @Test
    public void testLogin() throws Exception {
        HashMap<String,String> hm = new HashMap<>();
//        hm.put("name","admin");
        hm.put("name","13000000000");
        hm.put("pwd","123456");
        ServletTestTools.printUrl("channel/login",hm,"2");
    }

    /**
     * Method: regist(@RequestParam("name") String name, @RequestParam("pwd") String pwd)
     */
    @Test
    public void testRegist() throws Exception {
//TODO: Test goes here... 
    }


    /**
     * Method: createToken(String userid)
     */
    @Test
    public void testCreateToken() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = RegistLogin.getClass().getMethod("createToken", String.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

} 
