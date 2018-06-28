package jdk.test.thread;

/**
 * 产生随机数的抽象类
 */
public abstract class IntGenerator {

    //voliate关键字线程间可见
    private volatile boolean canceled = false;

    public abstract int next();

    public void cancel() {
        this.canceled = true;
    }

    public boolean isCanceled() {
        return canceled;
    }

    public void setCanceled(boolean canceled) {
        this.canceled = canceled;
    }
}

