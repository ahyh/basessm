package thread.test.wangwenjun.eventbus;

import java.lang.reflect.Method;

/**
 * 对象和方法的封装类
 *
 * @author yanhuan1
 */
public class Subscriber {

    private final Object subcribeObject;

    private final Method subscribeMethod;

    private boolean disable = false;

    public Subscriber(Object subcribeObject, Method subscribeMethod) {
        this.subcribeObject = subcribeObject;
        this.subscribeMethod = subscribeMethod;
    }

    public Object getSubcribeObject() {
        return subcribeObject;
    }

    public Method getSubscribeMethod() {
        return subscribeMethod;
    }

    public boolean isDisable() {
        return disable;
    }

    public void setDisable(boolean disable) {
        this.disable = disable;
    }
}
