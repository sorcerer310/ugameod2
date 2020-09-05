package com.bsu.ugame.wechatgame.filter;

import com.bsu.ugame.wechatgame.tools.RetMsg;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 验证token是否有效
 * 需要在入口类增加@ServletComponentScan
 * Created by fengchong on 2017/6/6.
 */

@Order(100)
@WebFilter(filterName="tokenFilter",urlPatterns = "/*"
        ,initParams = {@WebInitParam(name="excludedPages"
        ,value="/userreg,/channel/login,/userreg,/openidreg,/player/recommended" +
        ",/sendhelpdata,/gethelpdata")})
public class TokenFilter implements Filter {
    @Autowired
    private StringRedisTemplate redis;

    private String excludedPages;
    private String[] excludedPageArray;

    @Override
    public void init(FilterConfig config)throws ServletException {
        //获得排除的url
        excludedPages = config.getInitParameter("excludedPages");
        if(null!=excludedPages && excludedPages.length()>0){
            excludedPageArray = excludedPages.split(",");
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        filterChain.doFilter(servletRequest,servletResponse);
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        //判断如果是测试函数则跳过token判断
        String ugameod2debug = req.getParameter("ugameod2debug");
        String auth = req.getParameter("auth");
        if(ugameod2debug!=null && ugameod2debug.equals("true")) {
            //增加权限值
            servletRequest.setAttribute("auth",auth);
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }


        if(null==excludedPageArray) return;
        boolean isExcludePage = false;
        for(String p:excludedPageArray){
            if(req.getServletPath().equals(p)){
                isExcludePage = true;
                break;
            }
        }

        //如果是过滤掉的url，就继续往下走
        if(isExcludePage){
            filterChain.doFilter(servletRequest,servletResponse);
        }
        //否则判断token是否存在
        else{
//            String token = req.getParameter("token");
            String token = "user_token."+req.getHeader("ugameod2-token");
            if(!redis.hasKey(token)){
                JSONObject jo = RetMsg.msg(1001,"token失效或不存在!");
                res.getWriter().println(jo.toString());
            }else{
                //取出权限值，放到request中
                JSONObject jo = new JSONObject(redis.opsForValue().get(token));
                servletRequest.setAttribute("auth",jo.get("auth"));
                servletRequest.setAttribute("userid",jo.get("userid"));
                filterChain.doFilter(servletRequest,servletResponse);
            }
        }
    }

    @Override
    public void destroy() {
        excludedPages = null;
        excludedPageArray = null;
    }
}
