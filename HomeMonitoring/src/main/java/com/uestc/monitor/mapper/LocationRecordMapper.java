package com.uestc.monitor.mapper;

import com.uestc.monitor.domain.pojo.LocationRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LocationRecordMapper {
    int insert(@Param("lRecord") LocationRecord lRecord);

    LocationRecord selectRecentRecord(Integer userID);
}