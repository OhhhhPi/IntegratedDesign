package com.uestc.monitor.controller;

import com.uestc.monitor.domain.dto.moduleStatusDTO;
import com.uestc.monitor.domain.model.ResponseModel;
import com.uestc.monitor.service.SmokeServiceImpl;
import com.uestc.monitor.service.TempServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QueryModuleStatusController {

    private final TempServiceImpl tempService;
    private final SmokeServiceImpl smokeService;

    @Autowired
    public QueryModuleStatusController(TempServiceImpl tempService, SmokeServiceImpl smokeService) {
        this.tempService = tempService;
        this.smokeService = smokeService;
    }

    @PostMapping("/queryModuleStatus")
    public @ResponseBody
    ResponseModel queryModuleStatus(@RequestParam Integer userID){
        moduleStatusDTO moduleStatus = new moduleStatusDTO().setWindowStatus(true).setLocationStatus(true).setVideoStatus(true);
        boolean[] thStatus = tempService.queryModuleStatus(userID);
        if(thStatus.length==0) return new ResponseModel().setStatus(400).setMsg("Record Not Found");
        boolean sStatus = smokeService.queryModuleStatus(userID);
        moduleStatus.setTemperatureSensorStatus(thStatus[0]).setHumiditySensorStatus(thStatus[1]).setSmokeSensorStatus(sStatus);
        return new ResponseModel().setStatus(200).setMsg("ok").setData(moduleStatus);
    }
}
