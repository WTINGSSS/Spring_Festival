package com.czxy.controller;

import com.czxy.domain.User;
import com.czxy.service.UserService;
import com.czxy.utils.JwtUtils;
import com.czxy.utils.RasUtils;
import com.czxy.vo.BaseResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 庭前云落
 * @Date 2019/12/25 16:43
 * @description
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private static final String priKeyPath = "D:\\ras\\ras.pri";

    @Resource
    private UserService userService;

    @PostMapping("/login")
    public BaseResult login(@RequestBody User user){
        User result = userService.login(user);
        if(result!=null){
            String token=null;
            try {
                token  = JwtUtils.generateToken(result, 30, RasUtils.getPrivateKey(priKeyPath));
            } catch (Exception e) {
                e.printStackTrace();
            }
            return BaseResult.ok("登录成功").append("token",token);
        }else{
            return BaseResult.error("用户名或密码不匹配");
        }
    }
}
