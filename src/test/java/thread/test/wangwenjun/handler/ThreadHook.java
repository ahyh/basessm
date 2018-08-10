package thread.test.wangwenjun.handler;

import java.util.concurrent.TimeUnit;

public class ThreadHook {

    static {
        //增加一个钩子线程，在程序停止的时候执行
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("HookThread1 is running");
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("HookThread1 is exit");
        }));

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("HookThread2 is running");
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("HookThread2 is exit");
        }));
    }

    public static void main(String[] args) {
        System.out.println("The progarm is stopping");
    }
}
