package com.uestc.monitor.util;


import com.alibaba.fastjson.JSONObject;

public class ExceptionHandler {
    public static JSONObject exceptionReturn(int code, String msg) {
        JSONObject jsonResponse = new JSONObject();
        jsonResponse.put("code", code);
        jsonResponse.put("msg", msg);
        jsonResponse.put("data", null);
        System.out.println(jsonResponse);
        return jsonResponse;
    }
}
