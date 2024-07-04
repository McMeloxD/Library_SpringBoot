package com.lyx.dao.impl;

import com.lyx.dao.UserDao;
import com.lyx.mapper.UserMapper;
import com.lyx.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * --- Be Humble and Hungry ---
 *
 * @author McMeloxD
 * @date 2024/7/1
 * @desc
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(User user) {
        User user1 = userMapper.login(user);
        System.out.println(user1);
        return user1;
    }

    //注册1
    @Override
    public User register(String uname){
        User user = userMapper.register(uname);
        return user;
    };

    //注册2
    @Override
    public int addUser(User user){
        int n = userMapper.addUser(user);
        return n;
    };
}
