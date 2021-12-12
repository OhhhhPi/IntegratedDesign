package com.uestc.monitor.service.impl;

import com.uestc.monitor.mapper.LocationRecordMapper;
import com.uestc.monitor.pojo.LocationRecord;
import com.uestc.monitor.service.LocationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class LocationServiceImpl implements LocationService {
    @Resource
    private LocationRecordMapper locationRecordMapper;
    @Override
    public int deleteByPrimaryKey(Long lrecordid) {
        return locationRecordMapper.deleteByPrimaryKey(lrecordid);
    }

    @Override
    public int insert(LocationRecord record) {
        return locationRecordMapper.insert(record);
    }

    @Override
    public LocationRecord selectByPrimaryKey(Long lrecordid) {
        return locationRecordMapper.selectByPrimaryKey(lrecordid);
    }

    @Override
    public List<LocationRecord> selectAll() {
        return locationRecordMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(LocationRecord record) {
        return locationRecordMapper.updateByPrimaryKey(record);
    }

    @Override
    public LocationRecord selectRecentRecord(Integer userid) {
        return locationRecordMapper.selectRecentRecord(userid);
    }
}
