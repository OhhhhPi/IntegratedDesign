package com.uestc.monitor.controller;

import com.alibaba.fastjson.JSONObject;
import com.uestc.monitor.config.MonitorConfig;
import com.uestc.monitor.domain.pojo.MonitorUser;
import com.uestc.monitor.service.UserServiceImpl;
import com.uestc.monitor.util.ExceptionHandler;
import com.uestc.monitor.util.RequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 用户登录
 */

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @RequestMapping("/userCheck")
    public JSONObject CheckUser(HttpServletRequest request) throws IOException {
        JSONObject jsonRequest = RequestHandler.receiveJson(request);
        JSONObject jsonResponse = new JSONObject();

        try {
            System.out.println("received json request:"+jsonRequest.toString().substring(0,100));
        }catch (IndexOutOfBoundsException e){
            System.out.println("received json request:"+jsonRequest);
        }

        int userid = jsonRequest.getIntValue("userid");
        String userpwd = jsonRequest.getString("password");

        MonitorUser LoginRequest = userService.selectByPrimaryKey(userid);

        if(LoginRequest == null){
            return ExceptionHandler.exceptionReturn(MonitorConfig.LoginFailCodeTypeUserNotFound,"UserNotFound");
        } else if(!LoginRequest.getUsername().equals(userpwd)){
            return ExceptionHandler.exceptionReturn(MonitorConfig.LoginFailCodeTypeWrongPassword,"WrongPassword");
        }

        jsonResponse.put("code", MonitorConfig.interfaceReturnOK);
        jsonResponse.put("msg","ok");
        jsonResponse.put("data", null);
        System.out.println("Login Succeed");
        return jsonResponse;
    }
}
