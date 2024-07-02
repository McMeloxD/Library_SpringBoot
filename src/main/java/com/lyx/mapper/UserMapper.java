package com.lyx.mapper;

import com.lyx.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

/**
 * --- Be Humble and Hungry ---
 *
 * @author McMeloxD
 * @date 2024/7/1
 * @desc
 */
@Service
public interface UserMapper {
    User findUserById(int id);
}
