package com.uestc.monitor.controller;

import com.uestc.monitor.domain.model.ResponseModel;
import com.uestc.monitor.domain.vo.abnormalResponseVO;
import com.uestc.monitor.service.AbnormalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QueryAbnormalController {

    private final AbnormalServiceImpl abnormalService;

    @Autowired
    public QueryAbnormalController(AbnormalServiceImpl abnormalService) {
        this.abnormalService = abnormalService;
    }

    @PostMapping("/queryAbnormalData")
    public ResponseModel queryAbnormal(Integer userID){
        List<abnormalResponseVO> aRecord = abnormalService.selectMonthlyRecord(userID);
        return new ResponseModel().setStatus(200).setMsg("ok").setData(aRecord);
    }

}
