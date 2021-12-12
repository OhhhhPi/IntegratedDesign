package com.uestc.monitor.mapper;

import com.uestc.monitor.pojo.LocationRecord;
import java.util.List;

public interface LocationRecordMapper {
    int deleteByPrimaryKey(Long lrecordid);

    int insert(LocationRecord record);

    LocationRecord selectByPrimaryKey(Long lrecordid);

    List<LocationRecord> selectAll();

    int updateByPrimaryKey(LocationRecord record);

    LocationRecord selectRecentRecord(Integer userid);
}