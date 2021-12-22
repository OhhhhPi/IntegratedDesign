package com.uestc.monitor.controller;

import com.uestc.monitor.domain.model.ResponseModel;
import com.uestc.monitor.domain.pojo.AbnormalRecord;
import com.uestc.monitor.domain.pojo.SmokeRecord;
import com.uestc.monitor.service.AbnormalServiceImpl;
import com.uestc.monitor.service.SmokeServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 接收树莓派的烟雾传感器传来的数据并保存记录到数据库中
 * 如果有烟雾还会记录异常数据到数据库中
 */

@RestController
public class SmokeController {
    private final SmokeServiceImpl smokeService;
    private final AbnormalServiceImpl abnormalService;

    public SmokeController(SmokeServiceImpl smokeService, AbnormalServiceImpl abnormalService) {
        this.smokeService = smokeService;
        this.abnormalService = abnormalService;
    }

    @RequestMapping("/setSmoke")
    public ResponseModel setSmoke(SmokeRecord smokeRecord) {

        smokeService.insert(smokeRecord);

        if (smokeRecord.getSmoke())
            abnormalService.insert(new AbnormalRecord().setAbnormalUserID(smokeRecord.getUserID()).setAbnormalType("烟雾异常").setAbnormalContent("存在烟雾，请检查烟雾状态"));

        if (!smokeRecord.getSmokeSensor())
            abnormalService.insert(new AbnormalRecord().setAbnormalUserID(smokeRecord.getUserID()).setAbnormalType("烟雾传感器异常"));
        return new ResponseModel().setStatus(200).setMsg("ok");
    }

}
