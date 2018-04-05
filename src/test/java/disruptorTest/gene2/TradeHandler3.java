package disruptorTest.gene2;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;
import disruptorTest.gene1.Trade;

/**
 * 消费者3
 */
public class TradeHandler3 implements EventHandler<Trade>, WorkHandler<Trade> {

    @Override
    public void onEvent(Trade trade, long l, boolean b) throws Exception {
        this.onEvent(trade);
    }

    @Override
    public void onEvent(Trade trade) throws Exception {
        System.out.println("handler3:name:" + trade.getName() + ",price:" + trade.getPrice() + ",trade:" + trade.toString());
    }
}
