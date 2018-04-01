package disruptorTest.gene2;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;
import disruptorTest.gene1.Trade;

import java.util.concurrent.TimeUnit;

/**
 * 消费者4
 */
public class TradeHandler4 implements EventHandler<Trade>, WorkHandler<Trade> {

    @Override
    public void onEvent(Trade trade, long l, boolean b) throws Exception {
        this.onEvent(trade);
    }

    @Override
    public void onEvent(Trade trade) throws Exception {
        System.out.println("handler4:getName" + trade.getName());
        trade.setName(trade.getName() + "handler4");
        TimeUnit.SECONDS.sleep(1);
    }
}
