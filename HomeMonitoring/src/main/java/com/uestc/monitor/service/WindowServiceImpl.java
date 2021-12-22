package com.uestc.monitor.service;

import com.uestc.monitor.domain.pojo.WindowRecord;
import com.uestc.monitor.mapper.WindowRecordMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class WindowServiceImpl implements WindowService {
    @Resource
    private WindowRecordMapper windowRecordMapper;

    @Override
    public int insert(WindowRecord record) {
        return windowRecordMapper.insert(record);
    }

    @Override
    public WindowRecord selectRecentRecord(Integer userID) {
        return windowRecordMapper.selectRecentRecord(userID);
    }
}
