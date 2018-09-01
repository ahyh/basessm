package com.yanhuan.yhssm.service.impl;

import com.google.common.base.Preconditions;
import com.yanhuan.yhssm.dao.UserDao;
import com.yanhuan.yhssm.domain.condition.UserCondition;
import com.yanhuan.yhssm.domain.pojo.User;
import com.yanhuan.yhssm.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Resource
    private com.yanhuan.provider.interf.UserService dubboUserService;

    @Override
    public Integer insert(User user) {
        Preconditions.checkNotNull(user);
        com.yanhuan.provider.domain.pojo.User pUser = new com.yanhuan.provider.domain.pojo.User();
        pUser.setUsername(user.getUsername());
        pUser.setPassword(user.getPassword());
        pUser.setAddress("安徽省合肥市");
        pUser.setPhone(user.getPhone());
        pUser.setCreateUser(user.getCreateUser());
        dubboUserService.insert(pUser);
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
        return userDao.getUserByCondition(condition);
    }
}
