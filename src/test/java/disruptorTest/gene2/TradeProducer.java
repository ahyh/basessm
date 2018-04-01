package disruptorTest.gene2;

import com.lmax.disruptor.EventTranslator;
import com.lmax.disruptor.dsl.Disruptor;
import disruptorTest.gene1.Trade;

import java.math.BigDecimal;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * Trade生产者
 */
public class TradeProducer implements Runnable {

    private Disruptor<Trade> disruptor;
    private CountDownLatch latch;

    private static int LOOP = 8;

    public TradeProducer(CountDownLatch latch, Disruptor<Trade> disruptor) {
        this.latch = latch;
        this.disruptor = disruptor;
    }

    @Override
    public void run() {
        TradeEventTranslator tradeEventTranslator = new TradeEventTranslator();
        for (int i = 0; i < LOOP; i++) {
            disruptor.publishEvent(tradeEventTranslator);
        }
        latch.countDown();
    }
}

/**
 * 转换数据
 */
class TradeEventTranslator implements EventTranslator<Trade> {

    private Random random = new Random();

    @Override
    public void translateTo(Trade trade, long l) {
        this.generateTrade(trade);
    }

    private Trade generateTrade(Trade trade) {
        trade.setPrice(new BigDecimal(random.nextDouble() * 9999));
        return trade;
    }
}
