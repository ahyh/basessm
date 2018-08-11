package thread.test.wangwenjun.eventbus;

import java.lang.reflect.Method;

public interface EventContext {

    /**
     * 获取消息源
     * @return
     */
    String getSource();

    /**
     * 获取消息体
     * @return
     */
    Object getSubscriber();

    Method getSubscribe();

    Object getEvent();
}
