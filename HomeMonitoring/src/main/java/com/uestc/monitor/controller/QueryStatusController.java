package com.uestc.monitor.controller;

import com.alibaba.fastjson.JSONObject;
import com.uestc.monitor.config.MonitorConfig;
import com.uestc.monitor.pojo.*;
import com.uestc.monitor.service.impl.*;
import com.uestc.monitor.util.ExceptionHandler;
import com.uestc.monitor.util.RequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 向前端发送当前数据及状态
 */

@RestController
@RequestMapping("/info")
public class QueryStatusController {

    private final SmokeServiceImpl smokeService;
    private final TempServiceImpl tempService;
    private final OverlapServiceImpl overlapService;
    private final WindowServiceImpl windowService;
    private final LocationServiceImpl locationService;

    @Autowired
    public QueryStatusController(SmokeServiceImpl smokeService, TempServiceImpl tempService, OverlapServiceImpl overlapService, WindowServiceImpl windowService, LocationServiceImpl locationService) {
        this.smokeService = smokeService;
        this.tempService = tempService;
        this.overlapService = overlapService;
        this.windowService = windowService;
        this.locationService = locationService;
    }

    @RequestMapping(path = "/testQueryStatus")
    public @ResponseBody JSONObject testGetState(@RequestParam Integer userID){
        JSONObject jsonResponse = new JSONObject();
        TempHmdRecord TmpHmdRequest = tempService.selectRecentRecord(userID);
        if(TmpHmdRequest == null){
            return ExceptionHandler.exceptionReturn(MonitorConfig.queryStatusFailCodeTypeRecordNotFound,"TmpHmdRecordNotFound");
        }
        SmokeRecord smokeRequest = smokeService.selectRecentRecord(userID);
        if(smokeRequest == null){
            return ExceptionHandler.exceptionReturn(MonitorConfig.queryStatusFailCodeTypeRecordNotFound,"SmokeRecordNotFound");
        }
        OverlapStatusRecord overlapStatusRequest = overlapService.selectRecentRecord(userID);
        if(overlapStatusRequest == null){
            return ExceptionHandler.exceptionReturn(MonitorConfig.queryStatusFailCodeTypeRecordNotFound,"OverlapRecordNotFound");
        }
        WindowRecord windowRequest = windowService.selectRecentRecord(userID);
        if(windowRequest == null){
            return ExceptionHandler.exceptionReturn(MonitorConfig.queryStatusFailCodeTypeRecordNotFound,"WindowRecordNotFound");
        }
        LocationRecord locationRequest = locationService.selectRecentRecord(userID);
        if(locationRequest == null){
            return ExceptionHandler.exceptionReturn(MonitorConfig.queryStatusFailCodeTypeRecordNotFound,"LocationRequestNotFound");
        }

        int warnFlag = 0;
        int temp = TmpHmdRequest.getTemp();
        Boolean tss = TmpHmdRequest.getTemperaturesensor();
        int hmd = TmpHmdRequest.getHmd();
        Boolean hss = TmpHmdRequest.getHumiditysensor();
        Boolean smk = smokeRequest.getSmoke();
        Boolean sms = smokeRequest.getSmokesensor();
        Boolean wd = windowRequest.getWindow();
        Boolean lct = locationRequest.getLocation();
        if(smk ||wd){
            warnFlag = 1;
        }

        jsonResponse.put("temperature",temp);
        jsonResponse.put("temperatureSensor",tss);
        jsonResponse.put("humidity",hmd);
        jsonResponse.put("humiditySensor",hss);
        jsonResponse.put("smoke",smk);
        jsonResponse.put("smokeSensor",sms);
        jsonResponse.put("window",wd);
        jsonResponse.put("location",lct);
        jsonResponse.put("warnflag",warnFlag);

        return jsonResponse;
    }

    @RequestMapping("/queryStatus")
    public JSONObject getState(HttpServletRequest request){
        try {
            JSONObject jsonRequest = RequestHandler.receiveJson(request);
            JSONObject response = new JSONObject();
            try {
                System.out.println("Received JSONString:" + jsonRequest.toString().substring(0, 100));
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Received JSONString:" + jsonRequest);
            }

            int userID = jsonRequest.getIntValue("userID");
            if(userID==0){
                return ExceptionHandler.exceptionReturn(MonitorConfig.queryStatusFailCodeTypeUserNotFound,"UserNotFound");
            }
            System.out.println("userID="+userID);

            TempHmdRecord tmpHmdRequest = tempService.selectRecentRecord(userID);
            if(tmpHmdRequest == null){
                return ExceptionHandler.exceptionReturn(MonitorConfig.queryStatusFailCodeTypeRecordNotFound,"TmpHmdRecordNotFound");
            }
            SmokeRecord smokeRequest = smokeService.selectRecentRecord(userID);
            if(smokeRequest == null){
                return ExceptionHandler.exceptionReturn(MonitorConfig.queryStatusFailCodeTypeRecordNotFound,"SmokeRecordNotFound");
            }
            OverlapStatusRecord overlapStatusRequest = overlapService.selectRecentRecord(userID);
            if(overlapStatusRequest == null){
                return ExceptionHandler.exceptionReturn(MonitorConfig.queryStatusFailCodeTypeRecordNotFound,"OverlapRecordNotFound");
            }
            WindowRecord windowRequest = windowService.selectRecentRecord(userID);
            if(windowRequest == null){
                return ExceptionHandler.exceptionReturn(MonitorConfig.queryStatusFailCodeTypeRecordNotFound,"WindowRecordNotFound");
            }
            LocationRecord locationRequest = locationService.selectRecentRecord(userID);
            if(locationRequest == null){
                return ExceptionHandler.exceptionReturn(MonitorConfig.queryStatusFailCodeTypeRecordNotFound,"LocationRequestNotFound");
            }

            int warnFlag = 0;
            int temp = tmpHmdRequest.getTemp();
            Boolean tss = tmpHmdRequest.getTemperaturesensor();
            int hmd = tmpHmdRequest.getHmd();
            Boolean hss = tmpHmdRequest.getHumiditysensor();
            Boolean smk = smokeRequest.getSmoke();
            Boolean sms = smokeRequest.getSmokesensor();
            Boolean wd = windowRequest.getWindow();
            Boolean lct = locationRequest.getLocation();
            if(smk ||wd){
                warnFlag = 1;
            }

            response.put("temperature",temp);
            response.put("temperatureSensor",tss);
            response.put("humidity",hmd);
            response.put("humiditySensor",hss);
            response.put("smoke",smk);
            response.put("smokeSensor",sms);
            response.put("window",wd);
            response.put("location",lct);
            response.put("warnflag",warnFlag);

            System.out.println("Get current state successfully");
            return response;
        } catch (IOException e) {
            return null;
        }
    }
}
