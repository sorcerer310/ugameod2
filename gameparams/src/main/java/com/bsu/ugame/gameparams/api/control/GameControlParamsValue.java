package com.bsu.ugame.gameparams.api.control;

import com.bsu.ugame.gameparams.collector.JSONArrayCollector;
import com.bsu.ugame.gameparams.jooq.db.tables.TControl;
import com.bsu.ugame.gameparams.jooq.db.tables.TControlvalue;
import com.bsu.ugame.gameparams.jooq.db.tables.records.TControlvalueRecord;
import com.bsu.ugame.gameparams.tools.RetMsg;
import org.jooq.DSLContext;
import org.jooq.Record3;
import org.jooq.Record4;
import org.jooq.types.UInteger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.stream.Collectors;

/**
 * 游戏控制参数的值
 */
@RestController
public class GameControlParamsValue {
    @Autowired
    DSLContext dsl;

    @GetMapping("/paramsvalue")
    public String queryGameParamsValue(
            @RequestParam("gameappid") String gameappid
    ) {
        //获得字段数据
        JSONArray ja_cols = getGameappidColumns(gameappid);

        //收集值数据
        TControlvalue tcv = TControlvalue.T_CONTROLVALUE;
        JSONArray ja_ret = dsl.select(tcv.ID, tcv.VERSION, tcv.VALUE).from(tcv).where(tcv.GAMEAPPID.eq(gameappid))
                .fetch().stream()
                .map(record -> {
                    //返回数据
                    JSONObject jo_retrow = new JSONObject();
                    jo_retrow.put("id", record.value1());
                    jo_retrow.put("version", record.value2());

                    //值数据
                    JSONObject jo_v = new JSONObject(record.value3());

                    //列数据
                    Iterator<Object> it = ja_cols.iterator();
                    while (it.hasNext()) {
                        JSONObject jo_c = new JSONObject(it.next().toString());
                        jo_retrow.put(jo_c.getString("key"), !jo_v.has(jo_c.getString("key")) ? jo_c.getString("default") : jo_v.get(jo_c.getString("key")));
                    }
                    return jo_retrow;
                }).collect(new JSONArrayCollector<>());

        return RetMsg.strMsgData(1000, "查询游戏参数数据成功", ja_ret);
    }

    /**
     * 根据id查看游戏参数值
     *
     * @param gameappid 游戏的gameappid
     * @param id        参数值的id
     * @return
     */
    @GetMapping("/paramsvalue/{gameappid}/{id}")
    public String queryGameParamsValue(
            @PathVariable String gameappid,
            @PathVariable Integer id
    ) {
        //获得字段数据
        JSONArray ja_cols = getGameappidColumns(gameappid);

        TControlvalue tcv = TControlvalue.T_CONTROLVALUE;
        JSONArray ja_ret = dsl.select(tcv.VERSION, tcv.VALUE).from(tcv).where(tcv.ID.eq(UInteger.valueOf(id)))
                .fetch().stream()
                .map(record -> {
                    //返回数据
                    JSONObject jo_retrow = new JSONObject();
                    jo_retrow.put("version", record.value1());
                    //值数据
                    JSONObject jo_v = new JSONObject(record.value2());

                    //列数据
                    Iterator<Object> it = ja_cols.iterator();
                    while (it.hasNext()) {
                        JSONObject jo_c = new JSONObject(it.next().toString());
                        jo_retrow.put(jo_c.getString("key"), !jo_v.has(jo_c.getString("key")) ? jo_c.getString("default") : jo_v.get(jo_c.getString("key")));
                    }
                    return jo_retrow;
                }).collect(new JSONArrayCollector<>());

        return RetMsg.strMsgData(1000, "查询游戏参数数据成功", ja_ret);
    }

