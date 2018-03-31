package thread.test.deadLock;

/**
 * 例子来自（Java编程思想）：典型的死锁问题
 * 以哲学家就餐问题描述死锁：5个哲学家就餐，哲学家要么在思考，要么在就餐
 * 在思考的时候不需要共享资源，在本例中就是筷子，就餐的时候需要两根筷子
 * 每个哲学家左边和右边各一根筷子
 * 如果哲学家要就餐必须要同时拿到左边和右边的筷子，如果一个哲学家左边或右边
 * 的筷子已经有人在使用了，那么这个哲学家必须等待
 *
 * 筷子类
 */
public class Chopstick {

    //筷子的使用状态，true-使用，false-未使用
    private Boolean taken = false;

    /**
     * 使用筷子的方法
     *
     * @throws InterruptedException
     */
    public synchronized void take() throws InterruptedException {
        //如果筷子的状态是使用，则等待
        while (taken) {
            wait();
        }
        //将筷子的状态改成使用
        taken = true;
    }

    /**
     * 放下筷子方法
     */
    public synchronized void drop() {
        //将筷子的状态改成未使用
        taken = false;
        //通知其他哲学家可以使用这根筷子
        notifyAll();
    }
}
