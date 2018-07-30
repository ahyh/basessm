package thread.test.wangwenjun.waitAndNotify;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

/**
 * Boolean锁
 *
 * @author yanhuan1
 */
public class BooleanLock implements Lock {

    /**
     * 当前拥有锁的线程
     */
    private Thread currentThread;

    /**
     * 锁开关
     * false-当前该锁没有被任何线程获得或者已经释放
     * true-该锁已经被某个线程获得，该线程就是currentThread
     */
    private boolean locked = false;

    /**
     * 存储该锁的阻塞线程
     */
    private final List<Thread> blockedThreads = new ArrayList<>();

    @Override
    public void lock() throws InterruptedException {
        synchronized (this) {
            while (locked) {
                try {
                    if (!blockedThreads.contains(Thread.currentThread())) {
                        blockedThreads.add(Thread.currentThread());
                    }
                    this.wait();
                } catch (InterruptedException e) {
                    //如果当前线程在wait时被中断，则从blockThreads中remove，防止内存泄漏
                    blockedThreads.remove(Thread.currentThread());
                    throw e;
                }
            }
            blockedThreads.remove(Thread.currentThread());
            this.locked = true;
            this.currentThread = Thread.currentThread();
        }
    }

    @Override
    public void lock(long mills) throws InterruptedException, TimeoutException {
        synchronized (this) {
            if (mills <= 0) {
                this.lock();
            } else {
                long remainMills = mills;
                long endMills = System.currentTimeMillis() + remainMills;
                while (locked) {
                    if (remainMills <= 0) {
                        throw new TimeoutException("cannot get the lock during");
                    }
                    if (!blockedThreads.contains(Thread.currentThread())) {
                        blockedThreads.add(Thread.currentThread());
                    }
                    this.wait();
                    remainMills = endMills - System.currentTimeMillis();
                }
                blockedThreads.remove(Thread.currentThread());
                this.locked = true;
                this.currentThread = Thread.currentThread();
            }
        }
    }

    @Override
    public void unlock() {
        synchronized (this) {
            if (currentThread == Thread.currentThread()) {
                this.locked = false;
                System.out.println(Thread.currentThread().getName() + "release the lock!");
                this.notifyAll();
            }
        }
    }

    @Override
    public List<Thread> getBlockedThreads() {
        return blockedThreads;
    }
}
