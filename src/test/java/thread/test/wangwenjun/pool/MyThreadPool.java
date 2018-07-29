package thread.test.wangwenjun.pool;

/**
 * 线程池
 *
 * @author yanhuan1
 */
public interface MyThreadPool {

    /**
     * 提交任务到线程池
     *
     * @param runnable
     */
    void execute(Runnable runnable);

    /**
     * 关闭线程池
     */
    void shutdown();

    /**
     * 获取线程池初始化大小
     *
     * @return
     */
    int getInitSize();

    /**
     * 获取线程池最大线程数
     *
     * @return
     */
    int getMaxSize();

    /**
     * 获取线程池核心线程数
     *
     * @return
     */
    int getCoreSize();

    /**
     * 获取线程中用于缓存任务队列的大小
     *
     * @return
     */
    int getQueueSize();

    /**
     * 获取线程中活跃线程数量
     *
     * @return
     */
    int getActiveCount();

    /**
     * 获取线程池是否被关闭
     *
     * @return
     */
    boolean isShutDown();
}
