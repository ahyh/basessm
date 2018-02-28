package designPattern.test.strategy.pojo;

import java.io.Serializable;

/**
 * pojo
 */
public class Person implements Serializable {

    //姓名
    private String name;

    //年龄
    private Integer age;

    //性别
    private Byte gender;

    //体重
    private Double weight;

    //身高
    private Double height;

    //地址
    private String address;

    public Person(){}

    public Person(String name, Integer age, Byte gender, Double weight, Double height, String address) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.weight = weight;
        this.height = height;
        this.address = address;
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

    public Byte getGender() {
        return gender;
    }

    public void setGender(Byte gender) {
        this.gender = gender;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
