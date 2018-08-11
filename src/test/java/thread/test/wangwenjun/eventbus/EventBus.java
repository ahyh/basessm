package thread.test.wangwenjun.eventbus;

import java.util.concurrent.Executor;

public class EventBus implements Bus {

    private final Registry registry = new Registry();

    private String busName;

    private static final String DEFAULT_BUS_NAME = "default-bus";

    private static final String DEFAULT_TOPIC = "default-topic";

    private final Dispatcher dispatcher;

    public EventBus() {
        this(DEFAULT_BUS_NAME, null, Dispatcher.SEQ_EXECUTOR_SERVICE);
    }

    public EventBus(String busName) {
        this(busName, null, Dispatcher.SEQ_EXECUTOR_SERVICE);
    }

    public EventBus(String busName, EventExceptionHandler eventExceptionHandler, Executor executor) {
        this.busName = busName;
        this.dispatcher = Dispatcher.newDispatcher(eventExceptionHandler, executor);
    }

    public EventBus(EventExceptionHandler eventExceptionHandler) {
        this(DEFAULT_BUS_NAME, eventExceptionHandler, Dispatcher.SEQ_EXECUTOR_SERVICE);
    }

    /**
     * 绑定
     *
     * @param subscriber
     */
    @Override
    public void register(Object subscriber) {
        this.registry.bind(subscriber);
    }

    /**
     * 取消绑定
     *
     * @param subscriber
     */
    @Override
    public void unregister(Object subscriber) {
        this.registry.unbind(subscriber);
    }

    /**
     * 将Event提交到默认的topic
     *
     * @param event
     */
    @Override
    public void post(Object event) {
        this.post(event, DEFAULT_TOPIC);
    }

    /**
     * 将Event提交到制定的topic，具体动作由Dispatcher来完成
     *
     * @param event 时间
     * @param topic 主题
     */
    @Override
    public void post(Object event, String topic) {
        this.dispatcher.dispatch(this, registry, event, topic);
    }

    /**
     * 关闭销毁bus
     */
    @Override
    public void close() {
        this.dispatcher.close();
    }

    @Override
    public String getBusName() {
        return this.busName;
    }
}
