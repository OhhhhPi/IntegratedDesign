package com.uestc.monitor.service.impl;

import com.uestc.monitor.mapper.OverlapStatusRecordMapper;
import com.uestc.monitor.pojo.OverlapStatusRecord;
import com.uestc.monitor.service.OverlapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class OverlapServiceImpl implements OverlapService {
    @Resource
    private OverlapStatusRecordMapper overlapMapper;

    @Override
    public int deleteByPrimaryKey(Long orecordid) {
        return overlapMapper.deleteByPrimaryKey(orecordid);
    }

    @Override
    public int insert(OverlapStatusRecord record) {
        return overlapMapper.insert(record);
    }

    @Override
    public OverlapStatusRecord selectByPrimaryKey(Long orecordid) {
        return overlapMapper.selectByPrimaryKey(orecordid);
    }

    @Override
    public List<OverlapStatusRecord> selectAll() {
        return overlapMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(OverlapStatusRecord record) {
        return overlapMapper.updateByPrimaryKey(record);
    }

    @Override
    public OverlapStatusRecord selectRecentRecord(Integer userid) {
        return overlapMapper.selectRecentRecord(userid);
    }
}
