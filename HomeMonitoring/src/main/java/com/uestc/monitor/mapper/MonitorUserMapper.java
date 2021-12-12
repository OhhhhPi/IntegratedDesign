package com.uestc.monitor.mapper;

import com.uestc.monitor.pojo.MonitorUser;
import java.util.List;

public interface MonitorUserMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(MonitorUser record);

    MonitorUser selectByPrimaryKey(Integer userid);

    List<MonitorUser> selectAll();

    int updateByPrimaryKey(MonitorUser record);
}