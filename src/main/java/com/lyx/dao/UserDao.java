package com.lyx.dao;

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
public interface UserDao {
    User login(User user);
    //注册1
    User register(String uname);
    //注册2
    int addUser(User user);
}
