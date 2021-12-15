package com.uestc.monitor.domain.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class abnormalResponseDTO {
    private String abnormalType;

    private String abnormalContent;

    private Date abnormalTime;
}
