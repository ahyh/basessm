package disruptorTest.helloWorld;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by yanhuan1 on 2018/3/28.
 */
public class LongEventMain {

    public static void main(String[] args) throws Exception {
        //创建线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        //创建工厂
        LongEventFactory longEventFactory = new LongEventFactory();
        //ringBuffer大小，要求是2的n次方
        int ringBufferSize = 1024 * 1024;

        //第一个参数：工厂类对象，创建对象
        //第二个参数：ringBuffer缓冲区大小
        //第3个参数：线程池
        //第4个参数：ProducerType,single单个生产者，multi多个生产者
        //第5个参数：策略
        Disruptor<LongEvent> longEventDisruptor =
                new Disruptor<>(longEventFactory, ringBufferSize, executorService, ProducerType.SINGLE, new YieldingWaitStrategy());

        longEventDisruptor.handleEventsWith(new LongEventHandler());

        longEventDisruptor.start();

        RingBuffer<LongEvent> ringBuffer = longEventDisruptor.getRingBuffer();

        LongEventProducer longEventProducer = new LongEventProducer(ringBuffer);

        ByteBuffer byteBuffer = ByteBuffer.allocate(8);

        for (long l = 0; l < 100; l++) {
            byteBuffer.putLong(0, l);
            longEventProducer.onData(byteBuffer);
        }

        longEventDisruptor.shutdown();  //关闭disruptor
        executorService.shutdown();     //关闭线程池


    }
}
