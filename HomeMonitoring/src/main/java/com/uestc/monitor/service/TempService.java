package com.uestc.monitor.service;

import com.uestc.monitor.pojo.TempHmdRecord;

import java.util.List;

public interface TempService {

    int deleteByPrimaryKey(Long recordid);

    int insert(TempHmdRecord record);

    TempHmdRecord selectByPrimaryKey(Long recordid);

    List<TempHmdRecord> selectAll();

    int updateByPrimaryKey(TempHmdRecord record);

    TempHmdRecord selectRecentRecord(Integer userid);

    Object[] select5hHmd(Integer userid);
}
