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
    public @ResponseBody Object getHumidity(@RequestParam Integer userID){
        Object[] hmdRequest = tempService.select5hHmd(userID);
        return new ResponseModel().setStatus(200).setMsg("ok").setData(hmdRequest);
    }
}
