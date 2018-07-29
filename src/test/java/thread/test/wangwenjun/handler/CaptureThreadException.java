package thread.test.wangwenjun.handler;

import java.util.concurrent.TimeUnit;

public class CaptureThreadException {

    public static void main(String[] args) {
        //设置线程出现异常的回调方法
        Thread.setDefaultUncaughtExceptionHandler((t,e)->{
            System.out.println(t.getName()+" occur exception！");
            e.printStackTrace();
        });
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //在线程的run方法中抛出除0异常
            System.out.println(1/0);
        },"Test-Thread").start();
    }
}
