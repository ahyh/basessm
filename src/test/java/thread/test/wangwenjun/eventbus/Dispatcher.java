package thread.test.wangwenjun.eventbus;

import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/**
 * Dispatcher
 *
 * @author yanhuan1
 */
public class Dispatcher {

    private final Executor executorService;

    private final EventExceptionHandler eventExceptionHandler;

    public static final Executor SEQ_EXECUTOR_SERVICE = SeqExecutorService.INSTANCE;

    public static final Executor PRE_THREAD_EXECUTOR_SERVICE = PreThreadExecutorService.INSTANCE;

    private Dispatcher(Executor executorService, EventExceptionHandler eventExceptionHandler) {
        this.executorService = executorService;
        this.eventExceptionHandler = eventExceptionHandler;
    }

    public void dispatch(Bus bus, Registry registry, Object event, String topic) {
        //根据topic获取所有的Subscriber列表
        ConcurrentLinkedQueue<Subscriber> subscribers = registry.scanSubscriber(topic);
        if (null == subscribers) {
            if (eventExceptionHandler != null) {
                eventExceptionHandler.handle(new IllegalArgumentException("The topic " + topic + "not bind yet!"), new BaseEventContext(bus.getBusName(), null, event));
            }
            return;
        }
        //遍历所有方法，并且通过反射的方式进行方法调用
        subscribers.stream().filter(s -> !s.isDisable())
                .filter(s -> {
                    Method subscribeMethod = s.getSubscribeMethod();
                    Class<?> aClass = subscribeMethod.getParameterTypes()[0];
                    return aClass.isAssignableFrom(event.getClass());
                }).forEach(s -> realInvokeSubscribe(s, event, bus));
    }

    private void realInvokeSubscribe(Subscriber subscriber, Object event, Bus bus) {
        Object subcribeObject = subscriber.getSubcribeObject();
        Method subscribeMethod = subscriber.getSubscribeMethod();
        executorService.execute(() -> {
            try {
                subscribeMethod.invoke(subcribeObject, event);
            } catch (Exception e) {
                if (null != eventExceptionHandler) {
                    eventExceptionHandler.handle(e, new BaseEventContext(bus.getBusName(), subscriber, event));
                }
            }
        });
    }

    public void close() {
        if (executorService instanceof ExecutorService) {
            ((ExecutorService) executorService).shutdown();
        }
    }

    static Dispatcher newDispatcher(EventExceptionHandler eventExceptionHandler, Executor executor) {
        return new Dispatcher(executor, eventExceptionHandler);
    }

    static Dispatcher seqDispatcher(EventExceptionHandler eventExceptionHandler) {
        return new Dispatcher(SEQ_EXECUTOR_SERVICE, eventExceptionHandler);
    }

    static Dispatcher preThreadDispatcher(EventExceptionHandler eventExceptionHandler) {
        return new Dispatcher(PRE_THREAD_EXECUTOR_SERVICE, eventExceptionHandler);
    }

    /**
     * 顺序执行的ExecutorService
     */
    private static class SeqExecutorService implements Executor {

        private final static SeqExecutorService INSTANCE = new SeqExecutorService();

        @Override
        public void execute(Runnable command) {
            command.run();
        }
    }

    /**
     * 每个线程负责一次消息推送
     */
    private static class PreThreadExecutorService implements Executor {

        private final static PreThreadExecutorService INSTANCE = new PreThreadExecutorService();

        @Override
        public void execute(Runnable command) {
            new Thread(command).start();
        }
    }

    /**
     * BaseEventContext:默认EventContext的实现
     */
    private static class BaseEventContext implements EventContext {

        private final String eventBusName;

        private final Subscriber subscriber;

        private final Object event;

        private BaseEventContext(String eventBusName, Subscriber subscriber, Object event) {
            this.eventBusName = eventBusName;
            this.subscriber = subscriber;
            this.event = event;
        }

        @Override
        public String getSource() {
            return this.eventBusName;
        }

        @Override
        public Object getSubscriber() {
            return subscriber != null ? subscriber.getSubcribeObject() : null;
        }

        @Override
        public Method getSubscribe() {
            return subscriber != null ? subscriber.getSubscribeMethod() : null;
        }

        @Override
        public Object getEvent() {
            return this.event;
        }
    }
}
