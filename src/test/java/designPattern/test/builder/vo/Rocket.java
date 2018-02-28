package designPattern.test.builder.vo;

import java.io.Serializable;

/**
 * 需要建造的复杂的对象：火箭
 */
public abstract class Rocket implements Serializable{

    //多个助推器
    private Assistor[] assistors;

    //发动机
    private Engine engine;

    //整流罩
    private Fairing fairing;

    //火箭控制系统
    private ControlSystem controlSystem;

    public Assistor[] getAssistors() {
        return assistors;
    }

    public void setAssistors(Assistor[] assistors) {
        this.assistors = assistors;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Fairing getFairing() {
        return fairing;
    }

    public void setFairing(Fairing fairing) {
        this.fairing = fairing;
    }

    public ControlSystem getControlSystem() {
        return controlSystem;
    }

    public void setControlSystem(ControlSystem controlSystem) {
        this.controlSystem = controlSystem;
    }

    //火箭发射方法
    public abstract void launch();

}
