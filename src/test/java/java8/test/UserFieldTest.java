package java8.test;

import com.yanhuan.yhssm.domain.pojo.User;
import org.junit.Test;
import thread.test.wangwenjun.latch.CountDownLatch;

import java.lang.reflect.Field;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class UserFieldTest {

    private static Field field;

    static {
        try {
            field = User.class.getDeclaredField("username");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static ExecutorService executorService = Executors.newFixedThreadPool(20);

    @Test
    public void test() {
        CountDownLatch latch = new CountDownLatch(100);
        for (int i = 0; i < 100; i++) {
            final int num = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        synchronized (UserFieldTest.class) {
                            User user = new User();
                            user.setUsername("username: " + num);
//                        Field field = User.class.getDeclaredField("username");
                            field.setAccessible(true);
                            TimeUnit.SECONDS.sleep(1);
                            System.out.println(field.get(user));
                            field.setAccessible(false);
                            TimeUnit.SECONDS.sleep(1);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        latch.countDown();
                    }
                }
            });
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End");
    }
}
