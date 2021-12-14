package com.uestc.monitor.mapper;

import com.uestc.monitor.domain.pojo.MonitorUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MonitorUserMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(MonitorUser record);

    MonitorUser selectByPrimaryKey(Integer userid);

    List<MonitorUser> selectAll();

    int updateByPrimaryKey(MonitorUser record);
}