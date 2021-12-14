package com.uestc.monitor.service;

import com.uestc.monitor.mapper.WindowRecordMapper;
import com.uestc.monitor.domain.pojo.WindowRecord;
import com.uestc.monitor.service.WindowService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class WindowServiceImpl implements WindowService {
    @Resource
    private WindowRecordMapper windowRecordMapper;

    @Override
    public int insert(WindowRecord record) {
        return windowRecordMapper.insert(record);
    }

    @Override
    public WindowRecord selectRecentRecord(Integer userid) {
        return windowRecordMapper.selectRecentRecord(userid);
    }
}