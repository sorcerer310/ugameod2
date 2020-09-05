package com.bsu.ugame;


import com.bsu.ugame.wechatgame.parser.JSONParser;
import com.meterware.httpunit.GetMethodWebRequest;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;
import org.xml.sax.SAXException;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by fengchong on 16/6/29.
 */
public class ServletTestTools {
    private static String hostPath = "http://localhost:8184/";
    public static String testUrl(String url,HashMap<String,String> args,String auth) throws IOException, SAXException {
        WebConversation wc = new WebConversation();
        WebRequest req = new GetMethodWebRequest(hostPath+url);

        if(args!=null) {
            Iterator<String> it = args.keySet().iterator();
            while (it.hasNext()) {
                String key = it.next();
                req.setParameter(key, new String(args.get(key).getBytes("UTF-8"), "ISO-8859-1"));
            }
        }

        //测试方法不验证token
        req.setParameter("ugameod2debug",new String("true".getBytes("UTF-8"), "ISO-8859-1"));
        req.setParameter("auth",auth);

        WebResponse resp = wc.getResponse(req);
        return JSONParser.formatJSON(resp.getText());

    }

    /**
     * 直接打印返回数据
     * @param url           要测试的URL
     * @param args          url代入的参数
     * @throws IOException
     * @throws SAXException
     */
    public static void printUrl(String url,HashMap<String,String> args,String auth) throws IOException, SAXException {
        System.out.println(ServletTestTools.testUrl(url,args,auth));
    }

    /**
     * 越过登录验证的测试方法
     * @param url
     * @param args
     * @return
     * @throws IOException
     * @throws SAXException
     */
    public static void loginPrintUrl(String url,HashMap<String,String> args) throws IOException, SAXException {
        WebConversation wc = new WebConversation();
        WebRequest req = new GetMethodWebRequest(hostPath+url);
        req.setHeaderField("logindebug","debug");
        if(args!=null) {
            args.keySet()
                    .stream()
                    .forEach(key->{
                        try {
                            req.setParameter(key, new String(args.get(key).getBytes("UTF-8"), "ISO-8859-1"));
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                    });
        }
        WebResponse resp = wc.getResponse(req);     //再操作数据
        System.out.println(JSONParser.formatJSON(resp.getText()));
    }
}
