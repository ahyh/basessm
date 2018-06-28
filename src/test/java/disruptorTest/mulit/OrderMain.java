package disruptorTest.mulit;

import com.lmax.disruptor.*;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 主函数
 */
public class OrderMain {

    public static void main(String[] args) throws Exception {
        RingBuffer<Order> ringBuffer = RingBuffer.create(ProducerType.MULTI, () -> new Order(), 1 << 20, new YieldingWaitStrategy());
        SequenceBarrier sequenceBarrier = ringBuffer.newBarrier();
        OrderConsumer[] orderConsumers = new OrderConsumer[3];
        for (int i = 0; i < 3; i++) {
            orderConsumers[i] = new OrderConsumer("consumer" + i);
        }

        WorkerPool<Order> workerPool = new WorkerPool<Order>(ringBuffer, sequenceBarrier, new IntEventExceptionHandler(), orderConsumers);

        ringBuffer.addGatingSequences(workerPool.getWorkerSequences());

        workerPool.start(Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()));

        final CountDownLatch latch = new CountDownLatch(1);

        for (int i = 0; i < 100; i++) {
            final OrderProducer producer = new OrderProducer(ringBuffer);
            new Thread(
                    () -> {
                        try {
                            latch.await();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        for (int j = 0; j < 100; j++) {
                            producer.onData(UUID.randomUUID().toString());
                        }
                    }
            ).start();
        }
        System.out.println("---------------开始生产-------------------");
        TimeUnit.SECONDS.sleep(2);
        latch.countDown();
        TimeUnit.SECONDS.sleep(5);
        System.out.println("总数：" + orderConsumers[0].getCount());
    }

    static class IntEventExceptionHandler implements ExceptionHandler {

        @Override
        public void handleEventException(Throwable throwable, long l, Object o) {

        }

        @Override
        public void handleOnStartException(Throwable throwable) {

        }

        @Override
        public void handleOnShutdownException(Throwable throwable) {

        }
    }
}
