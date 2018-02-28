package thread.test.waitAndNotify;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 使用wait/notify方法实现一个阻塞队列
 */
public class MyQueue {

    //1-盛放元素的容器
    private static LinkedList<Object> list = new LinkedList<>();

    //2-一个计数器
    private AtomicInteger count = new AtomicInteger(0);

    //3-容器最大容量和最小容量
    private static int min = 0;
    private static int max;

    //4-构造方法
    public MyQueue(int size) {
        this.max = size;
    }

    //5-准备一个锁lock
    private final Object lock = new Object();

    //6-put方法,向容器中添加元素的方法
    public void put(Object obj) {
        synchronized (lock) {
            //如果容器状态为满，则等待
            while (count.get() == max) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //添加元素
            list.add(obj);
            //更新count
            count.incrementAndGet();
            System.out.println("向容器中添加了元素......");
            //唤醒另外一个线程
            lock.notify();
        }
    }

    //7-take方法，从容器中取出元素的方法
    public Object take() {
        Object ret = null;
        synchronized (lock) {
            while (count.get() == min) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //从list中取出一个元素
            ret = list.removeFirst();
            //更新count值
            count.decrementAndGet();
            //唤醒线程
            lock.notify();
        }
        return ret;
    }

    public int getSize() {
        return count.get();
    }

    public static void main(String[] args) {
        final MyQueue myQueue = new MyQueue(5);
        myQueue.put("a");
        myQueue.put("b");
        myQueue.put("c");
        myQueue.put("d");
        myQueue.put("e");
        System.out.println("当前容器长度：" + myQueue.getSize());
        Thread t1 = new Thread(() -> {
            myQueue.put("f");
            myQueue.put("g");
            myQueue.put("h");
            myQueue.put("i");
            myQueue.put("j");
        }, "t1");

        Thread t2 = new Thread(() -> {
            Object take = myQueue.take();
            System.out.println("移除的元素：" + take);
            Object take1 = myQueue.take();
            System.out.println("移除的元素：" + take1);
            Object take2 = myQueue.take();
            System.out.println("移除的元素：" + take2);
        }, "t2");
        t1.start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        t2.start();
    }

}
