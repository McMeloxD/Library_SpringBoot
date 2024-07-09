package com.lyx.controller;

import com.lyx.mapper.UserMapper;
import com.lyx.model.User;
import com.lyx.service.UserService;
import com.lyx.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * --- Be Humble and Hungry ---
 *
 * @author McMeloxD
 * @date 2024/7/2
 * @desc
 */
@RestController
@RequestMapping("/api/user/")
@Api(tags = "用户接口")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    @PostMapping ("/login")
    @ApiOperation(value = "用户登录")
    public R login(String uname, String password, HttpSession session){
        //先判断有没有这个用户
        User user = userMapper.findUsername(uname);
        if (user != null){
            //存在就执行登录
            User user1 = userService.login(new User(uname, password));
            if (user1 != null){
                //设置一个session
                session.setAttribute("user", user1);
                return new R(20000,"登陆成功",user);
            }else return new R(40000,"账号或密码错误！",null);
        }else return new R(50000,"该用户不存在请注册！",null);

    }

    @PostMapping("/register")
    @ApiOperation(value = "用户注册")
    public R register(String uname, String password){
        User user = userService.register(uname);
        if (user == null){
            //如果库里没有就创建
            int n = userService.addUser(new User(uname, password));
            if (n > 0){
                return new R(20000,"注册成功，请登录~",null);
            }else return new R(40000,"注册失败，请重试~",null);
        }else {
            //如果已存在就返回创建失败
            return new R(50000,"用户已存在!",null);
        }
    }

    @GetMapping("/exit")
    public void exit(HttpSession session){
        System.out.println("清楚session");
        session.removeAttribute("user");
    }
}
