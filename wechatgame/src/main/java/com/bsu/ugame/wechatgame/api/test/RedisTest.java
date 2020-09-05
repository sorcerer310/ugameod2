package com.bsu.ugame.wechatgame.api.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by fengchong on 2017/5/22.
 */
@Controller
public class RedisTest {
    @Autowired
    private StringRedisTemplate srt;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/redistest")
    @ResponseBody
    public String redisTest(){
        String vo = srt.opsForValue().get("foo");
        logger.info("日志测试输出 Info");
        return vo;
    }

}
