package com.bsu.ugame.wechatgame.api.basic;

import com.bsu.ugame.ServletTestTools;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.HashMap;

/**
 * ChannelUser Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>九月 21, 2018</pre>
 */
public class ChannelUserTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: wechatGameLogin(@RequestParam String name, @RequestParam String pwd)
     */
    @Test
    public void testWechatGameLogin() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: getChannelUser()
     */
    @Test
    public void testGetChannelUser() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: getChannelAuth(@PathVariable Integer id)
     */
    @Test
    public void testGetChannelAuth() throws Exception {
        HashMap<String,String> hm = new HashMap<>();
        ServletTestTools.printUrl("channel/auth/16",hm,"2");
    }

    /**
     * Method: getChannelUserById(@PathVariable Integer id)
     */
    @Test
    public void testGetChannelUserById() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: addChannelUser(@RequestBody String params)
     */
    @Test
    public void testAddChannelUser() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: updateChannelUser(@PathVariable("id") Integer id, @RequestBody String data)
     */
    @Test
    public void testUpdateChannelUser() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: deleteChannelUser(@PathVariable("id") Integer id)
     */
    @Test
    public void testDeleteChannelUser() throws Exception {
//TODO: Test goes here... 
    }


} 
