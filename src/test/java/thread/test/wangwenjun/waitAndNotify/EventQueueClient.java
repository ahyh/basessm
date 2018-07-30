package thread.test.wangwenjun.waitAndNotify;

import java.util.concurrent.TimeUnit;

public class EventQueueClient {

    public static void main(String[] args) {
        final EventQueue eventQueue = new EventQueue();
        new Thread(() -> {
            while (true) {
                eventQueue.offer(new EventQueue.Event());
            }
        }, "Producer").start();

        new Thread(() -> {
            while (true) {
                EventQueue.Event take = eventQueue.take();
                try {
                    System.out.println("Take:" + take);
                    TimeUnit.SECONDS.sleep(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "Consumer").start();
    }
}
