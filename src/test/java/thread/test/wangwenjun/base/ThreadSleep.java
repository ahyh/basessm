package thread.test.wangwenjun.base;

import org.junit.Test;

public class ThreadSleep {

    @Test
    public  void testSleep() {
        new Thread(() -> {
            try {
                long startTime = System.currentTimeMillis();
                Thread.sleep(2000l);
                long endTime = System.currentTimeMillis();
                System.out.println("end-start" + (endTime - startTime));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        try {
            long startTime1 = System.currentTimeMillis();
            Thread.sleep(3000l);
            long endTime1 = System.currentTimeMillis();
            System.out.println("end1-start1" + (endTime1 - startTime1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
