package thread.test.wangwenjun.eventdriven;

import java.util.HashMap;
import java.util.Map;

public class EventDispatcher implements DynamicRouter<Message> {

    private final Map<Class<? extends Message>, Channel> routerMap;

    public EventDispatcher() {
        routerMap = new HashMap<>();
    }

    @Override
    public void registerChannel(Class<? extends Message> messageType, Channel<? extends Message> channel) {
        this.routerMap.put(messageType, channel);
    }

    @Override
    public void dispatch(Message message) {
        if (routerMap.containsKey(message.getType())) {
            routerMap.get(message.getType()).dispatch(message);
        } else {
            throw new MessageMatcherException("Cannot matcher the channel for [" + message.getType() + "] type");
        }
    }
}
