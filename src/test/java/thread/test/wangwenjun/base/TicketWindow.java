package thread.test.wangwenjun.base;

import java.util.concurrent.TimeUnit;

public class TicketWindow implements Runnable {

    private final String name;

    private final Integer MAX = 100;

    private static final Object lock = new Object();

    private static int index = 1;

    public TicketWindow(String name) {
        this.name = name;
    }

    public void run() {
        while (index <= MAX) {
            synchronized (lock) {
                lock.notify();
                System.out.println(Thread.currentThread() + "的号码是:" + index++);
                try {
                    lock.wait();
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void main(String[] args) {
        TicketWindow ticketWindow = new TicketWindow("guitai");
        new Thread(ticketWindow, "2号").start();
        new Thread(ticketWindow, "1号").start();
    }
}
