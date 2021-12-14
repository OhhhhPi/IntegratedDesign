package com.uestc.monitor.domain.pojo;

import lombok.Data;
import lombok.experimental.Accessors;
import java.util.Date;

@Data
@Accessors(chain = true)
public class WindowRecord {
    private Long wrecordid;

    private Integer userid;

    private Boolean Overlap;

    private Date time;
}