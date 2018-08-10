package thread.test.wangwenjun.workerthread;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * worker线程，用于实际生产产品
 *
 * @author yanhuan1
 */
public class Worker implements Runnable {

    private final String name;

    private final ProductionChannel productionChannel;

    private final static Random random = new Random(System.currentTimeMillis());

    public Worker(String name, ProductionChannel productionChannel) {
        this.name = name;
        this.productionChannel = productionChannel;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Production production = productionChannel.takeProduction();
                System.out.println(name + " process the " + production);
                production.create();
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
