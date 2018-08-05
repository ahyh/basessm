package thread.test.observer;

/**
 * 任务执行接口
 *
 * @param <T>
 */
@FunctionalInterface
public interface Task<T> {

    T call();
}
