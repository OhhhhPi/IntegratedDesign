package com.uestc.monitor.mapper;

import com.uestc.monitor.domain.pojo.LocationRecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LocationRecordMapper {
    int deleteByPrimaryKey(Long lrecordid);

    int insert(LocationRecord record);

    LocationRecord selectByPrimaryKey(Long lrecordid);

    List<LocationRecord> selectAll();

    int updateByPrimaryKey(LocationRecord record);

    LocationRecord selectRecentRecord(Integer userid);
}