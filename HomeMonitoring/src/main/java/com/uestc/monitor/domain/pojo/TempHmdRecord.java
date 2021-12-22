package com.uestc.monitor.domain.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class TempHmdRecord {
    private Long recordID;

    private Integer userID;

    private Integer temp;

    private Integer hmd;

    private Date time;

    private Boolean temperatureSensor;

    private Boolean humiditySensor;
}