package designPattern.test.decorator;

/**
 * 入海行驶装饰器
 */
public class WaterDecorator extends DrivingDecorator {

    /**
     * 被装饰的对象呗装饰对象所持有
     */
    public WaterDecorator(Driving driving) {
        super(driving);
    }

    /**
     * 装饰对象新增方法
     */
    public void water() {
        System.out.println("游起来了");
    }

    /**
     * 功能增强的move方法
     */
    public void move() {
        super.move();
        water();
    }

}
