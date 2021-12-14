package com.uestc.monitor.domain.pojo;

import java.util.Date;

public class WindowRecord {
    private Long wrecordid;

    private Integer userid;

    private Boolean window;

    private Date time;

    public Long getWrecordid() {
        return wrecordid;
    }

    public void setWrecordid(Long wrecordid) {
        this.wrecordid = wrecordid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Boolean getWindow() {
        return window;
    }

    public void setWindow(Boolean window) {
        this.window = window;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}