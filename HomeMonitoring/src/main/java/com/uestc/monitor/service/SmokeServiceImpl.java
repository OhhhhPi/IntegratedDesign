package com.uestc.monitor.service;

import com.uestc.monitor.mapper.SmokeRecordMapper;
import com.uestc.monitor.domain.pojo.SmokeRecord;
import com.uestc.monitor.service.SmokeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class SmokeServiceImpl implements SmokeService {
    @Resource
    private SmokeRecordMapper smokeRecordMapper;

    @Override
    public int deleteByPrimaryKey(Long srecordid) {
        return smokeRecordMapper.deleteByPrimaryKey(srecordid);
    }

    @Override
    public int insert(SmokeRecord record) {
        return smokeRecordMapper.insert(record);
    }

    @Override
    public SmokeRecord selectByPrimaryKey(Long srecordid) {
        return smokeRecordMapper.selectByPrimaryKey(srecordid);
    }

    @Override
    public List<SmokeRecord> selectAll() {
        return smokeRecordMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(SmokeRecord record) {
        return smokeRecordMapper.updateByPrimaryKey(record);
    }

    @Override
    public SmokeRecord selectRecentRecord(Integer userid) {
        return smokeRecordMapper.selectRecentRecord(userid);
    }
}
