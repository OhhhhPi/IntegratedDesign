package com.uestc.monitor.service;

import com.uestc.monitor.domain.pojo.SmokeRecord;

import java.util.List;

public interface SmokeService {
    int deleteByPrimaryKey(Long srecordid);

    int insert(SmokeRecord record);

    SmokeRecord selectByPrimaryKey(Long srecordid);

    List<SmokeRecord> selectAll();

    int updateByPrimaryKey(SmokeRecord record);

    SmokeRecord selectRecentRecord(Integer userID);

    boolean queryModuleStatus(Integer userID);
}
