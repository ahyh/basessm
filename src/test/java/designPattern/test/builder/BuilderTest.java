package designPattern.test.builder;

import designPattern.test.builder.interf.RocketBuilder;
import designPattern.test.builder.interf.impl.ChangZheng5Builder;
import designPattern.test.builder.interf.impl.SpaceXFalconHeavyBuilder;
import designPattern.test.builder.vo.Rocket;
import org.junit.Test;

/**
 * Builder模式测试
 */
public class BuilderTest {

    @Test
    public void testBuilder(){
        RocketBuilder builder = new SpaceXFalconHeavyBuilder();
        Rocket rocket = builder.getRocket();
        rocket.launch();
        RocketBuilder builder1 = new ChangZheng5Builder();
        Rocket rocket1 = builder1.getRocket();
        rocket1.launch();
    }

}
