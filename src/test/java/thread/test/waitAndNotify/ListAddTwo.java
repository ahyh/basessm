package thread.test.waitAndNotify;

import java.util.ArrayList;
import java.util.List;

/**
 * wait方法释放锁，notify方法不释放锁
 */
public class ListAddTwo {

    private volatile static List list = new ArrayList<>();

    public void add() {
        list.add("yanhuan");
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        final ListAddTwo listAddTwo = new ListAddTwo();
        final Object lock = new Object();

        Thread t1 = new Thread(() -> {
            try {
                synchronized (lock) {
                    for (int i = 0; i < 10; i++) {
                        listAddTwo.add();
                        System.out.println("当前线程：" + Thread.currentThread().getName() + "添加进一个元素...");
                        Thread.sleep(100);
                        if (listAddTwo.size() == 5) {
                            System.out.println("已经发出通知");
                            //notify方法不释放锁，t2线程被唤醒
                            lock.notify();
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                if (listAddTwo.size() != 5) {
                    //wait方法释放锁
                    try {
                        lock.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("当前线程收到通知....");
                throw new RuntimeException("当前线程收到通知....");
            }
        }, "t2");

        /**
         * 首先启动t2线程，锁在wait方法中释放锁
         * t1线程执行完成后，t1线程才开始执行
         */
        t2.start();
        t1.start();
    }
}
