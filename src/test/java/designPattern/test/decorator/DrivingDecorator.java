package designPattern.test.decorator;

/**
 * 抽象的装饰类
 */
public abstract class DrivingDecorator implements Driving {

    private Driving driving;

    public DrivingDecorator() {
    }

    /**
     * 被装饰的对象作为构造器参数传入
     */
    public DrivingDecorator(Driving driving) {
        this.driving = driving;
    }

    public Driving getDriving() {
        return driving;
    }

    public void setDriving(Driving driving) {
        this.driving = driving;
    }

    /**
     * 实现基础的功能
     */
    @Override
    public void move() {
        driving.move();
    }

}
