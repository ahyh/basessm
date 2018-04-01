package disruptorTest.gene2;

import com.lmax.disruptor.BusySpinWaitStrategy;
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
public class DisruptorMain2 {

    public static void main(String[] args) throws Exception {
        long beginTime = System.currentTimeMillis();
        int BUFFER_SIZE = 1 << 10;
        int THREAD_NUM = 4;
        ExecutorService executorService = Executors.newFixedThreadPool(8);
        Disruptor<Trade> tradeDisruptor = new Disruptor<>(() -> {
            return new Trade();
        }, BUFFER_SIZE, executorService, ProducerType.SINGLE, new BusySpinWaitStrategy());

        //使用disruptor创建消费者组handler1,handler2
        TradeHandler1 tradeHandler1 = new TradeHandler1();
        TradeHandler2 tradeHandler2 = new TradeHandler2();
        TradeHandler3 tradeHandler3 = new TradeHandler3();
        TradeHandler4 tradeHandler4 = new TradeHandler4();
        TradeHandler5 tradeHandler5 = new TradeHandler5();

        /**
         *           handler1-->handler4
         * Producer                        handler3
         *           handler2-->handler5
         */
        tradeDisruptor.handleEventsWith(tradeHandler1, tradeHandler2);
        tradeDisruptor.after(tradeHandler1).handleEventsWith(tradeHandler4);
        tradeDisruptor.after(tradeHandler2).handleEventsWith(tradeHandler5);
        tradeDisruptor.after(tradeHandler4, tradeHandler5).handleEventsWith(tradeHandler3);

//        /**
//         * handler1-->handler2-->handler3顺序执行
//         */
//        tradeDisruptor.handleEventsWith(tradeHandler1).
//                handleEventsWith(tradeHandler2).handleEventsWith(tradeHandler3);

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
