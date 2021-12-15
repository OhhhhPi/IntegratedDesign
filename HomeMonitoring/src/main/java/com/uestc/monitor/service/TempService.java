package com.uestc.monitor.service;

import com.uestc.monitor.domain.pojo.TempHmdRecord;


public interface TempService {

    int insert(TempHmdRecord record);

    TempHmdRecord selectRecentRecord(Integer userid);

    int[] select12hHmd(Integer userid);

    int[] select12hTemp(Integer userid);

    boolean[] queryModuleStatus(Integer userid);
}
