package thread.test.wangwenjun.eventbus;

/**
 * Bus接口定义了EventBus的所有方法
 *
 * @author yanhuan1
 */
public interface Bus {

    /**
     * 注册
     *
     * @param subscriber
     */
    void register(Object subscriber);

    /**
     * 取消注册
     *
     * @param subscriber
     */
    void unregister(Object subscriber);

    /**
     * 提交event到默认的topic
     *
     * @param event
     */
    void post(Object event);

    /**
     * 提交event到固定topic
     *
     * @param event
     * @param topic
     */
    void post(Object event, String topic);

    /**
     * 关闭bus
     */
    void close();

    /**
     * 返回bus的名称
     *
     * @return
     */
    String getBusName();
}
