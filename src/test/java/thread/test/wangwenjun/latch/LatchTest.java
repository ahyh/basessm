package thread.test.wangwenjun.latch;

import java.util.concurrent.TimeUnit;

public class LatchTest {

    public static void main(String[] args) throws Exception {
        Latch latch = new CountDownLatch(4);
        new ProgrmmerTravel(latch, "A", "running").start();
        new ProgrmmerTravel(latch, "B", "bike").start();
        new ProgrmmerTravel(latch, "C", "bus").start();
        new ProgrmmerTravel(latch, "D", "subway").start();
        try {
            latch.await(TimeUnit.SECONDS,5);
            System.out.println("===all of programmer arrived===");
        }catch (WaitTimeoutException e){
            e.printStackTrace();
        }

//        latch.await();
//        System.out.println("===all of programmer arrived===");
    }
}
