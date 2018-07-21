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
            System.out.println("柜台:" + name + "当前的号码是:" + index++);
            notify();
            try {
                TimeUnit.SECONDS.sleep(1);
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }


    public static void main(String[] args) {
        TicketWindow ticketWindow = new TicketWindow("1号");
        new Thread(ticketWindow, "1").start();
        new Thread(ticketWindow, "2").start();
    }
}
