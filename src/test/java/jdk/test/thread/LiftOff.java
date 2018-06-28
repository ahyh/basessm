package jdk.test.thread;

/**
 * 多线程相关测试
 */
public class LiftOff implements Runnable {

    private int countDown = 10;

    private static int taskCount = 0;

    private final int id = taskCount++;

    public LiftOff() {
    }

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return "#" + id + "(" + (countDown > 0 ? countDown : "LiftOff!") + "),";
    }

    @Override
    public void run() {
        while (countDown-- > 0) {
            System.out.print(status());
            /**
             * yield方法：java线程机制的一部分，可以将CPU从一个线程
             * 转移给另一个线程，只是一种建议，并不一定确保可以转移
             */
            Thread.yield();
        }
    }
}
