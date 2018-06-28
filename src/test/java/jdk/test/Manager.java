package jdk.test;

import java.io.Serializable;

/**
 * 图书馆管理员
 */
public class Manager implements Cloneable, Serializable {

    //编号
    private Long id;

    //姓名
    private String name;

    //年龄
    private Integer age;

    public Manager() {
    }

    public Manager(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
