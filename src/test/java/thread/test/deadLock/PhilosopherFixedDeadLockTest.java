package thread.test.deadLock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 死锁问题测试
 * 死锁条件：当一下4个条件同时满足时就会发生死锁
 * 1-互斥条件：任务使用的资源中至少有一个是不能共享的，本例中筷子都不能共享，需要竞争
 * 2-至少有一个任务它必须持有一个资源且正在等待获取一个当前正在被别的任务持有的资源，
 * 本例中哲学家必须持有一根筷子且其他筷子都被其他哲学家持有
 * 3-资源不能被任务抢占，任务必须把资源释放当做普通事件
 * 4-必须有循环等待，这时一个任务等待其他任务释放资源，其他任务又在等待另外一个任务释放资源，
 * 且直到最后有一个任务在等待第一个任务释放资源，使得大家都被锁住！这种相互等待就是死锁
 */
public class PhilosopherFixedDeadLockTest {

    public static void main(String... args) {
        //创建线程池
        ExecutorService executorService = Executors.newCachedThreadPool();

        //创建5根筷子对象
        Chopstick[] chopsticks = new Chopstick[5];
        for (int i = 0; i < 5; i++) {
            chopsticks[i] = new Chopstick();
        }

        //提交
        /**
         * 解决死锁：
         * 前4个哲学家先拿右边筷子，后拿左边筷子
         * 最后一个哲学家先拿左边筷子，后拿右边筷子
         */
        for (int i = 0; i < 5; i++) {
            if (i < 4) {
                executorService.submit(new Philosopher(i, 5, chopsticks[i], chopsticks[(i + 1) % 5]));
            } else {
                executorService.submit(new Philosopher(i, 5, chopsticks[0], chopsticks[5]));
            }
        }
        executorService.shutdown();
    }
}
