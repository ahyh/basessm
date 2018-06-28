package disruptorTest.gene1;

import com.lmax.disruptor.*;

import java.math.BigDecimal;
import java.util.concurrent.*;

/**
 * WorkerPool方式
 */
public class TradeMain2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int BUFFER_SIZE = 1 << 10;
        int THREAD_NUM = 4;

        RingBuffer<Trade> ringBuffer = RingBuffer.createSingleProducer(() -> new Trade(), BUFFER_SIZE, new YieldingWaitStrategy());

        //创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_NUM);

        //创建SequenceBarrier，序号障碍
        SequenceBarrier sequenceBarrier = ringBuffer.newBarrier();

        //工作池方式
        WorkerPool<Trade> workerPool = new WorkerPool<>(ringBuffer, sequenceBarrier, new IgnoreExceptionHandler(), new TradeHandler());

        workerPool.start(executorService);
        long seq;
        for (int i = 0; i < 10; i++) {
            //1-占个坑，ringBuffer的一个可用区块
            seq = ringBuffer.next();
            //2-给这个区块放入数据
            ringBuffer.get(seq).setPrice(new BigDecimal(Math.random() * 9999));
            //3-发布这个区块的数据是handler可见
            ringBuffer.publish(seq);
        }

        TimeUnit.SECONDS.sleep(2);
        workerPool.halt(); //通知时间处理器可以结束了
        executorService.shutdown();
    }
}
