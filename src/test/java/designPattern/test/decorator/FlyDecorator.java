package designPattern.test.decorator;

/**
 * 飞行装饰类
 */
public class FlyDecorator extends DrivingDecorator {

    /**
     * 被装饰的对象呗装饰对象所持有
     */
    public FlyDecorator(Driving driving) {
        super(driving);
    }

    /**
     * 装饰对象新增方法
     */
    public void fly() {
        System.out.println("飞起来了");
    }

    /**
     * 功能增强的move方法
     */
    public void move() {
        super.move();
        fly();
    }

}
