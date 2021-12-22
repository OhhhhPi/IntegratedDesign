package com.uestc.monitor.mapper;

import com.uestc.monitor.domain.dto.moduleStatusDTO;
import com.uestc.monitor.domain.pojo.TempHmdRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface TempHmdRecordMapper {

    int insert(@Param("record") TempHmdRecord record);

    TempHmdRecord selectRecentRecord(Integer userID);

    int[] select12hHmd(Integer userID);

    int[] select12hTemp(Integer userID);

    moduleStatusDTO queryModuleStatus(@Param("userID") Integer userID);
}