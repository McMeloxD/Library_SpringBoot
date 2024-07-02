package com.lyx.dao.impl;

import com.lyx.dao.UserDao;
import com.lyx.model.User;
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

    @Override
    public User login(String username, String password) {
        return null;
    }

    @Override
    public boolean register(User user) {
        return false;
    }
}
