package com.uestc.monitor.domain.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class TempHmdRecord {
    private Long recordid;

    private Integer userid;

    private Integer temp;

    private Integer hmd;

    private Date time;

    private Boolean temperaturesensor;

    private Boolean humiditysensor;
}