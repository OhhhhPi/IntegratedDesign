package com.uestc.monitor.service;

import com.uestc.monitor.domain.dto.moduleStatusDTO;
import com.uestc.monitor.domain.pojo.TempHmdRecord;


public interface TempService {

    int insert(TempHmdRecord record);

    TempHmdRecord selectRecentRecord(Integer userID);

    int[] select12hHmd(Integer userID);

    int[] select12hTemp(Integer userID);

    moduleStatusDTO queryModuleStatus(Integer userID);
}
