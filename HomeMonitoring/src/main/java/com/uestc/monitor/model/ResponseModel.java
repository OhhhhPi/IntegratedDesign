package com.uestc.monitor.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ResponseModel {

    private Integer status;

    private String msg;

    private Object data;

}
