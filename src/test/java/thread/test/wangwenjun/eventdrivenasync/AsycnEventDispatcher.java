package thread.test.wangwenjun.eventdrivenasync;

import thread.test.wangwenjun.eventdriven.Channel;
import thread.test.wangwenjun.eventdriven.DynamicRouter;
import thread.test.wangwenjun.eventdriven.MessageEvent;
import thread.test.wangwenjun.eventdriven.MessageMatcherException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 异步的分发器
 *
 * @author yanhuan1
 */
public class AsycnEventDispatcher implements DynamicRouter<MessageEvent> {

    private final Map<Class<? extends MessageEvent>, AsyncChannel> routerTable;

    public AsycnEventDispatcher() {
        this.routerTable = new ConcurrentHashMap<>();
    }

    @Override
    public void registerChannel(Class<? extends MessageEvent> messageType, Channel<? extends MessageEvent> channel) {
        if (!(channel instanceof AsyncChannel)) {
            throw new IllegalArgumentException("The Channel must be AsyncChannel！");
        }
        this.routerTable.put(messageType, (AsyncChannel) channel);
    }

    @Override
    public void dispatch(MessageEvent message) {
        if (routerTable.containsKey(message.getClass())) {
            routerTable.get(message.getClass()).dispatch(message);
        } else {
            throw new MessageMatcherException("Message cannot match the channel!");
        }
    }

    /**
     * 关闭所有的channel以释放资源
     */
    public void shutdown() {
        routerTable.values().forEach(AsyncChannel::stop);
    }
}
