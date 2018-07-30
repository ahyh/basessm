package thread.test.wangwenjun.pool;

import java.util.LinkedList;

/**
 * 任务队列实现
 *
 * @author yanhuan1
 */
public class LinkedRunnableQueue implements MyRunnableQueue {

    /**
     * 任务队列最大容量
     */
    private final int limit;

    /**
     * 拒绝策略
     */
    private final DenyPolicy denyPolicy;

    /**
     * 任务队列
     */
    private final LinkedList<Runnable> runableList = new LinkedList<>();

    /**
     * 线程池
     */
    private final MyThreadPool threadPool;

    public LinkedRunnableQueue(int limit, DenyPolicy denyPolicy, MyThreadPool threadPool) {
        this.limit = limit;
        this.denyPolicy = denyPolicy;
        this.threadPool = threadPool;
    }

    /**
     * 向任务队列中添加任务，如果已经满了则调用拒绝策略
     *
     * @param runnable 任务
     */
    @Override
    public void offer(Runnable runnable) {
        synchronized (runableList) {
            //队列已满时，执行拒绝策略
            if (runableList.size() >= limit) {
                denyPolicy.reject(runnable, threadPool);
            } else {
                //将任务加在队列中，并唤醒其他线程
                runableList.add(runnable);
                runableList.notifyAll();
            }
        }

    }

    /**
     * 获取任务队列中的任务
     *
     * @return 任务
     * @throws Exception
     */
    @Override
    public Runnable take() throws Exception {
        synchronized (runableList) {
            while (runableList.isEmpty()) {
                try {
                    //如果任务队列中没有可执行的任务，则当前线程会挂起，进入runableList关联的锁等待队列中
                    runableList.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    throw e;
                }
            }
            return runableList.removeFirst();
        }
    }

    /**
     * 返回当前任务队列的任务数
     *
     * @return
     */
    @Override
    public int size() {
        synchronized (runableList) {
            return runableList.size();
        }
    }
}
