package thread.test.wangwenjun.eventbus;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Registry {

    private final ConcurrentHashMap<String, ConcurrentLinkedQueue<Subscriber>> subscriberContainer = new ConcurrentHashMap<>();

    //获取Subscriber Object的方法集合然后进行绑定
    public void bind(Object subscriber) {
        List<Method> subscribeMethodList = getSubscribeMethodList(subscriber);
        subscribeMethodList.forEach(m -> tierSubscriber(subscriber, m));
    }

    //unbind为了提高速度，只对Subscriber进行失效操作
    public void unbind(Object subscriber) {
        subscriberContainer.forEach((key, queue) -> queue.forEach(s -> {
            if (s.getSubcribeObject() == subscriber) {
                s.setDisable(true);
            }
        }));
    }

    public ConcurrentLinkedQueue<Subscriber> scanSubscriber(final String topic) {
        return this.subscriberContainer.get(topic);
    }

    private void tierSubscriber(Object subscriber, Method method) {
        final Subscribe subscribe = method.getDeclaredAnnotation(Subscribe.class);
        String topic = subscribe.topic();
        subscriberContainer.computeIfAbsent(topic, key -> new ConcurrentLinkedQueue<>());
        subscriberContainer.get(topic).add(new Subscriber(subscriber, method));
    }

    private List<Method> getSubscribeMethodList(Object subscriber) {
        final List<Method> methods = new ArrayList<>();
        Class<?> aClass = subscriber.getClass();
        //不断获取当前类和父类的所有加@Subscribe注解的方法
        while (aClass != null) {
            Method[] declaredMethods = aClass.getDeclaredMethods();
            //过滤出public方法 && 只有一个入参 && @Subscribe注解标记的方法
            Arrays.stream(declaredMethods)
                    .filter(m -> m.isAnnotationPresent(Subscribe.class) && m.getParameterCount() == 1 && m.getModifiers() == Modifier.PUBLIC)
                    .forEach(methods::add);
            aClass = aClass.getSuperclass();
        }
        return methods;
    }


}
