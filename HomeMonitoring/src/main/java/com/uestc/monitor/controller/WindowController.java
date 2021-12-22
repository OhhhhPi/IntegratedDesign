package com.uestc.monitor.controller;

import com.uestc.monitor.domain.model.ResponseModel;
import com.uestc.monitor.domain.pojo.AbnormalRecord;
import com.uestc.monitor.domain.pojo.WindowRecord;
import com.uestc.monitor.service.AbnormalServiceImpl;
import com.uestc.monitor.service.WindowServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WindowController {
    private final WindowServiceImpl windowService;
    private final AbnormalServiceImpl abnormalService;

    @Autowired
    public WindowController(WindowServiceImpl windowService, AbnormalServiceImpl abnormalService) {
        this.windowService = windowService;
        this.abnormalService = abnormalService;
    }

    @PostMapping("/getWindow")
    public @ResponseBody
    ResponseModel getWindow(@RequestParam("userID") Integer userID, @RequestParam("Overlap") boolean Overlap) {
        WindowRecord windowRecord = new WindowRecord().setUserid(userID).setOverlap(Overlap);
        windowService.insert(windowRecord);
        if (windowRecord.getOverlap()) {
            abnormalService.insert(new AbnormalRecord().setAbnormalUserID(userID).setAbnormalType("翻窗异常").setAbnormalContent("检测到儿童翻窗行为，请及时核查"));
        }
        return new ResponseModel().setStatus(200).setMsg("ok");
    }
}
