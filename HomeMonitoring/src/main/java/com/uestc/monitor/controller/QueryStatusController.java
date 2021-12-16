package com.uestc.monitor.controller;

import com.uestc.monitor.domain.model.ResponseModel;
import com.uestc.monitor.domain.model.statusResponseModel;
import com.uestc.monitor.domain.pojo.LocationRecord;
import com.uestc.monitor.domain.pojo.SmokeRecord;
import com.uestc.monitor.domain.pojo.TempHmdRecord;
import com.uestc.monitor.domain.pojo.WindowRecord;
import com.uestc.monitor.service.LocationServiceImpl;
import com.uestc.monitor.service.SmokeServiceImpl;
import com.uestc.monitor.service.TempServiceImpl;
import com.uestc.monitor.service.WindowServiceImpl;
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
    public @ResponseBody
    Object testGetState(@RequestParam("userID") Integer userID) {
        TempHmdRecord TmpHmdRequest = tempService.selectRecentRecord(userID);
        if (TmpHmdRequest == null) {
            return new ResponseModel().setStatus(400).setMsg("TemperatureRecordNotFound");
        }
        SmokeRecord smokeRequest = smokeService.selectRecentRecord(userID);
        if (smokeRequest == null) {
            return new ResponseModel().setStatus(400).setMsg("SmokeRecordNotFound");
        }
        WindowRecord windowRequest = windowService.selectRecentRecord(userID);
        if (windowRequest == null) {
            return new ResponseModel().setStatus(400).setMsg("WindowRecordNotFound");
        }
        LocationRecord locationRequest = locationService.selectRecentRecord(userID);
        if (locationRequest == null) {
            return new ResponseModel().setStatus(400).setMsg("LocationRecordNotFound");
        }

        boolean warnFlag = false;
        int temp = TmpHmdRequest.getTemp();
        boolean tss = TmpHmdRequest.getTemperaturesensor();
        int hmd = TmpHmdRequest.getHmd();
        boolean hss = TmpHmdRequest.getHumiditysensor();
        boolean smk = smokeRequest.getSmoke();
        boolean sms = smokeRequest.getSmokesensor();
        boolean ol = windowRequest.getOverlap();
        boolean lct = locationRequest.getLocation();
        if (smk || ol) {
            warnFlag = true;
        }

        statusResponseModel status = new statusResponseModel().setTemperature(temp).setTemperatureSensor(tss)
                .setHumidity(hmd).setHumiditySensor(hss).setSmoke(smk)
                .setSmokeSensor(sms).setWindow(ol).setLocation(lct).setWarnflag(warnFlag);

        return new ResponseModel().setStatus(200).setMsg("ok").setData(status);
    }

}
