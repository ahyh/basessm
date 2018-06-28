package disruptorTest.gene2;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;
import disruptorTest.gene1.Trade;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * 消费者2
 */
public class TradeHandler2 implements EventHandler<Trade>, WorkHandler<Trade> {

    @Override
    public void onEvent(Trade trade, long l, boolean b) throws Exception {
        this.onEvent(trade);
    }

    @Override
    public void onEvent(Trade trade) throws Exception {
        System.out.println("handler2:setPrice");
        trade.setPrice(new BigDecimal(200.0));
        TimeUnit.SECONDS.sleep(1);
    }
}
