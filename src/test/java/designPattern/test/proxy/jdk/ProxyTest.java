package designPattern.test.proxy.jdk;

import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * 代理模式测试
 */
public class ProxyTest {

    @Test
    public void testProxy() throws Exception {
        Singer singer = new JayZhou();
        Agent agent = new Agent(singer);
        Singer proxy = (Singer)Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{Singer.class}, agent);
        proxy.bookTicket();
        proxy.sing();
    }
}
