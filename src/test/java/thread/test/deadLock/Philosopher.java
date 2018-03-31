package thread.test.deadLock;

import java.util.concurrent.TimeUnit;

/**
 * 哲学家类
 */
public class Philosopher implements Runnable {

    //哲学家左边的筷子
    private Chopstick left;

    //哲学家右边的筷子
    private Chopstick right;

    //哲学家编号
    private final int id;

    //哲学家思考
    private final int ponderFactor;

    public Philosopher(int id, int ponderFactor, Chopstick left, Chopstick right) {
        this.id = id;
        this.ponderFactor = ponderFactor;
        this.left = left;
        this.right = right;
    }

    /**
     * 哲学家思考，思考时间ponderFactor
     *
     * @throws InterruptedException
     */
    private void thinking() throws InterruptedException {
        //如果不思考直接跳过
        if (ponderFactor == 0) {
            return;
        }
        //哲学家思考ponderFactor
        TimeUnit.MILLISECONDS.sleep(ponderFactor);
    }

    /**
     * run方法，提交的任务如果不打断的话且没有死锁的话会一直进行下去
     */
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                //哲学家先思考片刻
                System.out.println(this + " is thinking！");
                thinking();
                //拿右边的筷子
                System.out.println(this + " taking right chopstick！");
                right.take();
                System.out.println(this + " taked right chopstick！");
                //拿左边的筷子
                System.out.println(this + " taking left chopstick！");
                left.take();
                System.out.println(this + " taked left chopstick！");
                //吃饭
                System.out.println(this + " is eating！");
                //放下筷子
                right.drop();
                left.drop();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String toString() {
        return "Philosopher" + id;
    }
}
