package com.uestc.monitor.controller;

import com.alibaba.fastjson.JSONObject;
import com.uestc.monitor.config.MonitorConfig;
import com.uestc.monitor.domain.pojo.AbnormalRecord;
import com.uestc.monitor.domain.pojo.TempHmdRecord;
import com.uestc.monitor.service.AbnormalServiceImpl;
import com.uestc.monitor.service.TempServiceImpl;
import com.uestc.monitor.util.ExceptionHandler;
import com.uestc.monitor.util.RequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 接收树莓派传来的温湿度数据并且存储到数据表中
 */

@RestController
@RequestMapping("/temperature")
public class temperatureController {
    private final TempServiceImpl tempService;
    private final AbnormalServiceImpl abnormalService;

    @Autowired
    public temperatureController(TempServiceImpl tempService, AbnormalServiceImpl abnormalService) {
        this.tempService = tempService;
        this.abnormalService = abnormalService;
    }

    @RequestMapping("/getTemp")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public JSONObject getTemp(HttpServletRequest request) {
        try {
            JSONObject jsonRequest = RequestHandler.receiveJson(request);
            System.out.println(jsonRequest);
            JSONObject jsonResponse = new JSONObject();
            try {
                System.out.println("Received JSONString:" + jsonRequest.toString().substring(0, 100));
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Received JSONString:" + jsonRequest);
            }
            int temp = jsonRequest.getIntValue("temp");
            int hmd = jsonRequest.getIntValue("hmd");
            int userID = jsonRequest.getIntValue("userID");
            boolean tss = jsonRequest.getBoolean("temperatureSensor");
            boolean hms = jsonRequest.getBoolean("humiditySensor");

            if (temp > 32) {
                AbnormalRecord aRecord = new AbnormalRecord().setAbnormalUserID(userID).setAbnormalType("temperature").setAbnormalContent("High");
                abnormalService.insert(aRecord);
            } else if (temp < 5) {
                AbnormalRecord aRecord = new AbnormalRecord().setAbnormalUserID(userID).setAbnormalType("temperature").setAbnormalContent("Low");
                abnormalService.insert(aRecord);
            }

            if (hmd < 20) {
                AbnormalRecord aRecord = new AbnormalRecord().setAbnormalUserID(userID).setAbnormalType("Humidity").setAbnormalContent("Low");
                abnormalService.insert(aRecord);
            } else if (hmd > 80) {
                AbnormalRecord aRecord = new AbnormalRecord().setAbnormalUserID(userID).setAbnormalType("Humidity").setAbnormalContent("High");
                abnormalService.insert(aRecord);
            }

            TempHmdRecord tempHumRecord = new TempHmdRecord();
            tempHumRecord.setTemp(temp);
            tempHumRecord.setHmd(hmd);
            tempHumRecord.setUserid(userID);
            tempHumRecord.setTemperaturesensor(tss);
            tempHumRecord.setHumiditysensor(hms);

            tempService.insert(tempHumRecord);

            jsonResponse.put("recode", MonitorConfig.interfaceReturnOK);
            System.out.println("Get temp and hmd successfully");
            return jsonResponse;
        } catch (IOException e) {
            return ExceptionHandler.exceptionReturn(MonitorConfig.getHmdFailCodeTypeUnknown, "ErrorInHttpIO");
        }
    }
}
