package designPattern.test.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 经纪人类：代理歌手做除了唱歌以外的所有事
 * InvocationHandler是JDK中reflect包下的接口
 * JDK自动的代理工具
 */
public class Agent implements InvocationHandler {

    private Singer singer;

    public Agent(Singer singer) {
        super();
        this.singer = singer;
    }

    /**
     * 通过反射的方式执行方法
     * 如果是single则调用Singer.sing方法
     * 代理类执行
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if ("sing".equals(method.getName())) {
            method.invoke(singer, args);
        } else {
            System.out.println("经纪人完成!");
        }
        return null;
    }

}
