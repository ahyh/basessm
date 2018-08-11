package thread.test.wangwenjun.eventbus;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * 异步的方式
 *
 * @author yanhuan1
 */
public class AsyncEventBus extends EventBus {

    public AsyncEventBus(String busName, EventExceptionHandler eventExceptionHandler, ThreadPoolExecutor threadPoolExecutor) {
        super(busName, eventExceptionHandler, threadPoolExecutor);
    }

    public AsyncEventBus(String busName, ThreadPoolExecutor threadPoolExecutor) {
        super(busName, null, threadPoolExecutor);
    }

    public AsyncEventBus(ThreadPoolExecutor threadPoolExecutor) {
        super("default-async", null, threadPoolExecutor);
    }

    public AsyncEventBus(EventExceptionHandler eventExceptionHandler, ThreadPoolExecutor threadPoolExecutor) {
        super("default-async", eventExceptionHandler, threadPoolExecutor);
    }
}
