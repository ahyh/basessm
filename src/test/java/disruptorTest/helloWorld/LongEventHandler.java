package disruptorTest.helloWorld;


import com.lmax.disruptor.EventHandler;

/**
 * 事件的消费者，消费处理逻辑
 */
public class LongEventHandler implements EventHandler<LongEvent> {

    @Override
    public void onEvent(LongEvent event, long sequence, boolean endOfBatch) throws Exception {
        System.out.println(event.getValue());
    }
}
