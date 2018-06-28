package thread.test.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * CyclicBarrier测试
 * 等所有线程的FINISH_LINE个=打印出来后才开始执行所有的线程
 */
public class CyclicBarrierDemo {

    //步数
    private static final int FINISH_LINE = 10;
    //多个任务
    private List<Horse> horseList = new ArrayList<>();
    //线程池
    private ExecutorService executorService = Executors.newCachedThreadPool();
    //CyclicBarrier对象
    private CyclicBarrier barrier;

    /**
     * 构造器方法
     *
     * @param nHorses 任务数
     * @param pause   暂停时间
     */
    public CyclicBarrierDemo(int nHorses, final int pause) {
        barrier = new CyclicBarrier(nHorses, () -> {
            /**
             * 每个任务先打印FINISH_LINE个=符号
             */
            StringBuffer buffer = new StringBuffer();
            for (int i = 0; i < FINISH_LINE; i++) {
                buffer.append("=");
            }
            System.out.println(buffer);
            /**
             * 如果有一个任务的strides>=FINISH_LINE则所有线程停止
             */
            for (Horse horse : horseList) {
                if (horse.getStrides() >= FINISH_LINE) {
                    System.out.println(horse + " won!");
                    executorService.shutdownNow();
                    return;
                }
            }
            /**
             * 模拟任务执行
             */
            try {
                TimeUnit.MILLISECONDS.sleep(pause);
            } catch (InterruptedException e) {
                System.out.println("Barrier-action sleep interrupted!");
            }
        });
        /**
         * 添加nHorses个任务到线程池中
         */
        for (int i = 0; i < nHorses; i++) {
            Horse horse = new Horse(barrier);
            horseList.add(horse);
            executorService.execute(horse);
        }
    }

    public static void main(String[] args) {
        int nHorse = 7;
        int pause = 200;
        new CyclicBarrierDemo(nHorse, pause);
    }
}

class Horse implements Runnable {

    private static int counter = 0;
    private final int id = counter++;

    private int strides = 0;
    private static Random random = new Random(47);

    private static CyclicBarrier barrier;

    public Horse(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    public synchronized int getStrides() {
        return strides;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    strides += random.nextInt(3);
                }
                barrier.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public String toString() {
        return "Horse " + id;
    }

    public String tracks() {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < getStrides(); i++) {
            buffer.append("*");
        }
        buffer.append(id);
        return buffer.toString();
    }
}
