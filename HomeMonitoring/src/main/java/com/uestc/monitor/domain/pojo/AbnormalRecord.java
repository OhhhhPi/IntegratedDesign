package com.uestc.monitor.domain.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class AbnormalRecord {
    private Long aRecordID;

    private Integer abnormalUserID;

    private String abnormalType;

    private String abnormalContent;

    private Date abnormalTime;
}
