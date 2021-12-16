package com.uestc.monitor.service;

import com.uestc.monitor.domain.dto.abnormalResponseDTO;
import com.uestc.monitor.domain.pojo.AbnormalRecord;

import java.util.List;

public interface AbnormalService {
    boolean insert(AbnormalRecord aRecord);

    List<abnormalResponseDTO> selectMonthlyRecord(Integer userID);

}
