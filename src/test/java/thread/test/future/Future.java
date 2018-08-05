package thread.test.future;

/**
 * future模式接口
 *
 * @param <T>
 */
public interface Future<T> {

    /**
     * 获取执行的结果
     *
     * @return
     * @throws InterruptedException
     */
    T get() throws InterruptedException;

    /**
     * 判断任务是否已经执行完成
     *
     * @return
     */
    boolean done();
}
