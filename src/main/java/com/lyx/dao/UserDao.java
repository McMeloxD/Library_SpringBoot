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
    User login(String username, String password);
    boolean register(User user);
}
