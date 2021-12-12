package com.uestc.monitor.pojo;

import java.util.Date;

public class LocationRecord {
    private Long lrecordid;

    private Integer userid;

    private Boolean location;

    private Date time;

    public Long getLrecordid() {
        return lrecordid;
    }

    public void setLrecordid(Long lrecordid) {
        this.lrecordid = lrecordid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Boolean getLocation() {
        return location;
    }

    public void setLocation(Boolean location) {
        this.location = location;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}