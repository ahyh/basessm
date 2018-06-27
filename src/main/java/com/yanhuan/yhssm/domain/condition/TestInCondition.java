package com.yanhuan.yhssm.domain.condition;

import com.yanhuan.yhssm.domain.BasePageCondition;

/**
 * 查询条件对象
 * Created by yanhuan1 on 2018/1/16.
 */
public class TestInCondition extends BasePageCondition {

    private String mainNo;

    private String slaveNo;

    private String name;

    private Integer age;

    public String getMainNo() {
        return mainNo;
    }

    public void setMainNo(String mainNo) {
        this.mainNo = mainNo;
    }

    public String getSlaveNo() {
        return slaveNo;
    }

    public void setSlaveNo(String slaveNo) {
        this.slaveNo = slaveNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
