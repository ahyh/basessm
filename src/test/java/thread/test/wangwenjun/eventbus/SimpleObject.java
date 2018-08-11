package thread.test.wangwenjun.eventbus;


public class SimpleObject {

    @Subscribe()
    public void test2(String x) {
        System.out.println("x:" + x);
    }

    @Subscribe(topic = "test")
    public void test3(String x) {
        System.out.println("x:" + x);
    }

    public static void main(String[] args) {
        Bus testBus = new EventBus("TestBus");
        testBus.register(new SimpleObject());
        testBus.post("Hello");
        System.out.println("=================");
        testBus.post("Hello","test");
    }
}
