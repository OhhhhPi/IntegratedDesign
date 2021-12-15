package com.uestc.monitor.domain.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class moduleStatusDTO {
    private boolean temperatureSensorStatus;

    private boolean locationStatus;

    private boolean humiditySensorStatus;

    private boolean windowStatus;

    private boolean smokeSensorStatus;

    private boolean videoStatus;
}
