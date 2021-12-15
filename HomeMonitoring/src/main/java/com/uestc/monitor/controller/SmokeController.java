package com.uestc.monitor.controller;

import com.uestc.monitor.domain.model.ResponseModel;
import com.uestc.monitor.domain.pojo.SmokeRecord;
import com.uestc.monitor.service.SmokeServiceImpl;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/smoke")
public class SmokeController {
    private final SmokeServiceImpl smokeService;

    public SmokeController(SmokeServiceImpl smokeService) {
        this.smokeService = smokeService;
    }

    @RequestMapping("/getSmoke")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public ResponseModel getSmoke(@RequestParam Integer userID, @RequestParam boolean smoke, @RequestParam boolean smokeSensor) {

            smokeService.insert(new SmokeRecord().setUserid(userID).setSmoke(smoke).setSmokesensor(smokeSensor));

            return new ResponseModel().setStatus(200).setMsg("ok");

    }

}
