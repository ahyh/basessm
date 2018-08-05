package thread.test.future;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 提交任务的时候创建一个新的线程来处理该任务
 *
 * @param <I>
 * @param <O>
 */
public class FutureServiceImpl<I, O> implements FutureService<I, O> {

    private final static String FUTURE_THREAD_PREFIX = "Futrue_";

    private final AtomicInteger nextCounter = new AtomicInteger(0);

    private String getNextName() {
        return FUTURE_THREAD_PREFIX + nextCounter.getAndIncrement();
    }

    @Override
    public Future<?> submit(Runnable runnable) {
        final FutureTask<Void> future = new FutureTask<>();
        new Thread(() -> {
            runnable.run();
            future.finish(null);
        }, getNextName()).start();
        return future;
    }

    @Override
    public Future<O> submit(Task<I, O> task, I input, Callback<O> callback) {
        final FutureTask<O> future = new FutureTask<>();
        new Thread(() -> {
            O result = task.get(input);
            future.finish(result);
            if (null != callback) {
                callback.call(result);
            }
        }, getNextName()).start();
        return future;
    }
}
