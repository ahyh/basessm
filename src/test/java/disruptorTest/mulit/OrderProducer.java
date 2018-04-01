package disruptorTest.mulit;

import com.lmax.disruptor.RingBuffer;

/**
 * 生产者
 */
public class OrderProducer {

    private final RingBuffer<Order> ringBuffer;

    public OrderProducer(RingBuffer<Order> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    /**
     * onData用来发布事件，每调用一次就发布一次事件
     *
     * @param data
     */
    public void onData(String data) {
        //可以把ringBuffer看做一个事件队列，next就是得到下一个事件槽
        long sequence = ringBuffer.next();

        try {
            //用上面的索引取出一个空的事件用于填充
            Order order = ringBuffer.get(sequence);
            //获取要通过事件传输的数据
            order.setId(data);

        } finally {
            /**
             * 发布事件，注意最后的publish方法必须在finally中以确保必须得到调用
             *如果某个请求的sequence未被提交，将会报错
             */
            ringBuffer.publish(sequence);
        }

    }
}
