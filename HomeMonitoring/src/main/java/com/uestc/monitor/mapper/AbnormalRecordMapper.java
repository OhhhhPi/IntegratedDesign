package com.uestc.monitor.mapper;

import com.uestc.monitor.domain.pojo.AbnormalRecord;
import com.uestc.monitor.domain.dto.abnormalResponseDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AbnormalRecordMapper {
    boolean insert(@Param("aRecord") AbnormalRecord aRecord);

    List<abnormalResponseDTO> selectMonthlyRecord(Integer userID);
}
