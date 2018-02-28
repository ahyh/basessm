package designPattern.test.decorator;

/**
 * 智能装饰
 */
public class AIDecorator extends DrivingDecorator {

    /**
     * 被装饰的对象呗装饰对象所持有
     */
    public AIDecorator(Driving driving) {
        super(driving);
    }

    /**
     * 装饰对象新增方法
     */
    public void ai() {
        System.out.println("智能起来了");
    }

    /**
     * 功能增强的move方法
     */
    public void move() {
        super.move();
        ai();
    }

}
