package com.lyx.mapper;

import com.lyx.model.User;

/**
 * --- Be Humble and Hungry ---
 *
 * @author Liyuexian
 * @date 2024/7/2
 * @desc
 */
public interface UserMapper {
    //登录
    User login(User user);
    //根据用户名查找是否有此人
    User findUsername(String uname);
    //注册
    int addUser(User user);


}
