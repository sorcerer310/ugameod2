package com.bsu.ugame.wechatgame.api.basic;

import com.bsu.ugame.ServletTestTools;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.HashMap;

/**
 * KeepData Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>九月 30, 2018</pre>
 */
public class KeepDataTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: keepData(@RequestParam(value = "boxid", required = false) Integer boxid, @RequestParam(value = "gameid", required = false) Integer gameid, @RequestParam("channelid") Integer channelid, @RequestParam("date") String date, @RequestAttribute("auth") String auth)
     */
    @Test
    public void testKeepData() throws Exception {
        HashMap<String,String> hm = new HashMap<>();
        hm.put("boxid","");
        hm.put("gameid","");
        hm.put("channelid","1");
        hm.put("date","2018-09-29");
        hm.put("auth","1");

        ServletTestTools.printUrl("keepdata",hm,"1");

    }


} 
