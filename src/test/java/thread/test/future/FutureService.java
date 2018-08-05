package thread.test.future;

public interface FutureService<I, O> {

    /**
     * 提交不需要返回值的任务
     *
     * @param runnable 提交的任务
     * @return
     */
    Future<?> submit(Runnable runnable);

    /**
     * 提交有返回值的任务
     *
     * @param task
     * @param input
     * @return
     */
    Future<O> submit(Task<I, O> task, I input, Callback<O> callback);

    /**
     * 静态方法创建一个FutureService的实现
     *
     * @param <T>
     * @param <R>
     * @return
     */
    public static <T, R> FutureService<T, R> newService() {
        return new FutureServiceImpl();
    }
}
