package com.uestc.monitor.controller;

import com.uestc.monitor.domain.model.ResponseModel;
import com.uestc.monitor.service.TempServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QueryTemperatureController {

    private final TempServiceImpl tempService;

    @Autowired
    public QueryTemperatureController(TempServiceImpl tempService) {
        this.tempService = tempService;
    }

    @PostMapping("/queryHumidity")
    public @ResponseBody
    ResponseModel getHumidity(@RequestParam("userID") Integer userID) {
        int[] hmdRequest = tempService.select12hHmd(userID);
        if (hmdRequest.length == 0) return new ResponseModel().setStatus(400).setMsg("RecordNotFound");
        return new ResponseModel().setStatus(200).setMsg("ok").setData(hmdRequest);
    }

    @PostMapping("/queryTemperature")
    public @ResponseBody
    ResponseModel getTemperature(@RequestParam("userID") Integer userID) {
        int[] tempRequest = tempService.select12hTemp(userID);
        if (tempRequest.length == 0) return new ResponseModel().setStatus(400).setMsg("RecordNotFound");
        return new ResponseModel().setStatus(200).setMsg("ok").setData(tempRequest);
    }
}
