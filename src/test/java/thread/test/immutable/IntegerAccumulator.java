package thread.test.immutable;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public final class IntegerAccumulator {

    private final int init;

    public IntegerAccumulator(int init) {
        this.init = init;
    }

    /**
     * 构造新的累加器
     *
     * @param integerAccumulator 累加器
     * @param init               初始值
     */
    public IntegerAccumulator(IntegerAccumulator integerAccumulator, int init) {
        this.init = integerAccumulator.getValue() + init;
    }

    /**
     * 每次相加都会产生一个新的累加器
     *
     * @param i
     * @return
     */
    public IntegerAccumulator add(int i) {
        return new IntegerAccumulator(this, i);
    }

    public int getValue() {
        return this.init;
    }

    public static void main(String[] args) {
        IntegerAccumulator integerAccumulator = new IntegerAccumulator(0);
        IntStream.range(0, 3).forEach(i -> new Thread(() -> {
            int inc = 0;
            while (true) {
                int oldValue = integerAccumulator.getValue();
                int result = integerAccumulator.add(inc).getValue();
                System.out.println(oldValue + " + " + inc + " = " + result);
                if (inc + oldValue != result) {
                    System.err.println("ERROR:" + oldValue + "+" + inc + "=" + result);
                }
                inc++;
                slowly();
            }
        }, "Thread" + i).start());
    }

    private static void slowly() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
