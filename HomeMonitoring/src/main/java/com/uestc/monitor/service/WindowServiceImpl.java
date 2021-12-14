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
    public int deleteByPrimaryKey(Long wrecordid) {
        return windowRecordMapper.deleteByPrimaryKey(wrecordid);
    }

    @Override
    public int insert(WindowRecord record) {
        return windowRecordMapper.insert(record);
    }

    @Override
    public WindowRecord selectByPrimaryKey(Long wrecordid) {
        return windowRecordMapper.selectByPrimaryKey(wrecordid);
    }

    @Override
    public List<WindowRecord> selectAll() {
        return windowRecordMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(WindowRecord record) {
        return windowRecordMapper.updateByPrimaryKey(record);
    }

    @Override
    public WindowRecord selectRecentRecord(Integer userid) {
        return windowRecordMapper.selectRecentRecord(userid);
    }
}
