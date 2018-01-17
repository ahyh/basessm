package com.yanhuan.yhssm.domain;

import java.math.BigDecimal;

/**
 * 查询条件对象
 * Created by yanhuan1 on 2018/1/16.
 */
public class SalaryCondition extends BaseDomain{

    private BigDecimal salary;

    private String name;

    private String age;

    private Byte sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }
}
