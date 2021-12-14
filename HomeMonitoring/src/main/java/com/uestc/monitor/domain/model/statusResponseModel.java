package com.uestc.monitor.domain.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class statusResponseModel {
    private int temperature;
    private Boolean temperatureSensor;
    private int humidity;
    private Boolean humiditySensor;
    private Boolean smoke;
    private Boolean smokeSensor;
    private Boolean window;
    private Boolean location;
    private Boolean warnflag;
}
