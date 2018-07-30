package thread.test.wangwenjun.base;

import java.util.concurrent.TimeUnit;

public class ThreadInterrupt extends Thread {

    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(() -> {
            try {
                TimeUnit.MINUTES.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        TimeUnit.SECONDS.sleep(5);
        System.out.println(thread.isInterrupted());
        thread.interrupt();
        System.out.println(thread.isInterrupted());
    }
}
