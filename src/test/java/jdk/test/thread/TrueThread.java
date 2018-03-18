package jdk.test.thread;

import org.junit.Test;

/**
 * 通过start方法启动一个线程
 */
public class TrueThread {

    @Test
    public void testTrueThread() {
        Thread thread = new Thread(new LiftOff());
        thread.start();
    }

    @Test
    public void testMulti() {
        for (int i = 0; i < 5; i++) {
             new Thread(new LiftOff()).start();
        }
        System.out.println("Waiting For LiftOff");
    }
}
