package com.uestc.monitor.service;

import com.uestc.monitor.domain.pojo.WindowRecord;

import java.util.List;

public interface WindowService {
    int insert(WindowRecord record);

    WindowRecord selectRecentRecord(Integer userid);
}
