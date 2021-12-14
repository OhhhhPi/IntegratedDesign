package com.uestc.monitor.service;

import com.uestc.monitor.domain.pojo.LocationRecord;

import java.util.List;

public interface LocationService {
    int deleteByPrimaryKey(Long lrecordid);

    int insert(LocationRecord record);

    LocationRecord selectByPrimaryKey(Long lrecordid);

    List<LocationRecord> selectAll();

    int updateByPrimaryKey(LocationRecord record);

    LocationRecord selectRecentRecord(Integer userid);
}
