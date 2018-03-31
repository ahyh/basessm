package disruptorTest.helloWorld;

import com.lmax.disruptor.RingBuffer;

import java.nio.ByteBuffer;

/**
 * Created by yanhuan1 on 2018/3/28.
 */
public class LongEventProducer {

    private final RingBuffer<LongEvent> ringBuffer;

    public LongEventProducer(RingBuffer<LongEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    public void onData(ByteBuffer bb) {
        //1-可以帮ringBuffer看做一个事件队列，那么next就是得到下面的一个事件槽
        long sequence = ringBuffer.next();
        try {
            //2-用上面的索引取出一个空的事件用于填充（获得该序列对应的事件对象）
            LongEvent longEvent = ringBuffer.get(sequence);
            //3-获取要通过disruptor传递的数据
            longEvent.setValue(bb.getLong(0));
        } finally {
            //4-发布事件
            ringBuffer.publish(sequence);
        }
    }
}
