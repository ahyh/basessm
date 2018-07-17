package com.yanhuan.yhssm.domain.pojo;

import com.yanhuan.yhssm.domain.BaseDomain;

/**
 * user表映射对象
 *
 * @author yanhuan1
 */
public class User extends BaseDomain {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户类型：0-普通用户，1-VIP用户，2-超级VIP用户
     */
    private Byte userType;

    /**
     * 用户状态：0-正常，1-锁定，2-冷冻
     */
    private Byte userStatus;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Byte getUserType() {
        return userType;
    }

    public void setUserType(Byte userType) {
        this.userType = userType;
    }

    public Byte getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Byte userStatus) {
        this.userStatus = userStatus;
    }
}
