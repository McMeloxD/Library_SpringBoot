package com.lyx.service;

import com.lyx.model.User;

/**
 * --- Be Humble and Hungry ---
 *
 * @author Liyuexian
 * @date 2024/7/1
 * @desc
 */
public interface UserService {
    User login(User user);
    //注册查询是否存在用户
    User register(String uname);
    //注册2
    int addUser(User user);
}
