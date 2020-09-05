package com.bsu.ugame.gameparams.api.share;

import com.bsu.ugame.gameparams.collector.JSONArrayCollector;
import com.bsu.ugame.gameparams.jooq.db.tables.TShare;
import com.bsu.ugame.gameparams.tools.RetMsg;
import org.jooq.DSLContext;
import org.jooq.Record6;
import org.jooq.SelectJoinStep;
import org.jooq.types.UInteger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.support.ResourceTransactionManager;
import org.springframework.web.bind.annotation.*;

@RestController
public class Share {
    @Autowired
    DSLContext dsl;

    /**
     * 根据id查询一条共享数据
     *
     * @param id
     * @return
     */
    @GetMapping("/shareinfo/{id}")
    public String shareInfoById(
            @PathVariable Integer id
    ) {
        TShare ts = TShare.T_SHARE;
        JSONArray ja = dsl.select(ts.ID, ts.GAMEAPPID, ts.SHAREPOSITIONID, ts.IMAGEURL, ts.SHARECONTENT, ts.ENABLED, ts.SHAREORDER)
                .from(ts).where(ts.ID.eq(UInteger.valueOf(id)))
                .fetch().stream()
                .map(record -> {
                    JSONObject jo = new JSONObject();
                    jo.put("id", record.value1());
                    jo.put("gameappid", record.value2());
                    jo.put("sharepositionid", record.value3());
                    jo.put("imageurl", record.value4());
                    jo.put("sharecontent", record.value5());
                    jo.put("enabled", record.value6());
                    jo.put("shareorder", record.value7());
                    return jo;
                }).collect(new JSONArrayCollector<>());

        return RetMsg.strMsgData(1000, "查询共享数据成功", ja);
    }

    @GetMapping("/shareinfo")
    public String shareInfo(
            @RequestParam(value = "gameappid", required = false) String gameappid
    ) {

        TShare ts = TShare.T_SHARE;
        SelectJoinStep<Record6<String, Integer, String, String, Boolean, UInteger>> sjs = dsl.select(ts.GAMEAPPID, ts.SHAREPOSITIONID, ts.IMAGEURL, ts.SHARECONTENT, ts.ENABLED, ts.ID)
                .from(ts);
        if (gameappid != null && !gameappid.equals(""))
            sjs.where(ts.GAMEAPPID.eq(gameappid));
        JSONArray ja = sjs.orderBy(ts.SHAREORDER)
                .fetch().stream()
                .map(record -> {
                    JSONObject jo = new JSONObject();
                    jo.put("imageurl", record.value3());
                    jo.put("sharecontent", record.value4());
                    jo.put("gameappid", record.value1());
                    jo.put("sharepositionid", record.value2());
                    jo.put("enabled", record.value5());
                    jo.put("id", record.value6());
                    return jo;
                }).collect(new JSONArrayCollector<>());

        return RetMsg.strMsgData(1000, "查询共享数据成功", ja);
    }


    /**
     * 新建分享数据
     *
     * @param params json形式的参数
     * @return 返回新建数据是否成功
     */
    @PostMapping("/shareinfo")
    public String addShareInfo(
            @RequestBody String params
    ) {
        JSONObject jo = new JSONObject(params).getJSONObject("params");
        String gameappid = jo.getString("gameappid");
        Integer sharepositionid = jo.getInt("sharepositionid");
        String imageurl = jo.getString("imageurl");
        String sharecontent = jo.getString("sharecontent");
        Integer shareorder = jo.getInt("shareorder");
        Boolean enabled = jo.getBoolean("enabled");

        TShare ts = TShare.T_SHARE;
        int count = dsl.insertInto(ts, ts.GAMEAPPID, ts.SHAREPOSITIONID, ts.IMAGEURL, ts.SHARECONTENT, ts.SHAREORDER, ts.ENABLED)
                .values(gameappid, sharepositionid, imageurl, sharecontent, shareorder, enabled)
                .execute();

        return count > 0 ? RetMsg.strMsg(1000, "新建分享数据成功") : RetMsg.strMsg(1001, "新建分享数据失败");
    }

    /**
     * 更新共享数据
     *
     * @param params json形式的参数
     * @return 返回更新是否成功
     */
    @PutMapping("/shareinfo")
    public String modifyShareInfo(
            @RequestBody String params
    ) {
        JSONObject jo = new JSONObject(params).getJSONObject("params");
        Integer id = jo.getInt("id");
        String gameappid = jo.getString("gameappid");
        Integer sharepositionid = jo.getInt("sharepositionid");
        String imageurl = jo.getString("imageurl");
        String sharecontent = jo.getString("sharecontent");
        Integer shareorder = jo.getInt("shareorder");
        Boolean enabled = jo.getBoolean("enabled");

        TShare ts = TShare.T_SHARE;
        int count = dsl.update(ts).set(ts.GAMEAPPID, gameappid)
                .set(ts.SHAREPOSITIONID, sharepositionid)
                .set(ts.IMAGEURL, imageurl)
                .set(ts.SHARECONTENT, sharecontent)
                .set(ts.SHAREORDER, shareorder)
                .set(ts.ENABLED, enabled)
                .where(ts.ID.eq(UInteger.valueOf(id)))
                .execute();

        return count > 0 ? RetMsg.strMsg(1000, "更新共享数据成功") : RetMsg.strMsg(1001, "更新共享数据失败");
    }

    /**
     * 根据id删除共享数据
     *
     * @param id
     * @return
     */
    @DeleteMapping("/shareinfo/{id}")
    public String deleteShareInfo(
            @PathVariable Integer id
    ) {
        TShare ts = TShare.T_SHARE;
        int count = dsl.delete(ts).where(ts.ID.eq(UInteger.valueOf(id))).execute();

        return count > 0 ? RetMsg.strMsg(1000, "删除共享数据成功") : RetMsg.strMsg(1001, "删除共享数据失败");
    }
}





















