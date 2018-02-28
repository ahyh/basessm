package designPattern.test.builder.interf;

import designPattern.test.builder.vo.*;

/**
 * Builder接口
 */
public interface RocketBuilder {

    Assistor[] buildAssistors();

    Engine buildEngine();

    Fairing buildFairing();

    ControlSystem buildControlSystem();

    Rocket getRocket();

}
