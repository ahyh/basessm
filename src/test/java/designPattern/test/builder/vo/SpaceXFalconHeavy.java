package designPattern.test.builder.vo;

/**
 * 具体的产品：重型猎鹰
 */
public class SpaceXFalconHeavy extends Rocket {

    @Override
    public void launch() {
        System.out.println("SpaceX重性猎鹰发射....");
    }

}
