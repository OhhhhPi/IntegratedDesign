package com.uestc.monitor.service;

import com.uestc.monitor.domain.dto.abnormalResponseDTO;
import com.uestc.monitor.domain.pojo.AbnormalRecord;
import com.uestc.monitor.mapper.AbnormalRecordMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AbnormalServiceImpl implements AbnormalService {
    @Resource
    private AbnormalRecordMapper abnormalRecordMapper;

    @Override
    public boolean insert(AbnormalRecord aRecord) {
        return abnormalRecordMapper.insert(aRecord);
    }

    @Override
    public List<abnormalResponseDTO> selectMonthlyRecord(Integer userID) {
        return abnormalRecordMapper.selectMonthlyRecord(userID);
    }
}
