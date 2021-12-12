package com.uestc.monitor.mapper;

import com.uestc.monitor.pojo.SmokeRecord;
import java.util.List;

public interface SmokeRecordMapper {
    int deleteByPrimaryKey(Long srecordid);

    int insert(SmokeRecord record);

    SmokeRecord selectByPrimaryKey(Long srecordid);

    List<SmokeRecord> selectAll();

    int updateByPrimaryKey(SmokeRecord record);

    SmokeRecord selectRecentRecord(Integer userid);
}