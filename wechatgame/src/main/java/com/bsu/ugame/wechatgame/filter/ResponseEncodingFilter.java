package com.bsu.ugame.wechatgame.filter;

import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 对请求的参数统一进行http编码
 * 对返回的数据进行统一的utf-8编码处理
 * Created by fengchong on 16/6/5.
 */
@Order(1)
@WebFilter(filterName = "Filter0_ResponseEncodingFilter",urlPatterns = "*")
public class ResponseEncodingFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest hreq = (HttpServletRequest)req;
        HttpServletResponse hres = (HttpServletResponse)resp;

//        hreq.setCharacterEncoding("ISO-8859-1");
        //将输出文字设置为utf-8编码
//        hres.setCharacterEncoding("utf-8");
		hres.setContentType("text/javascript; charset=utf-8");
        hres.setHeader("Cache-Control", "no-cache, must-revalidate");

        chain.doFilter(hreq, hres);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
