package com.bsu.ugame.wechatgame.tools;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;

/**
 * 一些公共方法
 * Created by fengchong on 2017/6/1.
 */
public class U {
    //执行测试方式时，该值设置为true，测试函数结束该值设为false;
    public static boolean testDebug = false;

    /**
     * sha256单向加密操作
     * @param content
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static String sha256Encode(String content) throws NoSuchAlgorithmException {
        String strEn = "";
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(content.getBytes());
        strEn = bytes2Hex(md.digest());
        return strEn;
    }

    /**
     * 字节数组转字符串
     * @param bts 需要转化的字节数组
     * @return 返回转化后的字符串
     */
    public static String bytes2Hex(byte[] bts) {
        StringBuffer sb = new StringBuffer();
        String stmp = "";
        for (int n = 0; n < bts.length; n++) {
            stmp = Integer.toHexString(bts[n] & 0XFF);
            if (stmp.length() == 1)
                sb.append("0").append(stmp);
            else
                sb.append(stmp);
        }
        return sb.toString();
    }

    /**
     * 获得当前时间
     * @return
     */
    public static Timestamp getNowTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }
}
