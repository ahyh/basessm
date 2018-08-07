package thread.test.future;

/**
 * 回调接口
 *
 * @param <T>
 */
@FunctionalInterface
public interface Callback<T> {

    void call(T t);
}
