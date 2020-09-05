package com.bsu.ugame.gameparams.api.control;

import com.bsu.ugame.gameparams.collector.JSONArrayCollector;
import com.bsu.ugame.gameparams.jooq.db.tables.TControl;
import com.bsu.ugame.gameparams.jooq.db.tables.TGame;
import com.bsu.ugame.gameparams.tools.RetMsg;
import org.jooq.DSLContext;
import org.jooq.Record8;
import org.jooq.SelectJoinStep;
import org.jooq.types.UInteger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 处理游戏的控制参数
 */
@RestController
public class GameControlParams {
    @Autowired
    private DSLContext dsl;

    /**
     * 查询动态表的字段数据
     * @param id
     * @return
     */
    @GetMapping("/paramscolumn/{id}")
    public String gameParamsColumnById(
        @PathVariable Integer id
    ){
        TControl tc = TControl.T_CONTROL;
        JSONArray ja = dsl.select(tc.ID,tc.GAMEAPPID,tc.NAME,tc.KEY,tc.MEMO,tc.DEFAULT,tc.TYPE,tc.LENGTH)
                .from(tc).where(tc.ID.eq(UInteger.valueOf(id)))
                .fetch().stream()
                .map(record->{
                    JSONObject jo = new JSONObject();
                    jo.put("id",record.value1());
                    jo.put("gameappid",record.value2());
                    jo.put("name",record.value3());
                    jo.put("key",record.value4());
                    jo.put("memo",record.value5());
                    jo.put("defaultValue",record.value6());
                    jo.put("type",record.value7());
                    jo.put("length",record.value8());

                    return jo;
                }).collect(new JSONArrayCollector<>());

        return RetMsg.strMsgData(1000,"查询字段数据成功",ja);
    }


    /**
     * 查询游戏控制参数
     * @param gameappid
     * @return
     */
    @GetMapping("/paramscolumn")
    public String queryGameParamsColumn(
            @RequestParam(value = "gameappid", required = false) String gameappid
    ) {
        TControl tc = TControl.T_CONTROL;
        SelectJoinStep<Record8<UInteger, String, String, String, String, String, String, Integer>> sjs = dsl.select(tc.ID, tc.GAMEAPPID, tc.NAME, tc.KEY, tc.MEMO, tc.DEFAULT, tc.TYPE, tc.LENGTH)
                .from(tc);
        if (gameappid != null && !gameappid.equals(""))
            sjs.where(tc.GAMEAPPID.eq(String.valueOf(gameappid)));
        JSONArray ja = sjs.fetch().stream()
                .map(record -> {
                    JSONObject jo = new JSONObject();
                    jo.put("id", record.value1());
                    jo.put("gameappid", record.value2());
                    jo.put("name", record.value3());
                    jo.put("key", record.value4());
                    jo.put("memo", record.value5());
                    jo.put("defaultValue", record.value6());
                    jo.put("type", record.value7());
                    jo.put("length", record.value8());

                    return jo;
                }).collect(new JSONArrayCollector<>());

        return RetMsg.strMsgData(1000, "查询参数数据成功", ja);
    }

    /**
     * 增加
     * @param params
     * @return
     */
    @PostMapping("/paramscolumn")
    public String addGameParamsColumn(
            @RequestBody String params
    ){
        JSONObject jo = new JSONObject(params).getJSONObject("params");
        String gameappid = jo.getString("gameappid");
        String name = jo.getString("name");
        String key = jo.getString("key");
        String memo = jo.getString("memo");
        String defaultValue = jo.getString("defaultValue");

        TControl tc = TControl.T_CONTROL;
        int count = dsl.insertInto(tc,tc.GAMEAPPID,tc.NAME,tc.KEY,tc.MEMO,tc.DEFAULT)
                .values(gameappid,name,key,memo,defaultValue)
                .execute();

        return count>0?RetMsg.strMsg(1000,"新建参数字段数据成功"):RetMsg.strMsg(1001, "新建参数字段数据失败");
    }

    /**
     * 更新游戏参数数据
     * @param params
     * @return
     */
    @PutMapping("/paramscolumn")
    public String modifyGameParamsColumn(
            @RequestBody String params
    ){
        JSONObject jo = new JSONObject(params).getJSONObject("params");
        Integer id = jo.getInt("id");
//        String gameappid = jo.getString("gameappid");
        String name = jo.getString("name");
        String key = jo.getString("key");
        String memo = jo.getString("memo");
        String defaultValue = jo.getString("defaultValue");

        TControl tc = TControl.T_CONTROL;
        int count = dsl.update(tc).set(tc.NAME,name)
                .set(tc.KEY,key)
                .set(tc.MEMO,memo)
                .set(tc.DEFAULT,defaultValue)
                .where(tc.ID.eq(UInteger.valueOf(id)))
                .execute();

        return count >0? RetMsg.strMsg(1000, "更新参数字段数据成功") : RetMsg.strMsg(1001, "更新参数字段数据失败");
    }

    /**
     * 删除游戏参数
     * @param id
     * @return
     */
    @DeleteMapping("/paramscolumn/{id}")
    public String deleteGameParams(
            @PathVariable Integer id
    ){
        TControl tc = TControl.T_CONTROL;
        int count = dsl.delete(tc).where(tc.ID.eq(UInteger.valueOf(id))).execute();

        return count > 0 ? RetMsg.strMsg(1000, "删除参数字段数据成功") : RetMsg.strMsg(1001, "删除参数字段数据失败");
    }

}
