package com.uestc.monitor.controller;

import com.uestc.monitor.domain.dto.abnormalResponseDTO;
import com.uestc.monitor.domain.model.ResponseModel;
import com.uestc.monitor.service.AbnormalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 查询一个月内的异常数据
 */

@RestController
public class QueryAbnormalController {

    private final AbnormalServiceImpl abnormalService;

    @Autowired
    public QueryAbnormalController(AbnormalServiceImpl abnormalService) {
        this.abnormalService = abnormalService;
    }

    @PostMapping("/queryAbnormalData")
    public ResponseModel queryAbnormal(@RequestParam("userID") Integer userID) {
        List<abnormalResponseDTO> aRecord = abnormalService.selectMonthlyRecord(userID);
        if (aRecord.isEmpty()) return new ResponseModel().setStatus(400).setMsg("RecordNotFound");
        return new ResponseModel().setStatus(200).setMsg("ok").setData(aRecord);
    }

}
