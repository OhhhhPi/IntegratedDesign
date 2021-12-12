package com.uestc.monitor.controller;

import com.uestc.monitor.config.MonitorConfig;
import com.uestc.monitor.model.ResponseModel;
import com.uestc.monitor.model.statusResponseModel;
import com.uestc.monitor.pojo.*;
import com.uestc.monitor.service.impl.*;
import com.uestc.monitor.util.ExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 向前端发送当前数据及状态
 */

@RestController
public class QueryStatusController {

    private final SmokeServiceImpl smokeService;
    private final TempServiceImpl tempService;
    private final WindowServiceImpl windowService;
    private final LocationServiceImpl locationService;

    @Autowired
    public QueryStatusController(SmokeServiceImpl smokeService, TempServiceImpl tempService, WindowServiceImpl windowService, LocationServiceImpl locationService) {
        this.smokeService = smokeService;
        this.tempService = tempService;
        this.windowService = windowService;
        this.locationService = locationService;
    }

    @RequestMapping(path = "/queryStatus")
    public @ResponseBody Object testGetState(@RequestParam Integer userID){
        TempHmdRecord TmpHmdRequest = tempService.selectRecentRecord(userID);
        if(TmpHmdRequest == null){
            return ExceptionHandler.exceptionReturn(MonitorConfig.queryStatusFailCodeTypeRecordNotFound,"TmpHmdRecordNotFound");
        }
        SmokeRecord smokeRequest = smokeService.selectRecentRecord(userID);
        if(smokeRequest == null){
            return ExceptionHandler.exceptionReturn(MonitorConfig.queryStatusFailCodeTypeRecordNotFound,"SmokeRecordNotFound");
        }
        WindowRecord windowRequest = windowService.selectRecentRecord(userID);
        if(windowRequest == null){
            return ExceptionHandler.exceptionReturn(MonitorConfig.queryStatusFailCodeTypeRecordNotFound,"WindowRecordNotFound");
        }
        LocationRecord locationRequest = locationService.selectRecentRecord(userID);
        if(locationRequest == null){
            return ExceptionHandler.exceptionReturn(MonitorConfig.queryStatusFailCodeTypeRecordNotFound,"LocationRequestNotFound");
        }

        boolean warnFlag = false;
        int temp = TmpHmdRequest.getTemp();
        boolean tss = TmpHmdRequest.getTemperaturesensor();
        int hmd = TmpHmdRequest.getHmd();
        boolean hss = TmpHmdRequest.getHumiditysensor();
        boolean smk = smokeRequest.getSmoke();
        boolean sms = smokeRequest.getSmokesensor();
        boolean wd = windowRequest.getWindow();
        boolean lct = locationRequest.getLocation();
        if(smk||wd){
            warnFlag = true;
        }

        statusResponseModel status = new statusResponseModel().setTemperature(temp).setTemperatureSensor(tss)
                .setHumidity(hmd).setHumiditySensor(hss).setSmoke(smk)
                .setSmokeSensor(sms).setWindow(wd).setLocation(lct).setWarnflag(warnFlag);

        return new ResponseModel().setStatus(200).setMsg("ok").setData(status);
    }

}
