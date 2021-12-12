package com.uestc.monitor.service;

import com.uestc.monitor.pojo.OverlapStatusRecord;
import org.springframework.stereotype.Service;

import java.util.List;
public interface OverlapService {
    int deleteByPrimaryKey(Long orecordid);

    int insert(OverlapStatusRecord record);

    OverlapStatusRecord selectByPrimaryKey(Long orecordid);

    List<OverlapStatusRecord> selectAll();

    int updateByPrimaryKey(OverlapStatusRecord record);

    OverlapStatusRecord selectRecentRecord(Integer userid);
}
