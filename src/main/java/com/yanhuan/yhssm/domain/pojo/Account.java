package com.yanhuan.yhssm.domain.pojo;

import java.io.Serializable;

/**
 * 账号
 *
 * @author yanhuan1
 */
public class Account implements Serializable {

    private Long id;

    private String name;

    private String email;

    private String password;

    private boolean activated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }
}
