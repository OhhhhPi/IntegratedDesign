package com.uestc.monitor.mapper;

import com.uestc.monitor.domain.dto.moduleStatusDTO;
import com.uestc.monitor.domain.pojo.TempHmdRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface TempHmdRecordMapper {

    int insert(@Param("record") TempHmdRecord record);

    TempHmdRecord selectRecentRecord(Integer userid);

    int[] select12hHmd(Integer userid);

    int[] select12hTemp(Integer userid);

    moduleStatusDTO queryModuleStatus(@Param("userID") Integer userid);
}