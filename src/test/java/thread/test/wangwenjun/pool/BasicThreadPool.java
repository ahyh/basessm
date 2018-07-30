package thread.test.wangwenjun.pool;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 自定义的线程池实现类
 */
public class BasicThreadPool extends Thread implements MyThreadPool {

    private final int initSize;

    private final int maxSize;

    private final int coreSize;

    private int activeCount;

    private ThreadFactory threadFactory;

    private final MyRunnableQueue runnableQueue;

    private volatile boolean isShutdown = false;

    private final Queue<ThreadTask> threadQueue = new ArrayDeque<>();

    private static final DenyPolicy DEFAULT_DENY_POLICY = new DenyPolicy.DiscardDenyPolicy();

    private static final ThreadFactory DEFAULT_THREAD_FACTORY = new DefaultThreadFactory();

    private final long keepAliveTime;

    private final TimeUnit timeUnit;

    public BasicThreadPool(int initSize, int maxSize, int coreSize, int queueSize) {
        this(initSize, maxSize, coreSize, DEFAULT_THREAD_FACTORY, queueSize, DEFAULT_DENY_POLICY, 10, TimeUnit.SECONDS);
    }

    public BasicThreadPool(int initSize, int maxSize, int coreSize, ThreadFactory threadFactory,
                           int queueSize, DenyPolicy denyPolicy, long keepAliveTime, TimeUnit timeUnit) {
        this.initSize = initSize;
        this.maxSize = maxSize;
        this.coreSize = coreSize;
        this.threadFactory = threadFactory;
        this.runnableQueue = new LinkedRunnableQueue(queueSize, denyPolicy, this);
        this.keepAliveTime = keepAliveTime;
        this.timeUnit = timeUnit;
        this.init();
    }

    /**
     * 静态内部类
     */
    private static class ThreadTask {
        Thread thread;
        MyTask task;

        public ThreadTask(Thread thread, MyTask task) {
            this.thread = thread;
            this.task = task;
        }
    }

    /**
     * 默认的线程工厂
     */
    private static class DefaultThreadFactory implements ThreadFactory{

        private static final AtomicInteger GROUP_COUNTER = new AtomicInteger(1);

        private static final ThreadGroup group = new ThreadGroup("MyThreadPool-"+GROUP_COUNTER.getAndDecrement());

        private static final AtomicInteger COUNTER = new AtomicInteger(0);

        @Override
        public Thread createThread(Runnable runnable) {
            return new Thread(group,runnable,"thread-pool-"+COUNTER.getAndIncrement());
        }
    }

    /**
     * 初始化时先创建initSize个线程
     */
    private void init() {
        start();
        for (int i = 0; i < initSize; i++) {
            newThread();
        }
    }

    /**
     * 创建任务线程并且启动
     */
    private void newThread() {
        MyTask task = new MyTask(runnableQueue);
        Thread thread = this.threadFactory.createThread(task);
        ThreadTask threadTask = new ThreadTask(thread, task);
        threadQueue.offer(threadTask);
        this.activeCount++;
        thread.start();
    }

    /**
     * 从线程池中移除某个线程
     */
    private void removeThread() {
        ThreadTask threadTask = threadQueue.remove();
        threadTask.task.stop();
        this.activeCount--;
    }

    /**
     * 重新Thread的run方法，主要用于维护线程的数量，比如扩容回收等
     */
    @Override
    public void run() {
        while (!isShutdown && !isInterrupted()) {
            try {
                timeUnit.sleep(keepAliveTime);
            } catch (InterruptedException e) {
                isShutdown = true;
                break;
            }
            synchronized (this) {
                if (isShutdown) {
                    break;
                }
                //当前队列中有任务未处理，且活跃线程数小于核心线程数则扩容
                if (runnableQueue.size() > 0 && activeCount < coreSize) {
                    for (int i = initSize; i < coreSize; i++) {
                        newThread();
                    }
                    continue;
                }
                //当前队列中有任务未处理，且活跃线程数小于最大线程数则扩容
                if (runnableQueue.size() > 0 && activeCount < maxSize) {
                    for (int i = coreSize; i < maxSize; i++) {
                        newThread();
                    }
                }
                //当前队列中没有任务未处理，则回收线程至数量等于coreSize
                if (runnableQueue.size() == 0 && activeCount > coreSize) {
                    for (int i = coreSize; i < activeCount; i++) {
                        removeThread();
                    }
                }
            }
        }
    }

    /**
     * 提交任务
     *
     * @param runnable
     */
    @Override
    public void execute(Runnable runnable) {
        if (this.isShutdown) {
            throw new IllegalStateException("The threadpool is destoryed!");
        }
        this.runnableQueue.offer(runnable);
    }

    /**
     * 停止线程池中的活动线程，并且将isShutdown开关设置为true
     */
    @Override
    public void shutdown() {
        synchronized (this){
            if(isShutdown) return;
            isShutdown = true;
            threadQueue.forEach(threadTask -> {
                threadTask.task.stop();
                threadTask.thread.interrupt();
            });
            this.interrupt();
        }
    }

    @Override
    public int getInitSize() {
        if (this.isShutdown) {
            throw new IllegalStateException("The threadpool is destoryed!");
        }
        return this.initSize;
    }

    @Override
    public int getMaxSize() {
        if (this.isShutdown) {
            throw new IllegalStateException("The threadpool is destoryed!");
        }
        return this.maxSize;
    }

    @Override
    public int getCoreSize() {
        if (this.isShutdown) {
            throw new IllegalStateException("The threadpool is destoryed!");
        }
        return this.coreSize;
    }

    @Override
    public int getQueueSize() {
        if (this.isShutdown) {
            throw new IllegalStateException("The threadpool is destoryed!");
        }
        return this.runnableQueue.size();
    }

    @Override
    public int getActiveCount() {
        synchronized (this){
            return this.activeCount;
        }
    }

    @Override
    public boolean isShutDown() {
        return this.isShutdown;
    }
}
