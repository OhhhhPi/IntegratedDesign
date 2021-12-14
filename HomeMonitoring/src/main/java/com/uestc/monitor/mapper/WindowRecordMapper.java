package com.uestc.monitor.mapper;

import com.uestc.monitor.domain.pojo.WindowRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface WindowRecordMapper {

    int insert(@Param("wRecord") WindowRecord wRecord);

    WindowRecord selectRecentRecord(Integer userid);
}