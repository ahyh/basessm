package designPattern.test.decorator;

/**
 * 自行车行驶
 */
public class Bike implements Driving {

    /**
     * 初始的自行车行驶方法
     */
    @Override
    public void move() {
       System.out.println("链条传动自行车，骑着累啊！");
    }

}
