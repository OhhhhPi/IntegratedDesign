package com.uestc.monitor.service;

import com.uestc.monitor.domain.pojo.LocationRecord;

public interface LocationService {

    int insert(LocationRecord record);

    LocationRecord selectRecentRecord(Integer userid);
}
