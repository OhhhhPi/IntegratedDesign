package com.uestc.monitor.mapper;

import com.uestc.monitor.domain.pojo.TempHmdRecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
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