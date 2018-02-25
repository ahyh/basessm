package thread.test.callabletest;

/**
 * 线程安全：当多个线程访问某一个类（对象或方法）时，这个类始终都能
 * 表现出正确的行为，那么这个类（对象或方法）就是线程安全的
 *
 * synchronized:可以在任意对象或方法上加锁，加锁的这段代码称为互斥区或临界区
 */
public class ThreadTest extends Thread {

    private int num = 5;

    //synchronized加锁
    public synchronized void run() {
        num--;
        System.out.println(Thread.currentThread().getName() + ":" + num);
    }

    public static void main(String[] args) {
        /**
         * 当多个线程访问ThreadTest的run方法时，以排队的方式进行处理
         * （这里的排队是按照CPU分配的先后顺序而定的），一个线程如果想要
         * 执行synchronized修饰的代码：
         * 1-尝试获得锁
         * 2-如果拿到锁，执行synchronized代码体中的内容，拿不到锁，这个线程
         *   就会不断的尝试获得这把锁，一直到拿到为止，而且是多个线程同时去
         *   竞争这把锁（这里就会有锁竞争问题）
         */
        ThreadTest threadTest = new ThreadTest();
        Thread thread1 = new Thread(threadTest, "t1");
        Thread thread2 = new Thread(threadTest, "t2");
        Thread thread3 = new Thread(threadTest, "t3");
        Thread thread4 = new Thread(threadTest, "t4");
        Thread thread5 = new Thread(threadTest, "t5");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
}
