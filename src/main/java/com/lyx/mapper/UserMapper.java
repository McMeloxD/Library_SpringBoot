package com.lyx.mapper;

import com.lyx.model.User;
import com.lyx.model.UserVO;

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
    //查询所有借阅信息
    UserVO findUserWithBorrowById(int id);
    //根据书名查询是否有人正在借阅一本书

}
