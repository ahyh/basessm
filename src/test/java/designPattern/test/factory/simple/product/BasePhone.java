package designPattern.test.factory.simple.product;

import java.io.Serializable;

/**
 * 抽象产品
 */
public abstract class BasePhone implements Serializable {

    //长度
    private double length;

    //宽度
    private double width;

    //厚度
    private double thick;

    //颜色
    private String color;

    public BasePhone(){}

    public BasePhone(double length, double width, double thick, String color) {
        this.length = length;
        this.width = width;
        this.thick = thick;
        this.color = color;
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

    public double getThick() {
        return thick;
    }

    public void setThick(double thick) {
        this.thick = thick;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "BasePhone{" +
                "length=" + length +
                ", width=" + width +
                ", thick=" + thick +
                ", color='" + color + '\'' +
                '}';
    }

}
