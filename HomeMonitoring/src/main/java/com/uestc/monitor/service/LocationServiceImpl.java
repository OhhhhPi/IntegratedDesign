package com.uestc.monitor.service;

import com.uestc.monitor.domain.pojo.LocationRecord;
import com.uestc.monitor.mapper.LocationRecordMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LocationServiceImpl implements LocationService {
    @Resource
    private LocationRecordMapper locationRecordMapper;

    @Override
    public int insert(LocationRecord record) {
        return locationRecordMapper.insert(record);
    }

    @Override
    public LocationRecord selectRecentRecord(Integer userid) {
        return locationRecordMapper.selectRecentRecord(userid);
    }
}
