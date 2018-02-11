package designPattern.test.decorator;

import org.junit.Test;

/**
 * 装饰器模式测试
 */
public class DecoratorTest {

    @Test
    public void testDecorator(){
        Driving bike = new FlyDecorator(new Bike());
        bike.move();
        Driving bike1 = new WaterDecorator(new Bike());
        bike1.move();
        Driving bike2 = new AIDecorator(new Bike());
        bike2.move();
        Driving car = new AIDecorator(new Car());
        car.move();
    }

}
