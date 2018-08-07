package thread.test.wangwenjun.latch;

import java.util.concurrent.TimeUnit;

public class CountDownLatch extends Latch {

    public CountDownLatch(int limit) {
        super(limit);
    }

    @Override
    public void await() throws InterruptedException {
        synchronized (this) {
            //当limit大于0时线程进入阻塞状态
            while (limit > 0) {
                this.wait();
            }
        }
    }

    @Override
    public void countDown() {
        synchronized (this) {
            if (limit <= 0) {
                throw new IllegalStateException("all of tasks has already arrived!");
            }
            limit--;
            this.notifyAll();
        }
    }

    @Override
    public int getUnarrived() {
        return limit;
    }

    @Override
    public void await(TimeUnit unit, long time) throws InterruptedException {
        if (time <= 0) {
            throw new IllegalStateException("The time is invalid！");
        }
        long remainNanos = unit.toNanos(time);
        final long endNanos = System.nanoTime() + remainNanos;
        synchronized (this) {
            while (limit > 0) {
                if (TimeUnit.NANOSECONDS.toMillis(remainNanos) <= 0) {
                    throw new WaitTimeoutException("The wait time over!");
                }
                this.wait(TimeUnit.NANOSECONDS.toMillis(remainNanos));
                remainNanos = endNanos - System.nanoTime();
            }
        }
    }
}
