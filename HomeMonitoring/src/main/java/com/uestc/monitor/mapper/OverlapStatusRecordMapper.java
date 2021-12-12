package com.uestc.monitor.mapper;

import com.uestc.monitor.pojo.OverlapStatusRecord;
import java.util.List;

public interface OverlapStatusRecordMapper {
    int deleteByPrimaryKey(Long orecordid);

    int insert(OverlapStatusRecord record);

    OverlapStatusRecord selectByPrimaryKey(Long orecordid);

    List<OverlapStatusRecord> selectAll();

    int updateByPrimaryKey(OverlapStatusRecord record);

    OverlapStatusRecord selectRecentRecord(Integer userid);
}