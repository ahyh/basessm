package designPattern.test.decorator;

/**
 * 汽车
 */
public class Car implements Driving {

    @Override
    public void move() {
        System.out.println("汽车行驶，速度快！");
    }

}
