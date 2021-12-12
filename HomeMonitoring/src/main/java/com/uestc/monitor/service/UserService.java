package com.uestc.monitor.service;

import com.uestc.monitor.pojo.MonitorUser;

import java.util.List;

public interface UserService {
    int deleteByPrimaryKey(Integer userid);

    int insert(MonitorUser record);

    MonitorUser selectByPrimaryKey(Integer userid);

    List<MonitorUser> selectAll();

    int updateByPrimaryKey(MonitorUser record);
}
