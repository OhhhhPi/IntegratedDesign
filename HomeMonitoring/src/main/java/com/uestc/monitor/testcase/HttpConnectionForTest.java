package com.uestc.monitor.testcase;


import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class HttpConnectionForTest {
    public static JSONObject connect(JSONObject jsonRequest, String connect_URL) {
        JSONObject jsonRecieve;
        StringBuilder sb = new StringBuilder();
        try {
            System.out.println("jsonRequest:" + jsonRequest.toString().substring(0, 70));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("jsonRequest:" + jsonRequest);
        }

        try {
            URL url = new URL(connect_URL);
            // 建立 http 连接
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setRequestProperty("Charset", "UTF-8");
            conn.setRequestProperty("contentType", "application/json");
            conn.connect();
            OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
            // 写入请求的 json 字符串
            writer.write(jsonRequest.toString());
            writer.flush();
            writer.close();
            //接收服务器返回的 json
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.
                    getInputStream(), StandardCharsets.UTF_8));
            String line;
            sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            br.close();
            conn.disconnect();
        } catch (IOException e) {
            System.out.println("error occur when establish http connection");
            e.printStackTrace();
        }
        jsonRecieve = JSONObject.parseObject(sb.toString());
        try {
            System.out.println(jsonRecieve.toString().substring(0, 100));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println(jsonRecieve);
        }
        return jsonRecieve;
    }
}

