package thread.test.wangwenjun.pool;

public class MyTask implements Runnable {

    private final MyRunnableQueue runnableQueue;

    private volatile boolean running = false;

    public MyTask(MyRunnableQueue runnableQueue) {
        this.runnableQueue = runnableQueue;
    }

    /**
     * 如果当前任务为running且没有被中断，则其将不断的从queue中获取任务，执行
     */
    @Override
    public void run() {
        while (running && !Thread.currentThread().isInterrupted()) {
            try {
                Runnable take = runnableQueue.take();
                take.run();
            } catch (Exception e) {
                running = false;
                break;
            }
        }
    }

    /**
     * 停止当前任务，会在线程池的shutdown方法中使用
     */
    public void stop() {
        this.running = false;
    }
}
