package com.uestc.monitor.controller;

import com.uestc.monitor.domain.model.ResponseModel;
import com.uestc.monitor.domain.pojo.AbnormalRecord;
import com.uestc.monitor.domain.pojo.SmokeRecord;
import com.uestc.monitor.service.AbnormalServiceImpl;
import com.uestc.monitor.service.SmokeServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/smoke")
public class SmokeController {
    private final SmokeServiceImpl smokeService;
    private final AbnormalServiceImpl abnormalService;

    public SmokeController(SmokeServiceImpl smokeService, AbnormalServiceImpl abnormalService) {
        this.smokeService = smokeService;
        this.abnormalService = abnormalService;
    }

    @RequestMapping("/getSmoke")
    public ResponseModel getSmoke(@RequestParam("userID") Integer userID, @RequestParam("smoke") boolean smoke, @RequestParam("smokeSensor") boolean smokeSensor) {

        SmokeRecord sRecord = new SmokeRecord().setUserid(userID).setSmoke(smoke).setSmokesensor(smokeSensor);

        smokeService.insert(sRecord);

        if (sRecord.getSmoke())
            abnormalService.insert(new AbnormalRecord().setAbnormalUserID(userID).setAbnormalType("烟雾异常").setAbnormalContent("存在烟雾，请检查烟雾状态"));

        return new ResponseModel().setStatus(200).setMsg("ok");
    }

}
