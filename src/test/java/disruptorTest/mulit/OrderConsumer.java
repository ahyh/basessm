package disruptorTest.mulit;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 消费者
 */
public class OrderConsumer implements WorkHandler<Order> {

    private String name;

    private static AtomicInteger count = new AtomicInteger(0);

    public OrderConsumer() {
    }

    public OrderConsumer(String name) {
        this.name = name;
    }

    @Override
    public void onEvent(Order order) throws Exception {
        System.out.println("OrderConsumer:" + this.name + ",消费消息：" + order.getId());
        count.incrementAndGet();
    }

    public int getCount() {
        return count.get();
    }
}
