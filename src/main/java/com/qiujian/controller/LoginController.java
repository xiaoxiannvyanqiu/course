package com.qiujian.controller;

import com.qiujian.service.loginservice.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private IUserService userService;
    @RequestMapping("/huigou")
    public String login(String username,String password){
        System.out.println(username + "....." + password);
        //Shiro进行登录
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            SecurityUtils.getSubject().login(token);
            return "/phone/all";
        } catch (AuthenticationException e) {
            e.printStackTrace();
            System.out.println("用户明或密码有误，请先注册或者输入正确的用户名和密码");
        }
        return "/login.jsp";
    }
    @RequestMapping("/zhuce")
    public String zhuCe(String username,String password){
        try {
            int i = userService.insretUser(username, password);
            if (i == 1){
                System.out.println("注册成功");
                return "/login.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("注册失败，请重新注册");
        return "/register.jsp";
    }
}
