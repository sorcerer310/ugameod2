package com.bsu.ugame.wechatgame.filter;

import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用来处理跨域的过滤器
 * 需要在入口类增加@ServletComponentScan
 * Created by fengchong on 2017/5/11.
 */
@Order(99)
@WebFilter(filterName = "crossDemainFilter",urlPatterns="/*")
public class CrossDemainFilter implements Filter {
    private String[] allowOrigins = {"http://kaifa1.ugamesoft.net:8280","http://47.94.234.28:8280","http://0.0.0.0:8080","http://0.0.0.0:8081"};

//                                     "http://kaifa1.ugamesoft.net:8280","http://120.27.130.193:8280/"

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest hrq = (HttpServletRequest)servletRequest;
        HttpServletResponse hrs = (HttpServletResponse)servletResponse;

//        hrs.addHeader("Access-Control-Allow-Origin", "*");
//        hrs.addHeader("Access-Control-Allow-Origin", "http://localhost:8080");
//        hrs.addHeader("Access-Control-Allow-Origin","http://120.27.130.193:8280");
//        hrs.addHeader("Access-Control-Allow-Origin","http://kaifa1.ugamesoft.net:8280");
        String currOrigin = hrq.getHeader("Origin");
//        System.out.println("origin :"+currOrigin);
        if(currOrigin !=null){
            for(String ao : allowOrigins){
                if(currOrigin.equals(ao)){
                    hrs.setHeader("Access-Control-Allow-Origin",ao);
                    break;
                }
            }
        }else
            hrs.addHeader("Access-Control-Allow-Origin","http://kaifa1.ugamesoft.net:8280");

//        System.out.println("allow orign:"+hrs.getHeader("Access-Control-Allow-Origin"));

        hrs.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE,PUT");
        hrs.setHeader("Access-Control-Allow-Credentials", "true");
        hrs.setHeader("Access-Control-Allow-Headers","Content-Type,ugameod2-token");
//        hrs.setHeader("Access-Control-Allow-Headers","ugameod2-token");
        hrs.setHeader("Access-Control-Max-Age", "17200");

//        String method  = ((HttpServletRequest) servletRequest).getMethod();
//        if(method.equals("OPTIONS"))
//            ((HttpServletResponse)servletResponse).setStatus(200);

        filterChain.doFilter(hrq,hrs);
    }

    @Override
    public void destroy() {

    }
}
