package thread.test.atomic;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 原子变量的操作是原子的
 * 但是多个原子操作不是原子的
 */
public class AtomicUse {

    private static AtomicInteger count = new AtomicInteger(0);

    /**
     * 多个原子操作不是原子的,如果不加synchronized该方法不是原子的
     * 可能打印出来的数字不是10的倍数
     */
    public synchronized int multiAdd() {
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
        count.addAndGet(1);
        count.addAndGet(2);
        count.addAndGet(3);
        count.addAndGet(4);
        return count.get();
    }

    public static void main(String[] args) {
        final AtomicUse au = new AtomicUse();
        List<Thread> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(new Thread(() -> {
                System.out.println(au.multiAdd());
            }, "t" + i));
        }
        for (Thread t : list) {
            t.start();
        }
    }
}
