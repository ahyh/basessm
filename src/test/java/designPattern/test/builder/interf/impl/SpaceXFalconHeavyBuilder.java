package designPattern.test.builder.interf.impl;

import designPattern.test.builder.interf.RocketBuilder;
import designPattern.test.builder.vo.*;

/**
 * RocketBuilder具体的实现类
 */
public class SpaceXFalconHeavyBuilder implements RocketBuilder {

    //构建助推器
    @Override
    public Assistor[] buildAssistors() {
        Assistor[] assistors = new Assistor[2];
        Assistor assistor = new Assistor();
        assistor.setDiameter(3.6);
        assistor.setHeight(36.0);
        assistor.setForce(15600.0);
        assistors[0] = assistor;
        assistors[1] = assistor;
        return assistors;
    }

    //构建发动机
    @Override
    public Engine buildEngine() {
        Engine engine = new Engine();
        engine.setLength(5.6);
        engine.setHeight(3.2);
        engine.setWidth(4.2);
        engine.setMaterial("合金");
        engine.setWeight(13.8);
        engine.setPower(168000.0);
        return engine;
    }

    //构建整流罩
    @Override
    public Fairing buildFairing() {
        Fairing fairing = new Fairing();
        fairing.setDiameter(5.6);
        fairing.setFirePoint(2000.0);
        fairing.setWeight(12.8);
        fairing.setColor("white");
        fairing.setMaterial("高强度碳纤维");
        return fairing;
    }

    //构建控制系统
    @Override
    public ControlSystem buildControlSystem() {
        ControlSystem controlSystem = new ControlSystem();
        controlSystem.setStability(0.98);
        controlSystem.setSpeedability(0.002);
        controlSystem.setValidity(0.999);
        return controlSystem;
    }

    //获取产品
    @Override
    public Rocket getRocket() {
        Rocket rocket = new SpaceXFalconHeavy();
        rocket.setAssistors(buildAssistors());
        rocket.setEngine(buildEngine());
        rocket.setFairing(buildFairing());
        rocket.setControlSystem(buildControlSystem());
        return rocket;
    }

}
