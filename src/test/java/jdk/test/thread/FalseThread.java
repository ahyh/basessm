package jdk.test.thread;

import org.junit.Test;

/**
 * 直接使用run方法，不能启动多线程的作用
 * 实际还是main线程在顺序执行
 */
public class FalseThread {

    @Test
    public void test(){
        LiftOff liftOff = new LiftOff();
        liftOff.run();
    }
}
