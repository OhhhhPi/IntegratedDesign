package com.uestc.monitor.service;

import com.uestc.monitor.domain.pojo.WindowRecord;

import java.util.List;

public interface WindowService {
    int deleteByPrimaryKey(Long wrecordid);

    int insert(WindowRecord record);

    WindowRecord selectByPrimaryKey(Long wrecordid);

    List<WindowRecord> selectAll();

    int updateByPrimaryKey(WindowRecord record);

    WindowRecord selectRecentRecord(Integer userid);
}
