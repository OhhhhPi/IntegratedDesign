package com.uestc.monitor.domain.pojo;

import java.util.Date;

public class SmokeRecord {
    private Long srecordid;

    private Integer userid;

    private Boolean smoke;

    private Date time;

    private Boolean smokesensor;

    public Long getSrecordid() {
        return srecordid;
    }

    public void setSrecordid(Long srecordid) {
        this.srecordid = srecordid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Boolean getSmoke() {
        return smoke;
    }

    public void setSmoke(Boolean smoke) {
        this.smoke = smoke;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Boolean getSmokesensor() {
        return smokesensor;
    }

    public void setSmokesensor(Boolean smokesensor) {
        this.smokesensor = smokesensor;
    }
}