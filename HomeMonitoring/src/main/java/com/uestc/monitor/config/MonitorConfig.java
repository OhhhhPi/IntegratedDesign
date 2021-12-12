package com.uestc.monitor.config;

public class MonitorConfig {
    public static final int interfaceReturnOK = 200;
    public static final int interfaceReturnError = 400;

    public static final int LoginFailCodeTypeUnknown = 0;
    public static final int LoginFailCodeTypeUserNotFound = 400;
    public static final int LoginFailCodeTypeWrongPassword = 400;

    public static final int getTempFailCodeTypeUnknown = 0;
    public static final int getTempFailCodeTypeJSONProcessFailed = 1;

    public static final int getHmdFailCodeTypeUnknown = 0;
    public static final int getHmdFailCodeTypeJSONProcessFailed = 1;

    public static final int getSmokeFailCodeTypeUnknown = 0;
    public static final int getSmokeFailCodeTypeJSONProcessFailed = 1;

    public static final int queryStatusFailCodeTypeUnknown = 0;
    public static final int queryStatusFailCodeTypeUserNotFound = 400;
    public static final int queryStatusFailCodeTypeRecordNotFound = 400;

    public static final int getProceedRecordFailCodeTypeUnknow = 0;
    public static final int getProceedRecordFailCodeTypeJSONProcessFailed = 1;
}
