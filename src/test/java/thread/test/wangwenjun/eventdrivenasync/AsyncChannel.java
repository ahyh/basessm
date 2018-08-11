package thread.test.wangwenjun.eventdrivenasync;

import thread.test.wangwenjun.eventdriven.Channel;
import thread.test.wangwenjun.eventdriven.MessageEvent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 异步的数据处理通道
 *
 * @author yanhuan1
 */
public abstract class AsyncChannel implements Channel<MessageEvent> {

    private final ExecutorService executorService;

    public AsyncChannel(ExecutorService executorService) {
        this.executorService = executorService;
    }

    public AsyncChannel() {
        this(Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2));
    }

    @Override
    public final void dispatch(MessageEvent message) {
        executorService.submit(() -> this.handle(message));
    }

    /**
     * 提供抽象方法，具体由子类实现
     *
     * @param message
     */
    protected abstract void handle(MessageEvent message);

    public void stop() {
        if (null != executorService && !executorService.isShutdown()) {
            executorService.shutdown();
        }
    }

}
