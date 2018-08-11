package thread.test.wangwenjun.eventbus;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class AsyncEventBusTest {

    @Subscribe
    public void method1(String message) {
        System.out.println("AsyncEventBusTest method1:" + message);
    }

    @Subscribe(topic = "test")
    public void method2(String message) {
        System.out.println("AsyncEventBusTest method2:" + message);
    }

    public static void main(String[] args) {
        AsyncEventBus testBus = new AsyncEventBus("TestBus", (ThreadPoolExecutor) Executors.newFixedThreadPool(10));
        testBus.register(new AsyncEventBusTest());
        testBus.post("Hello");
        System.out.println("=====================");
        testBus.post("World", "test");
    }
}
