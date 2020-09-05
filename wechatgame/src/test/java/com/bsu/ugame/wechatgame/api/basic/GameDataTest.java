package com.bsu.ugame.wechatgame.api.basic;

import com.bsu.ugame.ServletTestTools;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.HashMap;

/**
 * GameData Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>八月 21, 2018</pre>
 */
public class GameDataTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: channelBox(@RequestParam UInteger channelid)
     */
    @Test
    public void testChannelBox() throws Exception {
        HashMap<String,String> hm = new HashMap<>();
        hm.put("channelid","1");
        ServletTestTools.printUrl("channel/box",hm,"1");
    }

    /**
     * Method: channelGame(@RequestParam UInteger channelid)
     */
    @Test
    public void testChannelGame() throws Exception {
        HashMap<String,String> hm = new HashMap<>();
        hm.put("channelid","2");
        hm.put("boxid","31");
        ServletTestTools.printUrl("channel/game",hm,"2");
    }

    /**
     * Method: GameList(@RequestParam Timestamp date, @RequestParam String gameappid, @RequestParam String boxappid)
     */
    @Test
    public void testGameDailyData() throws Exception {
        HashMap<String,String> hm= new HashMap<>();
        hm.put("channelid","1");
//        hm.put("boxid","4");
//        hm.put("gameid","6");
        hm.put("date","2018-10-07");
        ServletTestTools.printUrl("/dailydata",hm,"1");

    }


} 
