package thread.test.wangwenjun.workerthread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class WorkerThreadTest {

    public static void main(String[] args) {
        final ProductionChannel productionChannel = new ProductionChannel(10);
        AtomicInteger productionNo = new AtomicInteger();
        IntStream.range(1, 10).forEach(x -> new Thread(() -> {
            while (true) {
                productionChannel.offerProduction(new Production(productionNo.getAndIncrement()));
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start());

    }
}
