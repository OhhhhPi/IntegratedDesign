package com.uestc.monitor.controller;

import com.uestc.monitor.domain.model.ResponseModel;
import com.uestc.monitor.domain.pojo.AbnormalRecord;
import com.uestc.monitor.domain.pojo.MonitorUser;
import com.uestc.monitor.domain.pojo.TempHmdRecord;
import com.uestc.monitor.service.AbnormalServiceImpl;
import com.uestc.monitor.service.TempServiceImpl;
import com.uestc.monitor.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TempHmdController {
    private final TempServiceImpl tempService;
    private final AbnormalServiceImpl abnormalService;
    private final UserServiceImpl userService;

    @Autowired
    public TempHmdController(TempServiceImpl tempService, AbnormalServiceImpl abnormalService, UserServiceImpl userService) {
        this.tempService = tempService;
        this.abnormalService = abnormalService;
        this.userService = userService;
    }

    @PostMapping("setTempHmd")
    public @ResponseBody
    ResponseModel setTempHmd(TempHmdRecord tempHmdRecord) {
        MonitorUser user = userService.selectByPrimaryKey(tempHmdRecord.getUserID());

        if (user == null)
            return new ResponseModel().setStatus(400).setMsg("UserNotFound");
        if (!tempHmdRecord.getTemperatureSensor())
            abnormalService.insert(new AbnormalRecord().setAbnormalUserID(tempHmdRecord.getUserID()).setAbnormalType("温度传感器异常"));
        if (!tempHmdRecord.getHumiditySensor())
            abnormalService.insert(new AbnormalRecord().setAbnormalUserID(tempHmdRecord.getUserID()).setAbnormalType("湿度传感器异常"));
        if (tempHmdRecord.getTemp() > 32)
            abnormalService.insert(new AbnormalRecord().setAbnormalUserID(tempHmdRecord.getUserID()).setAbnormalType("温度异常").setAbnormalContent("温度过低，请检查温度状态"));
        if (tempHmdRecord.getTemp() < 5)
            abnormalService.insert(new AbnormalRecord().setAbnormalUserID(tempHmdRecord.getUserID()).setAbnormalType("温度异常").setAbnormalContent("温度过高，请检查温度状态"));
        if (tempHmdRecord.getHmd() < 20)
            abnormalService.insert(new AbnormalRecord().setAbnormalUserID(tempHmdRecord.getUserID()).setAbnormalType("湿度异常").setAbnormalContent("湿度过低，请检查湿度状态"));
        if (tempHmdRecord.getHmd() > 80)
            abnormalService.insert(new AbnormalRecord().setAbnormalUserID(tempHmdRecord.getUserID()).setAbnormalType("湿度异常").setAbnormalContent("湿度过高，请检查湿度状态"));

        tempService.insert(tempHmdRecord);
        return new ResponseModel().setStatus(200).setMsg("ok");
    }
}
