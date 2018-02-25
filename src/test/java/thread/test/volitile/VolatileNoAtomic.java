package thread.test.volitile;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * volatile关键字修饰的变量只是具有可见性，没有原子性
 */
public class VolatileNoAtomic extends Thread {

    /**
     * 使用volatile修饰的原子变量，既有可见性也有原子性
     * atomic类只保证本身方法的原子性，不能保证多个操作的原子性
     */
    private static volatile AtomicInteger count = new AtomicInteger(0);

    /**
     * 如果count只用volatile修饰，则不具备原子性
     * 需要使用原子变量Atomic
     */
    private static void addCount() {
        for (int i = 0; i < 1000; i++) {
            count.incrementAndGet();
        }
        System.out.println(count);
    }

    public void run() {
        addCount();
    }

    public static void main(String[] args) {
        VolatileNoAtomic[] arr = new VolatileNoAtomic[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = new VolatileNoAtomic();
        }
        for (int i = 0; i < 10; i++) {
            arr[i].start();
        }
    }
}
