package com.uestc.monitor.domain.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class SmokeRecord {
    private Long sRecordID;

    private Integer userID;

    private Boolean smoke;

    private Date time;

    private Boolean smokeSensor;
}