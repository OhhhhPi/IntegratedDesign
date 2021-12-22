package com.uestc.monitor.controller;

import com.uestc.monitor.domain.model.ResponseModel;
import com.uestc.monitor.domain.pojo.LocationRecord;
import com.uestc.monitor.service.LocationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationController {
    private final LocationServiceImpl locationService;

    @Autowired
    public LocationController(LocationServiceImpl locationService) {
        this.locationService = locationService;
    }

    @PostMapping("/setLocation")
    public @ResponseBody
    ResponseModel setLocation(LocationRecord locationRecord) {
        locationService.insert(locationRecord);
        return new ResponseModel().setStatus(200).setMsg("ok");
    }
}
