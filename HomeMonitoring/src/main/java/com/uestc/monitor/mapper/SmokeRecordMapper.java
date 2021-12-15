package com.uestc.monitor.mapper;

import com.uestc.monitor.domain.pojo.SmokeRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SmokeRecordMapper {
    int deleteByPrimaryKey(Long srecordid);

    int insert(SmokeRecord record);

    SmokeRecord selectByPrimaryKey(Long srecordid);

    List<SmokeRecord> selectAll();

    int updateByPrimaryKey(SmokeRecord record);

    SmokeRecord selectRecentRecord(Integer userid);

    boolean queryModuleStatus(@Param("userID") Integer userid);
}