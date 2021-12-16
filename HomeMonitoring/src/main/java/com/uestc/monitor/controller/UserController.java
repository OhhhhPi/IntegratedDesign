package com.uestc.monitor.controller;

import com.uestc.monitor.domain.model.ResponseModel;
import com.uestc.monitor.domain.pojo.MonitorUser;
import com.uestc.monitor.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户登录
 */

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @RequestMapping("/userCheck")
    public ResponseModel CheckUser(@RequestParam("userID") Integer userID, @RequestParam("userpwd") String userpwd) {

        MonitorUser LoginRequest = userService.selectByPrimaryKey(userID);

        if (LoginRequest == null) {
            return new ResponseModel().setStatus(400).setMsg("UserNotFound");
        } else if (!LoginRequest.getUserpwd().equals(userpwd)) {
            return new ResponseModel().setStatus(400).setMsg("WrongPassword");
        }

        return new ResponseModel().setStatus(200).setMsg("ok");
    }
}
