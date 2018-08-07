package thread.test.future;

/**
 * 任务接口
 *
 * @param <I> 输入
 * @param <O> 输出
 */
@FunctionalInterface
public interface Task<I, O> {

    /**
     * 给定一个参数，返回计算结果
     *
     * @param input
     * @return
     */
    O get(I input);
}
