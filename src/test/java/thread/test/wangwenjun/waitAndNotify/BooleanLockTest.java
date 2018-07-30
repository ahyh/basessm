package thread.test.wangwenjun.waitAndNotify;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class BooleanLockTest {

    private final Lock lock = new BooleanLock();


    public static void main(String[] args) {
        BooleanLockTest booleanLockTest = new BooleanLockTest();
        IntStream.range(0, 10).mapToObj(i -> new Thread(booleanLockTest::syncMethod)).forEach(Thread::start);
    }

    public void syncMethod() {
        try {
            //加锁
            lock.lock();
            int randomInt = ThreadLocalRandom.current().nextInt(4);
            System.out.println(Thread.currentThread().getName() + "get the lock!");
            TimeUnit.SECONDS.sleep(randomInt);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
