package thread.test.wangwenjun.base;

import java.util.concurrent.TimeUnit;

/**
 * 测试线程优先级
 *
 * @author yanhuan1
 */
public class ThreadPriority {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            try {
                while (true) {
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println(">>>>>>>>>>>>>>>>>>>");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                while (true) {
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println("********************");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        t1.setPriority(3);
        t2.setPriority(10);
        t1.start();
        t2.start();
    }
}
