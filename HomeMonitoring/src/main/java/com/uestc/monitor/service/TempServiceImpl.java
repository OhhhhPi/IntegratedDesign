package com.uestc.monitor.service;

import com.uestc.monitor.domain.dto.moduleStatusDTO;
import com.uestc.monitor.domain.pojo.TempHmdRecord;
import com.uestc.monitor.mapper.TempHmdRecordMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TempServiceImpl implements TempService {
    @Resource
    private TempHmdRecordMapper tempHmdRecordMapper;

    @Override
    public int insert(TempHmdRecord record) {
        return tempHmdRecordMapper.insert(record);
    }

    @Override
    public TempHmdRecord selectRecentRecord(Integer userID) {
        return tempHmdRecordMapper.selectRecentRecord(userID);
    }

    @Override
    public int[] select12hHmd(Integer userID) {
        return tempHmdRecordMapper.select12hHmd(userID);
    }

    @Override
    public int[] select12hTemp(Integer userID) {
        return tempHmdRecordMapper.select12hTemp(userID);
    }

    @Override
    public moduleStatusDTO queryModuleStatus(Integer userID) {
        return tempHmdRecordMapper.queryModuleStatus(userID);
    }
}
