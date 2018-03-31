package jdk.test.thread;

/**
 * 偶数生成器
 */
public class EvenGenerator extends IntGenerator {

    private int currentValue = 0;

    @Override
    public synchronized int next() {
        ++currentValue;
        Thread.yield();
        ++currentValue;
        return currentValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator());
    }
}
