package thread.test.callabletest;

/**
 * 同步和异步
 */
public class MyObject {

    /**
     * 加synchronized是同步方法
     */
    public synchronized void method1() {
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 异步方法，如果加synchronized就和method1一样是同步方法,
     * 必须等到method1执行完后释放锁才能执行
     */
    public synchronized void method2() {
        System.out.println(Thread.currentThread().getName());
    }

    /**
     * t1线程先持有myObject对象的锁，t2线程可以以异步的方式调用对象中的非synchronized修饰的方法
     * t1线程先持有myObject对象的锁，t2线程如果在这个时候调用对象中的同步（synchronized）方法则需要等待，也就是同步
     * @param args
     */
    public static void main(String[] args) {
        final MyObject myObject = new MyObject();
        Thread thread1 = new Thread(() -> myObject.method1());
        Thread thread2 = new Thread(() -> myObject.method2());
        thread1.setName("t1");
        thread2.setName("t2");
        thread1.start();
        thread2.start();
    }
}
