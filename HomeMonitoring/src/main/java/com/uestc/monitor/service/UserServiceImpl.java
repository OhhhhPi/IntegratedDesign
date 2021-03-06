package com.uestc.monitor.service;

import com.uestc.monitor.domain.pojo.MonitorUser;
import com.uestc.monitor.mapper.MonitorUserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private MonitorUserMapper monitorUserMapper;

    @Override
    public int deleteByPrimaryKey(Integer userid) {
        return monitorUserMapper.deleteByPrimaryKey(userid);
    }

    @Override
    public int insert(MonitorUser record) {
        return monitorUserMapper.insert(record);
    }

    @Override
    public MonitorUser selectByPrimaryKey(Integer userid) {
        return monitorUserMapper.selectByPrimaryKey(userid);
    }

    @Override
    public List<MonitorUser> selectAll() {
        return monitorUserMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(MonitorUser record) {
        return monitorUserMapper.updateByPrimaryKey(record);
    }

}
