package com.uestc.monitor.domain.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class abnormalResponseVO {
    private String abnormalType;

    private String abnormalContent;

    private Date abnormalTime;
}
