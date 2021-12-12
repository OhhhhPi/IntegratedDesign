package com.uestc.monitor.controller.common;


import com.alibaba.fastjson.JSONObject;

public class TempReceiveStr {
    public static void TempJsonStr(JSONObject jsonRequest){
        try {
            System.out.println("Received JSONString:" + jsonRequest.toString().substring(0, 100));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Received JSONString:" + jsonRequest.toString());
        }
    }
}
