package designPattern.test.builder.interf.impl;

import designPattern.test.builder.interf.RocketBuilder;
import designPattern.test.builder.vo.*;

/**
 * 长征5号：中国长征家族重型火箭
 */
public class ChangZheng5Builder implements RocketBuilder {

    //构建助推器
    @Override
    public Assistor[] buildAssistors() {
        Assistor[] assistors = new Assistor[4];
        Assistor assistor = new Assistor();
        assistor.setDiameter(2.8);
        assistor.setHeight(26.8);
        assistor.setForce(12800.0);
        assistors[0] = assistor;
        assistors[1] = assistor;
        assistors[2] = assistor;
        assistors[3] = assistor;
        return assistors;
    }

    //构建发动机
    @Override
    public Engine buildEngine() {
        Engine engine = new Engine();
        engine.setMaterial("耐高温合金");
        engine.setWeight(10.8);
        engine.setPower(108000.0);
        engine.setLength(4.6);
        engine.setHeight(2.8);
        engine.setWidth(2.8);
        return engine;
    }

    //构建整流罩
    @Override
    public Fairing buildFairing() {
        Fairing fairing = new Fairing();
        fairing.setDiameter(4.9);
        fairing.setFirePoint(1500.0);
        fairing.setWeight(10.8);
        fairing.setColor("white");
        fairing.setMaterial("高温陶瓷");
        return fairing;
    }

    //构建控制系统
    @Override
    public ControlSystem buildControlSystem() {
        ControlSystem controlSystem = new ControlSystem();
        controlSystem.setStability(0.95);
        controlSystem.setSpeedability(0.005);
        controlSystem.setValidity(0.99);
        return controlSystem;
    }

    //获取产品
    @Override
    public Rocket getRocket() {
        Rocket rocket = new ChangZheng5();
        rocket.setAssistors(buildAssistors());
        rocket.setEngine(buildEngine());
        rocket.setFairing(buildFairing());
        rocket.setControlSystem(buildControlSystem());
        return rocket;
    }

}
