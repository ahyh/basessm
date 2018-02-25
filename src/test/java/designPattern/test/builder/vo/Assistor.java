package designPattern.test.builder.vo;

import java.io.Serializable;

/**
 * 助推器类：建造Rocket的部件
 */
public class Assistor implements Serializable{

    //直径
    private double diameter;

    //高度
    private double height;

    //推力大小
    private double force;

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getForce() {
        return force;
    }

    public void setForce(double force) {
        this.force = force;
    }
}
