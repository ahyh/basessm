package thread.test.wangwenjun.pool;

/**
 * 任务队列，主要用于存放缓存到线程池中的任务
 *
 * @author yanhuan1
 */
public interface MyRunnableQueue {

    /**
     * 将新进的任务缓存在任务队列中
     *
     * @param runnable 任务
     */
    void offer(Runnable runnable);

    /**
     * 工作线程通过take方法获取一个任务
     *
     * @return 任务
     */
    Runnable take() throws Exception;

    /**
     * 获取任务队列的任务数量
     *
     * @return 任务队列中任务数量
     */
    int size();

}
