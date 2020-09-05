package com.bsu.ugame.gameparams.api.more;

import com.bsu.ugame.gameparams.collector.JSONArrayCollector;
import com.bsu.ugame.gameparams.jooq.db.tables.TJumpdata;
import com.bsu.ugame.gameparams.tools.RetMsg;
import org.jooq.DSLContext;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.LocalDate;

/**
 * 跳转游戏统计
 */
@RestController
public class MoreGameStatistics {
    @Autowired
    private DSLContext dsl;


    /**
     * 查询挑游戏统计数据
     * @param gameappid
     * @param date
     * @return
     */
    @GetMapping("/moregamestatistics")
    public String queryMoreGameStatistics(
        @RequestParam(value= "gameappid") String gameappid,
        @RequestParam("date") String date
    ){
        LocalDate ld = LocalDate.parse(date);

        TJumpdata tjd = TJumpdata.T_JUMPDATA;
        JSONArray ja = dsl.select(tjd.GAMEAPPID,tjd.OBJECTAPPID,tjd.USERCOUNT).from(tjd)
                .where(tjd.GAMEAPPID.eq(gameappid).and(tjd.CREATETIME.between(Timestamp.valueOf(ld.plusDays(1).atStartOfDay()), Timestamp.valueOf(ld.plusDays(2).atStartOfDay()))))
                .orderBy(tjd.USERCOUNT.desc())
                .fetch().stream()
                .map(result->{
                    JSONObject jo = new JSONObject();
                    jo.put("gameappid",result.value1());
                    jo.put("objectappid",result.value2());
                    jo.put("usercount",result.value3());
                    return jo;
                }).collect(new JSONArrayCollector<>());

        return RetMsg.strMsgData(1000,"查询跳转游戏统计数据成功",ja);
    }
}
