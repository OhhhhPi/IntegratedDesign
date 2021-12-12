package com.uestc.monitor.controller;

import com.alibaba.fastjson.JSONObject;
import com.uestc.monitor.config.MonitorConfig;
import com.uestc.monitor.pojo.SmokeRecord;
import com.uestc.monitor.service.impl.SmokeServiceImpl;
import com.uestc.monitor.util.ExceptionHandler;
import com.uestc.monitor.util.RequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.Date;

@RestController
@RequestMapping("/smoke")
public class SmokeController {
    private final SmokeServiceImpl smokeService;

    public SmokeController(SmokeServiceImpl smokeService) {
        this.smokeService = smokeService;
    }

    @RequestMapping("/getSmoke")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public JSONObject getSmoke(HttpServletRequest request){
        try {
            JSONObject jsonRequest = RequestHandler.receiveJson(request);
            JSONObject jsonResponse = new JSONObject();
            try {
                System.out.println("Received JSONString:" + jsonRequest.toString().substring(0, 100));
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Received JSONString:" + jsonRequest.toString());
            }
            int userID = jsonRequest.getIntValue("userID");
            Date time = jsonRequest.getSqlDate("time");
            boolean smoke = jsonRequest.getBoolean("smoke");

            SmokeRecord smokeRecord = new SmokeRecord();
            smokeRecord.setUserid(userID);
            smokeRecord.setTime(time);
            smokeRecord.setSmoke(smoke);

            smokeService.insert(smokeRecord);

            jsonResponse.put("recode", MonitorConfig.interfaceReturnOK);
            System.out.println("Get smoke successfully");
            return jsonResponse;
        } catch (IOException e) {
            return ExceptionHandler.exceptionReturn(MonitorConfig.getSmokeFailCodeTypeUnknown,"ErrorInHttpIO");
        }

    }

}
