package thread.test.observer;

/**
 * 任务生命周期
 *
 * @param <T>
 */
public interface TaskLifeCycle<T> {

    /**
     * 任务启动时触发onStart方法
     *
     * @param thread 任务
     */
    void onStart(Thread thread);

    /**
     * 任务正在运行时触发onRunning方法
     *
     * @param thread 任务
     */
    void onRunning(Thread thread);

    /**
     * 任务结束时触发onFinish方法
     *
     * @param thread 任务
     */
    void onFinish(Thread thread);

    /**
     * 任务出现异常时触发onError方法
     *
     * @param thread 任务
     */
    void onError(Thread thread,Exception e);

    /**
     * 生命周期接口的空实现
     *
     * @param <T>
     */
    class EmptyLifeCycle<T> implements TaskLifeCycle<T> {

        @Override
        public void onStart(Thread thread) {
            System.out.println("EmptyLifeCycle onStart");
        }

        @Override
        public void onRunning(Thread thread) {
            System.out.println("EmptyLifeCycle onRunning");
        }

        @Override
        public void onFinish(Thread thread) {
            System.out.println("EmptyLifeCycle onFinish");
        }

        @Override
        public void onError(Thread thread,Exception e) {
            System.out.println("EmptyLifeCycle onError");
        }
    }
}
