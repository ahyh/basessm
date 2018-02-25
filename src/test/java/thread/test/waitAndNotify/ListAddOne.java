package thread.test.waitAndNotify;

import java.util.ArrayList;
import java.util.List;

/**
 * 线程间通信：
 * 使用wait/notify方法实现线程间通信，这两个方法都是Object的方法
 * 就是说所有的java对象都有这两个方法
 * 1-wait、notify必须配合synchronized关键字使用
 * 2-wait方法释放锁，notify方法不释放锁
 */
public class ListAddOne {

    private volatile static List list = new ArrayList<>();

    public void add() {
        list.add("yanhuan");
    }

    public int size() {
        return list.size();
    }

    /**
     * t1线程一直往list中添加元素
     * t2线程一直轮询判断list中的元素个数
     * 可以使用wait、notify的方式实现线程间通信
     * @param args
     */
    public static void main(String[] args) {
        final ListAddOne listAddOne = new ListAddOne();
        Thread t1 = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    listAddOne.add();
                    System.out.println("当前线程：" + Thread.currentThread().getName() + "添加进一个元素...");
                    Thread.sleep(500);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            while (true) {
                if (listAddOne.size() == 5) {
                    System.out.println("当前线程收到通知....");
                    throw new RuntimeException("当前线程收到通知....");
                }
            }
        }, "t2");

        t1.start();
        t2.start();
    }

}
