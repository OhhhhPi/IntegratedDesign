package com.uestc.monitor.domain.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Accessors(chain = true)

public class abnormalResponseDTO {
    private String abnormalType;

    private String abnormalContent;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date abnormalTime;
}
