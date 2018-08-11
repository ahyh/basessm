package thread.test.wangwenjun.eventdriven;

/**
 * Channel
 *
 * @param <E>
 */
public interface Channel<E extends Message> {

    /**
     * dispatch方法用于负责Message的调度
     *
     * @param message
     */
    void dispatch(E message);
}
