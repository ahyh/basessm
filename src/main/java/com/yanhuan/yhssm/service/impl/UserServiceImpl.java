package com.yanhuan.yhssm.service.impl;

import com.google.common.base.Preconditions;
import com.yanhuan.yhssm.dao.UserDao;
import com.yanhuan.yhssm.domain.condition.UserCondition;
import com.yanhuan.yhssm.domain.pojo.User;
import com.yanhuan.yhssm.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * User服务实现类
 *
 * @author yanhuan1
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public Integer insert(User user) {
        Preconditions.checkNotNull(user);
        return userDao.insert(user);
    }

    @Override
    public Integer update(User user) {
        Preconditions.checkNotNull(user);
        return userDao.update(user);
    }

    @Override
    public Integer delete(Long id) {
        Preconditions.checkNotNull(id);
        return userDao.delete(id);
    }

    @Override
    public User getUserByCondition(UserCondition condition) {
        Preconditions.checkNotNull(condition);
        /**
         * 测试Mybatis的缓存机制是否有效，有效的话只会刷一次数据库
         */
        User user = userDao.getUserByCondition(condition);
        return userDao.getUserByCondition(condition);
    }
}
