package thread.test.wangwenjun.voliate;

import java.util.concurrent.TimeUnit;

public class VoliateDemo {

    private final static int MAX = 5;

    private static volatile int init = 0;

    public static void main(String[] args) {
        new Thread(() -> {
            int localValue = init;
            while (localValue < MAX) {
                if (init != localValue) {
                    System.out.println("The init value is updated to" + init);
                    localValue = init;
                }
            }
        }, "Reader").start();

        new Thread(() -> {
            int localValue = init;
            while (localValue < MAX) {
                System.out.println("The init value will be change to" + (++init));
                localValue = init;
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "Writer").start();
    }

}
