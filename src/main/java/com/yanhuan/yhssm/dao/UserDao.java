package com.yanhuan.yhssm.dao;

import com.yanhuan.yhssm.domain.condition.UserCondition;
import com.yanhuan.yhssm.domain.pojo.User;

/**
 * user表Dao
 */
public interface UserDao {

    Integer insert(User salary);

    Integer update(User salary);

    Integer delete(Long id);

    User getUserByCondition(UserCondition condition);
}
