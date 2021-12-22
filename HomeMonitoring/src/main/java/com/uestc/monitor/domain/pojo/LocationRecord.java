package com.uestc.monitor.domain.pojo;

import java.util.Date;

public class LocationRecord {
    private Long lRecordID;

    private Integer userID;

    private Boolean location;

    private Date time;

    public Long getlRecordID() {
        return lRecordID;
    }

    public void setlRecordID(Long lRecordID) {
        this.lRecordID = lRecordID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
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