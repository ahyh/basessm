package thread.test.wangwenjun.local;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ThreadLocalDemo {

    public static void main(String[] args) {
        ThreadLocal<Integer> local = new ThreadLocal<>();
        IntStream.range(0, 10).forEach(i -> new Thread(() -> {
            local.set(i);
            System.out.println(Thread.currentThread() + " set i " + i);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + " get i " + local.get());
        }, "Thread" + i).start());
    }
}
