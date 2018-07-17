package com.yanhuan.yhssm.test;

import com.yanhuan.yhssm.domain.pojo.User;
import com.yanhuan.yhssm.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by yanhuan1 on 2018/1/16.
 */
public class UserServiceTest extends BaseTest {

    private static Logger logger = LogManager.getLogger(UserServiceTest.class);

    @Resource
    protected UserService userService;

    @Test
    public void testInsert() {
        User user = new User();
        user.setUsername("yanhuan");
        user.setPassword("yanhuan");
        user.setPhone("111111");
        user.setEmail("yanhuan@jd.com");
        user.setUserType((byte)0);
        user.setUserStatus((byte)0);
        user.setCreateUser("yanhuan");
        userService.insert(user);
    }

}
