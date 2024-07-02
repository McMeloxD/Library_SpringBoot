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
    User login(String username, String password);
    boolean register(User user);
}
