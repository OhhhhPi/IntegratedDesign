package com.uestc.monitor.service.impl;

import com.uestc.monitor.mapper.TempHmdRecordMapper;
import com.uestc.monitor.pojo.TempHmdRecord;
import com.uestc.monitor.service.TempService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class TempServiceImpl implements TempService {
    @Resource
    private TempHmdRecordMapper tempHmdRecordMapper;

    @Override
    public int deleteByPrimaryKey(Long recordid) {
        return tempHmdRecordMapper.deleteByPrimaryKey(recordid);
    }

    @Override
    public int insert(TempHmdRecord record) {
        return tempHmdRecordMapper.insert(record);
    }

    @Override
    public TempHmdRecord selectByPrimaryKey(Long recordid) {
        return tempHmdRecordMapper.selectByPrimaryKey(recordid);
    }

    @Override
    public List<TempHmdRecord> selectAll() {
        return tempHmdRecordMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(TempHmdRecord record) {
        return tempHmdRecordMapper.updateByPrimaryKey(record);
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
}