    /**
     * 获得指定gameappid的字段数据
     *
     * @param gameappid
     * @return
     */
    private JSONArray getGameappidColumns(String gameappid) {
        //收集字段数据
        TControl tc = TControl.T_CONTROL;
        JSONArray ja_cols = dsl.select(tc.KEY, tc.NAME, tc.MEMO, tc.DEFAULT).from(tc).where(tc.GAMEAPPID.eq(gameappid))
                .fetch().stream()
                .map(record -> {
                    JSONObject jo_ret = new JSONObject();
                    jo_ret.put("key", record.value1());
                    jo_ret.put("default", record.value4());
                    return jo_ret;
                }).collect(new JSONArrayCollector<>());

        return ja_cols;
    }

    /**
     * 保存
     *
     * @param params
     * @return
     */
    @PostMapping("/paramsvalue")
    public String addGameParamsValue(
            @RequestBody String params
    ) {
        JSONObject jo = new JSONObject(params).getJSONObject("params");
        String gameappid = jo.getString("gameappid");
        String version = jo.getString("version");
        String value = jo.getString("value");

        TControlvalue tcv = TControlvalue.T_CONTROLVALUE;
        int count = dsl.insertInto(tcv, tcv.GAMEAPPID, tcv.VERSION, tcv.VALUE).values(gameappid, version, value)
                .execute();

        return count > 0 ? RetMsg.strMsg(1000, "新建参数值数据成功") : RetMsg.strMsg(1001, "新建参数值数据失败");
    }

    /**
     * 更新参数值
     *
     * @param params
     * @return
     */
    @PutMapping("/paramsvalue")
    public String modifyGameParamsValue(
            @RequestBody String params
    ) {
        JSONObject jo = new JSONObject(params).getJSONObject("params");
        Integer id = jo.getInt("id");
        String version = jo.getString("version");
        String value = jo.getString("value");

        TControlvalue tcv = TControlvalue.T_CONTROLVALUE;
        int count = dsl.update(tcv).set(tcv.VERSION, version)
                .set(tcv.VALUE, value)
                .where(tcv.ID.eq(UInteger.valueOf(id)))
                .execute();

        return count > 0 ? RetMsg.strMsg(1000, "更新参数值数据成功") : RetMsg.strMsg(1001, "更新参数值数据失败");
    }

    /**
     * 删除指定的参数值
     *
     * @param id
     * @return
     */
    @DeleteMapping("/paramsvalue/{id}")
    public String deleteGammeParamsValue(
            @PathVariable Integer id
    ) {
        TControlvalue tcv = TControlvalue.T_CONTROLVALUE;
        int count = dsl.delete(tcv).where(tcv.ID.eq(UInteger.valueOf(id))).execute();

        return count > 0 ? RetMsg.strMsg(1000, "删除参数值数据成功") : RetMsg.strMsg(1001, "删除参数值数据失败");
    }


    /**
     * 客户端访问参数值
     * @param gameappid 游戏appid
     * @param version   游戏版本
     * @return
     */
    @GetMapping("/cliparamsvalue")
    public String cliParamsValue(
            @RequestParam("gameappid") String gameappid,
            @RequestParam("version") String version
    ) {

        TControlvalue tcv = TControlvalue.T_CONTROLVALUE;
//        JSONArray ja_ret = dsl.select(tcv.ID, tcv.VERSION, tcv.VALUE).from(tcv)
//                .where(tcv.GAMEAPPID.eq(gameappid).and(tcv.VERSION.eq(version)))
//                .fetch().stream()
//                .map(record ->{
//                    JSONObject jo_v = new JSONObject(record.value3());
//                    jo_v.put("value",new JSONObject(record.value3()).toString());
//
//                    return jo_v;
//                }).collect(new JSONArrayCollector<>());
        JSONArray ja = new JSONArray();

        Record3<UInteger,String,String> record3 = dsl.select(tcv.ID, tcv.VERSION, tcv.VALUE).from(tcv)
                .where(tcv.GAMEAPPID.eq(gameappid).and(tcv.VERSION.eq(version)))
                .fetchOne();
        ja.put(new JSONObject(record3.value3()));


        return RetMsg.strMsgData(1000, "查询游戏参数数据成功", ja);
    }

}
