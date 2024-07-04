package com.lyx.controller;

import com.lyx.mapper.UserMapper;
import com.lyx.model.User;
import com.lyx.service.UserService;
import com.lyx.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    @PostMapping ("/login")
    public R login(String uname, String password, HttpSession session){
        //先判断有没有这个用户
        User user = userMapper.findUsername(uname);
        if (user != null){
            //存在就执行登录
            User user1 = userService.login(new User(uname, password));
            if (user1 != null){
                session.setAttribute("user", user1);
                return new R(20000,"登陆成功",user1);
            }else return new R(40000,"账号或密码错误！",null);
        }else return new R(50000,"该用户不存在请注册！",null);

    }

    @GetMapping("/register")
    public R register(String username, String password){
        User user = userService.register(username);
        if (user == null){
            //如果库里没有就创建
            int n = userService.addUser(new User(username, password));
            if (n > 0){
                return R.ok("创建成功~");
            }else return R.ok("创建失败~");
        }else {
            //如果已存在就返回创建失败
            return R.ok("该账号已存在~");        }
    }

    @GetMapping("logout")
    public String logout(HttpSession session){
        session.invalidate();//销毁session
        return "redirect:/login.html";
    }
}
