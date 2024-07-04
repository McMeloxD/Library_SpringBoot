package com.lyx.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.lyx.dao.UserDao;
import com.lyx.service.UserService;
import com.lyx.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * --- Be Humble and Hungry ---
 *
 * @author McMeloxD
 * @date 2024/7/1
 * @desc
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public User login(User user) {
        //加密
        user.setPassword(SecureUtil.md5(user.getPassword()));
        User user1 = userDao.login(user);
        return user1;
    }

    //注册1
    @Override
    public User register(String uname){
    return userDao.register(uname);
    }
    //注册2
    @Override
    public int addUser(User user){
        //加密
        user.setPassword(SecureUtil.md5(user.getPassword()));
        return userDao.addUser(user);
    }
}
