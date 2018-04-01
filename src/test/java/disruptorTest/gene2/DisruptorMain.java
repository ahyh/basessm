package disruptorTest.gene2;

import com.lmax.disruptor.BusySpinWaitStrategy;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.EventHandlerGroup;
import com.lmax.disruptor.dsl.ProducerType;
import disruptorTest.gene1.Trade;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * disruptor测试
 */
public class DisruptorMain {

    public static void main(String[] args) throws Exception {
        long beginTime = System.currentTimeMillis();
        int BUFFER_SIZE = 1 << 10;
        int THREAD_NUM = 4;
        ExecutorService executorService = Executors.newFixedThreadPool(8);
        Disruptor<Trade> tradeDisruptor = new Disruptor<>(() -> {
            return new Trade();
        }, BUFFER_SIZE, executorService, ProducerType.SINGLE, new BusySpinWaitStrategy());

        //使用disruptor创建消费者组handler1,handler2
        EventHandlerGroup<Trade> tradeEventHandlerGroup = tradeDisruptor.handleEventsWith(new TradeHandler1(), new TradeHandler2());

        //声明在handler1，handler2之后执行handler3
        tradeEventHandlerGroup.then(new TradeHandler3());

        tradeDisruptor.start();

        CountDownLatch latch = new CountDownLatch(1);

        //生产者准备
        executorService.submit(new TradeProducer(latch, tradeDisruptor));

        latch.await();    //等待生产者生产完毕

        tradeDisruptor.shutdown();

        executorService.shutdown();

        System.out.println("总耗时：" + (System.currentTimeMillis() - beginTime));
    }
}
