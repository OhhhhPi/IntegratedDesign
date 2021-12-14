package com.uestc.monitor.service;

import com.uestc.monitor.domain.pojo.AbnormalRecord;
import com.uestc.monitor.domain.vo.abnormalResponseVO;

import java.util.List;

public interface AbnormalService {
    boolean insert(AbnormalRecord aRecord);

    List<abnormalResponseVO> selectMonthlyRecord(Integer userID);

}
