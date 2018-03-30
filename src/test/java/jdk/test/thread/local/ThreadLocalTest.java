package jdk.test.thread.local;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * ThreadLocal测试类
 */
public class ThreadLocalTest {

    /**
     * 测试ThreadLocal的类，通过线程池工具提交的方法执行
     * @throws Exception
     */
    @Test
    public void test() throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new ThreadLocalVarHolder());
        }
        TimeUnit.SECONDS.sleep(3);
        executorService.shutdown();
    }
}
