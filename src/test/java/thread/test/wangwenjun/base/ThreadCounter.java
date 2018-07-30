package thread.test.wangwenjun.base;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 不断创建线程知道死机
 *
 * @author yanhuan1
 */
public class ThreadCounter extends Thread {

    private static final AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) {
        try {
            while (true) {
                new ThreadCounter().start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            System.out.println("The count" + count.getAndIncrement() + "thread be created!");
            TimeUnit.MILLISECONDS.sleep(10);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
