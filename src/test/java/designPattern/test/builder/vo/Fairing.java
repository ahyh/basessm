package designPattern.test.builder.vo;

import java.io.Serializable;

/**
 * 整流罩：构建Rocket的组成部件
 */
public class Fairing implements Serializable {

    //材质
    private String material;

    //燃点
    private double firePoint;

    //直径
    private double diameter;

    //颜色
    private String color;

    //重量
    private double weight;

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public double getFirePoint() {
        return firePoint;
    }

    public void setFirePoint(double firePoint) {
        this.firePoint = firePoint;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
