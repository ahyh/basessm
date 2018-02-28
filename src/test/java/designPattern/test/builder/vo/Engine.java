package designPattern.test.builder.vo;

import java.io.Serializable;

/**
 * 火箭发动机：Rocket的组成部件
 */
public class Engine implements Serializable{

    //材料
    private String material;

    //长
    private double length;

    //宽
    private double width;

    //高
    private double height;

    //重量
    private double weight;

    //动力
    private double power;

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }
}
