package designPattern.test.builder.vo;

import java.io.Serializable;

/**
 * 控制系统：Rocket的组成部件
 */
public class ControlSystem implements Serializable {

    //稳定性
    private double stability;

    //快速性
    private double speedability;

    //正确性
    private double validity;

    public double getStability() {
        return stability;
    }

    public void setStability(double stability) {
        this.stability = stability;
    }

    public double getSpeedability() {
        return speedability;
    }

    public void setSpeedability(double speedability) {
        this.speedability = speedability;
    }

    public double getValidity() {
        return validity;
    }

    public void setValidity(double validity) {
        this.validity = validity;
    }
}
