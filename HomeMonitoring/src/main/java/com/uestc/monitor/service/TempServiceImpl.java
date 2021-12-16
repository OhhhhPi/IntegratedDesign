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
    public TempHmdRecord selectRecentRecord(Integer userid) {
        return tempHmdRecordMapper.selectRecentRecord(userid);
    }

    @Override
    public int[] select12hHmd(Integer userid) {
        return tempHmdRecordMapper.select12hHmd(userid);
    }

    @Override
    public int[] select12hTemp(Integer userid) {
        return tempHmdRecordMapper.select12hTemp(userid);
    }

    @Override
    public moduleStatusDTO queryModuleStatus(Integer userid) {
        return tempHmdRecordMapper.queryModuleStatus(userid);
    }
}
