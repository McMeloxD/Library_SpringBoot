package com.lyx.controller;

import com.lyx.model.User;
import com.lyx.service.UserService;
import com.lyx.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/login")
    public R login(String username, String password){
        User user1 = userService.login(new User(username, password));
        return R.ok(user1);
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
}
