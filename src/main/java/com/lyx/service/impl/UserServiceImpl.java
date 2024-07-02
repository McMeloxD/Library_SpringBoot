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
    public User login(String username, String password) {
        //加密
        User user = userDao.login(username, SecureUtil.md5(password));
        return user;
    }

    @Override
    public boolean register(User user) {
        //加密
        user.setPassword(SecureUtil.md5(user.getPassword()));
        boolean flag = userDao.register(user);
        return flag;
    }
}
