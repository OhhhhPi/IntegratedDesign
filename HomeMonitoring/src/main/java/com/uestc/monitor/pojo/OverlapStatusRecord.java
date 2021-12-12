package com.uestc.monitor.pojo;

import java.util.Date;

public class OverlapStatusRecord {
    private Long orecordid;

    private Integer userid;

    private Boolean overlapstatus;

    private Date time;

    public Long getOrecordid() {
        return orecordid;
    }

    public void setOrecordid(Long orecordid) {
        this.orecordid = orecordid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Boolean getOverlapstatus() {
        return overlapstatus;
    }

    public void setOverlapstatus(Boolean overlapstatus) {
        this.overlapstatus = overlapstatus;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}