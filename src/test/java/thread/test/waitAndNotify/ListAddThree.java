package thread.test.waitAndNotify;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * wait方法释放锁，notify方法不释放锁
 * 这两个方法必须配合synchronized关键字使用
 */
public class ListAddThree {

    private volatile static List list = new ArrayList<>();

    public void add() {
        list.add("yanhuan");
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        final ListAddThree listAddThree = new ListAddThree();
        /**
         *  CountDownLatch对象可以实现实时通知的效果
         *  不需要synchronized关键字也可以
         *  1表示调用1次countDown方法可以唤醒其他线程
         */
        CountDownLatch countDownLatch = new CountDownLatch(1);

        Thread t1 = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    listAddThree.add();
                    System.out.println("当前线程：" + Thread.currentThread().getName() + "添加进一个元素...");
                    Thread.sleep(100);
                    if (listAddThree.size() == 5) {
                        System.out.println("已经发出通知");
                        countDownLatch.countDown();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            if (listAddThree.size() != 5) {
                try {
                    countDownLatch.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.out.println("当前线程收到通知....");
            throw new RuntimeException("当前线程收到通知....");
        }, "t2");

        /**
         * 首先启动t2线程，锁在wait方法中释放锁
         * t1线程执行完成后，t1线程才开始执行
         */
        t2.start();
        t1.start();
    }
}
