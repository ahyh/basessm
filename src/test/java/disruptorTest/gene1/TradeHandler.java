package disruptorTest.gene1;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;

import java.util.UUID;

/**
 * 订单处理类
 */
public class TradeHandler implements EventHandler<Trade>, WorkHandler<Trade> {

    @Override
    public void onEvent(Trade trade, long l, boolean b) throws Exception {
        this.onEvent(trade);
    }

    //具体的消费处理逻辑
    @Override
    public void onEvent(Trade trade) throws Exception {
        trade.setName(UUID.randomUUID().toString());
        System.out.println(trade.getName());
    }
}
