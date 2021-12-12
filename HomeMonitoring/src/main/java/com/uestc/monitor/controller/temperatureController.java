package com.uestc.monitor.controller;

import com.alibaba.fastjson.JSONObject;
import com.uestc.monitor.config.MonitorConfig;
import com.uestc.monitor.pojo.TempHmdRecord;
import com.uestc.monitor.service.impl.TempServiceImpl;
import com.uestc.monitor.util.ExceptionHandler;
import com.uestc.monitor.util.RequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.Date;

/**
 * 接收树莓派传来的温湿度数据并且存储到数据表中
 */

@RestController
@RequestMapping("/temperature")
public class temperatureController {
    @Autowired
    private TempServiceImpl tempService;
    @RequestMapping("/getTemp")
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
            Date time = jsonRequest.getSqlDate("time");

            TempHmdRecord tempHumRecord = new TempHmdRecord();
            tempHumRecord.setTemp(temp);
            tempHumRecord.setHmd(hmd);
            tempHumRecord.setUserid(userID);
            tempHumRecord.setTime(time);

            tempService.insert(tempHumRecord);

            jsonResponse.put("recode",MonitorConfig.interfaceReturnOK);
            System.out.println("Get temp and hmd successfully");
            return jsonResponse;
        } catch (IOException e) {
            return ExceptionHandler.exceptionReturn(MonitorConfig.getHmdFailCodeTypeUnknown,"ErrorInHttpIO");
        }

    }
}
