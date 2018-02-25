package designPattern.test.proxy.dynamic;

import org.junit.Test;

/**
 * 动态代理测试
 */
public class ProxyTest {

    @Test
    public void testProxy(){
        Renter renter = new Renter();
        Renting proxy = new RenterProxy(renter);
        proxy.renting("在北五环附近找个3000左右的单间");
        proxy.pay(3100.0);
    }
}
