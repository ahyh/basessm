package disruptorTest.gene1;

import com.lmax.disruptor.*;

import java.math.BigDecimal;
import java.util.concurrent.*;

/**
 * Created by yanhuan1 on 2018/3/29.
 */
public class TradeMain1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int BUFFER_SIZE = 1 << 10;
        int THREAD_NUM = 4;

        RingBuffer<Trade> ringBuffer = RingBuffer.createSingleProducer(() -> new Trade(), BUFFER_SIZE, new YieldingWaitStrategy());

        //创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_NUM);

        //创建SequenceBarrier，序号障碍
        SequenceBarrier sequenceBarrier = ringBuffer.newBarrier();

        //创建消息处理器
        BatchEventProcessor<Trade> tradeProcessor = new BatchEventProcessor<>(ringBuffer, sequenceBarrier, new TradeHandler());

        //把消费者的位置信息引用注入到生产者中，如果只有一个消费者的情况可以省略
        ringBuffer.addGatingSequences(tradeProcessor.getSequence());

        //把消息处理器提交到线程池
        executorService.submit(tradeProcessor);

        Future<Void> future = executorService.submit(() -> {
            long seq;
            for (int i = 0; i < 10; i++) {
                //1-占个坑，ringBuffer的一个可用区块
                seq = ringBuffer.next();
                //2-给这个区块放入数据
                ringBuffer.get(seq).setPrice(new BigDecimal(Math.random() * 9999));
                //3-发布这个区块的数据是handler可见
                ringBuffer.publish(seq);
            }
            return null;
        });

        future.get();//等待生产者结束
        TimeUnit.SECONDS.sleep(2);
        tradeProcessor.halt(); //通知时间处理器可以结束了
        executorService.shutdown();
    }


}
