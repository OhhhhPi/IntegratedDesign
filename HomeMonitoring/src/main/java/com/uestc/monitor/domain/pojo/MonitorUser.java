package com.uestc.monitor.domain.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class MonitorUser {
    private Integer userid;

    private String username;

    private String userpwd;
}