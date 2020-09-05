package com.bsu.ugame.gameparams.tools;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * 返回消息
 * Created by fengchong on 2017/5/27.
 */
public class RetMsg {
    public static JSONObject success(){
        JSONObject jo = new JSONObject();
        jo.put("status",200);
        return jo;
    }

//    /**
//     * 返回状态码和消息
//     * @param status    状态码
//     * @param msg       消息
//     * @return          返回json形式的代码
//     */
//    public static JSONObject msgStr(int status,String msg){
//        return msg(status,msg);
//    }

    /**
     * 返回状态码和消息
     * @param status    状态码
     * @param msg       消息
     * @return          返回json形式的代码
     */
    public static JSONObject msg(int status,String msg){
        JSONObject jo = new JSONObject();
        jo.put("status",status);
        jo.put("msg",msg);
        return jo;
    }

    /**
     * 讲json数据直接转换为字符串形式
     * @param status
     * @param msg
     * @return
     */
    public static String strMsg(int status,String msg){
        return msg(status,msg).toString();
    }

    /**
     * 返回带数据的消息数据
     * @param jo_data
     * @return  返回带数据的
     */
    public static JSONObject msgData(JSONObject jo_data){
        JSONObject jo = new JSONObject();
        jo.put("status",1000);
        jo.put("msg","");
        jo.put("data",jo_data);
        return jo;
    }

    /**
     * 返回带数据的消息数据
     * @param status    消息状态码，1000为成功
     * @param msg       附加的消息
     * @param jo_data   返回的数据
     * @return          数据以json形式返回
     */
    public static JSONObject msgData(int status, String msg, JSONObject jo_data){
        JSONObject jo = new JSONObject();
        jo.put("status",status);
        jo.put("msg",msg);
        jo.put("data",jo_data);
        return jo;
    }

    /**
     * 返回带数据的消息数据
     * @param status    消息状态码，1000为成功
     * @param msg       附加的消息
     * @param ja_data   返回的数据，json数组形式
     * @return          数据以json数据形式返回
     */
    public static JSONObject msgData(int status, String msg, JSONArray ja_data){
        JSONObject jo = new JSONObject();
        jo.put("status",status);
        jo.put("msg",msg);
        jo.put("data",ja_data);
        return jo;
    }

    /**
     * 直接返回
     * @param status
     * @param msg
     * @param ja_data
     * @return
     */
    public static String strMsgData(int status,String msg,JSONArray ja_data){
        return msgData(status,msg,ja_data).toString();
    }

    /**
     * 返回字符串格式的带数据的消息数据
     * @param status
     * @param msg
     * @param jo_data
     * @return
     */
    public static String strMsgData(int status,String msg,JSONObject jo_data){
        return msgData(status,msg,jo_data).toString();
    }
}
