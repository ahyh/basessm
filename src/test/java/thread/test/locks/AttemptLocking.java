package thread.test.locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 关于显式锁的使用
 */
public class AttemptLocking {

    /**
     * 可重入锁
     */
    private ReentrantLock lock = new ReentrantLock();

    /**
     * 不带时间的锁定，执行完方法后会有清理工作来释放锁
     */
    public void untimed() {
        boolean captured = lock.tryLock();
        try {
            System.out.println("tryLock()..." + captured);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (captured) {
                lock.unlock();
            }
        }
    }

    /**
     * 锁定一段时间，在这段时间内锁定，锁占用不释放
     */
    public void timed() {
        boolean captured;
        try {
            captured = lock.tryLock(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.println("tryLock(2,S)..." + captured);
        } finally {
            if (captured) {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        final AttemptLocking al = new AttemptLocking();
        al.untimed();
        al.timed();
        new Thread() {
            {
                setDaemon(false);
            }

            public void run() {
                al.lock.lock();
                System.out.println("acquired" + al.lock.isLocked());
            }
        }.start();
        Thread.yield();
        al.untimed();
        al.timed();
    }
}
