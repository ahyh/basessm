package thread.test.wangwenjun.eventdriven;

/**
 * 动态路由
 *
 * @param <E>
 */
public interface DynamicRouter<E extends Message> {

    /**
     * 针对每一种Message类型注册相关的Channel，只有找到合适的Channel该Message才能被处理
     *
     * @param messageType 消息类型
     * @param channel     处理方案
     */
    void registerChannel(Class<? extends E> messageType, Channel<? extends E> channel);

    /**
     * 为相应的Channel分配Message
     *
     * @param message 消息
     */
    void dispatch(E message);
}
