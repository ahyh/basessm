package com.yanhuan.yhssm.service;

import com.yanhuan.yhssm.domain.condition.UserCondition;
import com.yanhuan.yhssm.domain.pojo.User;

/**
 * user服务
 */
public interface UserService {

    Integer insert(User user);

    Integer update(User user);

    Integer delete(Long id);

    User getUserByCondition(UserCondition condition);
}
