package com.uestc.monitor.domain.pojo;

import java.util.Date;

public class TempHmdRecord {
    private Long recordid;

    private Integer userid;

    private Integer temp;

    private Integer hmd;

    private Date time;

    private Boolean temperaturesensor;

    private Boolean humiditysensor;

    public Long getRecordid() {
        return recordid;
    }

    public void setRecordid(Long recordid) {
        this.recordid = recordid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getTemp() {
        return temp;
    }

    public void setTemp(Integer temp) {
        this.temp = temp;
    }

    public Integer getHmd() {
        return hmd;
    }

    public void setHmd(Integer hmd) {
        this.hmd = hmd;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Boolean getTemperaturesensor() {
        return temperaturesensor;
    }

    public void setTemperaturesensor(Boolean temperaturesensor) {
        this.temperaturesensor = temperaturesensor;
    }

    public Boolean getHumiditysensor() {
        return humiditysensor;
    }

    public void setHumiditysensor(Boolean humiditysensor) {
        this.humiditysensor = humiditysensor;
    }
}