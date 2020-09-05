package com.bsu.ugame.wechatgame.api.basic;

import com.bsu.ugame.wechatgame.collector.JSONArrayCollector;
import com.bsu.ugame.wechatgame.jooq.db.tables.RChannelBox;
import com.bsu.ugame.wechatgame.jooq.db.tables.TBox;
import com.bsu.ugame.wechatgame.jooq.db.tables.records.TBoxRecord;
import com.bsu.ugame.wechatgame.tools.RetMsg;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.types.UInteger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

/**
 * 设置盒子数据
 */
@RestController
public class BoxData {
    @Autowired
    private DSLContext dsl;

    /**
     * 渠道对应的box app
     *
     * @param channelid 渠道id
     * @return
     */
    @GetMapping("/channel/box")
    public String channelBox(
            @RequestParam("channelid") String channelid,
            @RequestAttribute("auth") String auth
    ) {
        RChannelBox rcb = RChannelBox.R_CHANNEL_BOX;
        TBox tb = TBox.T_BOX;

        Stream<Record3<UInteger, String, String>> stream = null;
        //根据权限不同设置不同查询条件
        if (!auth.equals("2")) {
            stream = dsl.select(tb.ID, tb.BOXNAME, tb.BOXAPPID).from(tb)
                    .fetch().stream();

        } else {
            stream = dsl.select(tb.ID, tb.BOXNAME, tb.BOXAPPID).from(rcb)
                    .innerJoin(tb).on(rcb.BOXID.eq(tb.ID))
                    .where(rcb.CHANNELID.eq(UInteger.valueOf(channelid)))
                    .fetch().stream();
        }

        JSONArray ja = stream.map(result -> {
            JSONObject jo = new JSONObject();
            jo.put("boxid", result.value1());
            jo.put("boxname", result.value2());
            jo.put("boxappid", result.value3());
            return jo;
        }).collect(new JSONArrayCollector<>());

        return RetMsg.strMsgData(1000, "查询盒子数据成功", ja);
    }

    /**
     * 查询指定用户下的box数据
     *
     * @param channelid
     * @return
     */
    @GetMapping("/box/{channelid}")
    public String getBoxByChannelid(
            @PathVariable Integer channelid
    ) {
        TBox tb = TBox.T_BOX;
        RChannelBox rcb = RChannelBox.R_CHANNEL_BOX;
        return RetMsg.strMsgData(1000, "查询成功", dsl.select(tb.ID, tb.BOXNAME, tb.BOXAPPID).from(tb)
                .innerJoin(rcb).on(rcb.BOXID.eq(tb.ID))
                .where(rcb.CHANNELID.eq(UInteger.valueOf(channelid)))
                .fetch().stream()
                .map(record -> {
                    JSONObject jo = new JSONObject();
                    jo.put("boxid", record.value1());
                    jo.put("boxname", record.value2());
                    jo.put("boxappid", record.value3());
                    return jo;
                }).collect(new JSONArrayCollector<>()));
    }

    /**
     * 新建盒子数据，并将数据对应到渠道商
     *
     * @param channelid
     * @param params
     * @return
     */
    @PostMapping("/box/{channelid}")
    public String addBoxData(
            @PathVariable Integer channelid,
            @RequestBody String params
    ) {
        JSONObject jo_params = new JSONObject(params).getJSONObject("params");
        String boxname = jo_params.getString("boxname");
        String boxappid = jo_params.getString("boxappid");

        TBox tb = TBox.T_BOX;
        RChannelBox rcb = RChannelBox.R_CHANNEL_BOX;
        //1：加盒子数据
        TBoxRecord boxRecord = dsl.insertInto(tb, tb.BOXNAME, tb.BOXAPPID)
                .values(boxname, boxappid)
                .returning(tb.ID).fetchOne();

        //2：增加盒子与渠道用户的关系数据
        int count = dsl.insertInto(rcb, rcb.CHANNELID, rcb.BOXID)
                .values(UInteger.valueOf(channelid), boxRecord.value1())
                .execute();

        return count > 0 ? RetMsg.strMsg(1000, "新建盒子数据成功") : RetMsg.strMsg(1001, "新建盒子数据失败");
    }

    /**
     * 更新盒子数据
     *
     * @param boxid
     * @param params
     * @return
     */
    @PutMapping("/box/{boxid}")
    public String modifyBoxData(
            @PathVariable Integer boxid,
            @RequestBody String params
    ) {
        JSONObject jo_params = new JSONObject(params).getJSONObject("params");
        String boxname = jo_params.getString("boxname");
        String boxappid = jo_params.getString("boxappid");

        TBox tb = TBox.T_BOX;
        int count = dsl.update(tb).set(tb.BOXNAME, boxname)
                .set(tb.BOXAPPID, boxappid)
                .where(tb.ID.eq(UInteger.valueOf(boxid)))
                .execute();
        return count > 0 ? RetMsg.strMsg(1000, "更新盒子数据成功") : RetMsg.strMsg(1001, "更新盒子数据失败");
    }

    /**
     * 删除盒子数据
     * @param channelid
     * @param boxid
     * @return
     */
    @DeleteMapping("/box/{channelid}/{boxid}")
    public String deleteBoxData(
            @PathVariable Integer channelid,
            @PathVariable Integer boxid
    ) {
        TBox tb = TBox.T_BOX;
        RChannelBox rcb = RChannelBox.R_CHANNEL_BOX;
        //1:删除盒子与渠道的关系
        dsl.delete(rcb).where(rcb.CHANNELID.eq(UInteger.valueOf(channelid)).and(rcb.BOXID.eq(UInteger.valueOf(boxid)))).execute();

        //2:删除盒子数据
        int count = dsl.delete(tb).where(tb.ID.eq(UInteger.valueOf(boxid))).execute();

        return count > 0 ? RetMsg.strMsg(1000, "删除盒子数据成功") : RetMsg.strMsg(1001, "删除盒子数据失败");
    }
}
