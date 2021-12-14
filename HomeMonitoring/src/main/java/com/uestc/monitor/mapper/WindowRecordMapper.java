package com.uestc.monitor.mapper;

import com.uestc.monitor.domain.pojo.WindowRecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WindowRecordMapper {
    int deleteByPrimaryKey(Long wrecordid);

    int insert(WindowRecord record);

    WindowRecord selectByPrimaryKey(Long wrecordid);

    List<WindowRecord> selectAll();

    int updateByPrimaryKey(WindowRecord record);

    WindowRecord selectRecentRecord(Integer userid);
}