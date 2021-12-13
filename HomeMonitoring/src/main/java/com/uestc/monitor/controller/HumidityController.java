package com.uestc.monitor.controller;

import com.uestc.monitor.model.ResponseModel;
import com.uestc.monitor.service.impl.TempServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HumidityController {

    private final TempServiceImpl tempService;

    @Autowired
    public HumidityController(TempServiceImpl tempService) {
        this.tempService=tempService;
    }

    @PostMapping("/queryHumidity")
    public @ResponseBody ResponseModel getHumidity(@RequestParam Integer userID){
        int[] hmdRequest = tempService.select12hHmd(userID);
        if(hmdRequest.length==0) return new ResponseModel().setStatus(400).setMsg("RecordNotFound").setData(null);
        return new ResponseModel().setStatus(200).setMsg("ok").setData(hmdRequest);
    }
    @PostMapping("/queryTemperature")
    public @ResponseBody ResponseModel getTemperature(@RequestParam Integer userID){
        int[] tempRequest = tempService.select12hTemp(userID);
        return new ResponseModel().setStatus(200).setMsg("ok").setData(tempRequest);
    }
}
