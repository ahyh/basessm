package thread.test.observer;

/**
 * 可以被观察的
 */
public interface Observable {

    /**
     * 生命周期
     */
    enum Cycle {
        START, RUNNING, DONE, ERROR
    }

    /**
     * 获取当前任务的生命周期
     *
     * @return
     */
    Cycle getCycle();

    /**
     * 启动定义线程的方法
     */
    void start();

    /**
     * 打断定义线程的方法
     */
    void interrupt();
}
