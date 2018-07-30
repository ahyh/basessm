package thread.test.wangwenjun.base;

import java.util.stream.IntStream;

public class ThreadYield extends Thread {

    public static void main(String[] args) {
        IntStream.range(0, 10).mapToObj(ThreadYield::create).forEach(Thread::start);
    }

    public static Thread create(int index) {
        return new Thread(() -> {
            if(index == 0){
                Thread.yield();
            }
            System.out.println(index);
        });
    }
}
