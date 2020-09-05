package com.bsu.ugame.wechatgame.api.basic;

import com.bsu.ugame.ServletTestTools;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.HashMap;

/**
 * ChannelAuth3 Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>九月 30, 2018</pre>
 */
public class ChannelAuth3Test {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: getChannelauth3Game(@PathVariable Integer channelid)
     */
    @Test
    public void testGetChannelauth3Game() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: cpDailyData(@RequestParam(value="gameappid",required = false) String gameappid, @RequestParam("channelid") Integer channelid, @RequestParam("date") String date)
     */
    @Test
    public void testCpDailyData() throws Exception {
        HashMap<String,String> hm = new HashMap<>();
        hm.put("date","2018-09-30");
//        hm.put("gameappid","wx82e61de9dd8b5728");
        hm.put("channelid","32");

        ServletTestTools.printUrl("cpdailydata",hm,"2");
    }


} 
