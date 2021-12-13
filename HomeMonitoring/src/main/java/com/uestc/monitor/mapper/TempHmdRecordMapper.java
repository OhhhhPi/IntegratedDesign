package com.uestc.monitor.mapper;

import com.uestc.monitor.pojo.TempHmdRecord;
import java.util.List;

public interface TempHmdRecordMapper {
    int deleteByPrimaryKey(Long recordid);

    int insert(TempHmdRecord record);

    TempHmdRecord selectByPrimaryKey(Long recordid);

    List<TempHmdRecord> selectAll();

    int updateByPrimaryKey(TempHmdRecord record);

    TempHmdRecord selectRecentRecord(Integer userid);

    int[] select12hHmd(Integer userid);

    int[] select12hTemp(Integer userid);
}