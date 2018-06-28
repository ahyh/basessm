package jdk.test.thread.local;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * ThreadLocal测试
 */
public class ThreadLocalVarHolder implements Runnable {

    //假设这是个数据库连接池
    private static List<MyConnection> connectionList = new ArrayList<>();

    //假设一共有5个数据库连接
    static {
        connectionList = Lists.newArrayList(
                new MyConnection("Con1"),
                new MyConnection("Con2"),
                new MyConnection("Con3"),
                new MyConnection("Con4"),
                new MyConnection("Con5"),
                new MyConnection("Con6")
        );
    }

    /**
     * ThreadLocal:将线程中的某个值与保存这个值的对象关联起来
     */
    private static ThreadLocal<MyConnection> value = new ThreadLocal<MyConnection>() {
        public MyConnection initialValue() {
            //默认每次随机取一个连接
            if (connectionList.size() >= 1) {
                return connectionList.remove((int) ((connectionList.size() - 1) * Math.random()));
            } else {
                throw new RuntimeException("没有可用的连接了！");
            }
        }
    };

    /**
     * 获取连接的方法
     */
    public static MyConnection getConnection() {
        return value.get();
    }

    @Override
    public void run() {
        getConnection().executeSQL("select * from tableA;");
        getConnection().executeSQL("update tableA set qty = 1 where id = 100;");
        System.out.println("===================================");
        connectionList.add(getConnection());
    }
}
