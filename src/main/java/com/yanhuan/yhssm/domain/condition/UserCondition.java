package com.yanhuan.yhssm.domain.condition;

import com.yanhuan.yhssm.domain.BasePageCondition;

/**
 * 查询条件对象
 * Created by yanhuan1 on 2018/1/16.
 */
public class UserCondition extends BasePageCondition {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 电话号码
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
