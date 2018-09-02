package com.yanhuan.yhssm.domain.pojo;

import com.yanhuan.yhssm.annotations.EncrypAnnotation;
import com.yanhuan.yhssm.domain.BaseDomain;

import java.math.BigDecimal;

/**
 * pojo:薪水类
 *
 * @author yanhuan1
 */
public class Salary extends BaseDomain {

    private String name;

    private Integer age;

    private Byte sex;

    /**
     * 公司需要加密
     */
    @EncrypAnnotation
    private String company;

    @EncrypAnnotation
    private BigDecimal salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
