package thread.test.wangwenjun.pool;

/**
 * 创建一个线程工厂，根据Runnable参数创建线程
 *
 * @author yanhuan1
 */
@FunctionalInterface
public interface ThreadFactory {

    Thread createThread(Runnable runnable);
}
