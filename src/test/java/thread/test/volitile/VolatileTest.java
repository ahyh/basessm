package thread.test.volitile;

/**
 * volatile关键字：使变量在多个线程间可见
 * 在java中，每一个线程都会有一块工作内存区，其中存放着所有线程共享的
 * 主内存中的变量值的拷贝。当线程执行时，他在自己的工作内存区中操作这些
 * 变量，为了存取一个共享的变量，一个线程通常先获取锁定并去清除他的内存
 * 工作区，把这些共享变量从所有线程的共享内存区中正确的装入到他自己所在
 * 的工作内存区中，当线程解锁时保证该工作内存中变量的值写回到共享内存中。
 * 一个线程可以执行的操作有使用use,赋值assign,装载load，存储store
 * 锁定lock，解锁unlock
 * 而主内存中可以执行的操作有读read，写write，锁定lock，解锁unlock，
 * 每个操作都是原子的
 *
 * volatile关键字的作用就是强制线程到主内存（共享内存）里去读取变量，而
 * 不去线程工作内存区里读取，从而实现了多个线程间的变量可见，也就是满足了
 * 线程安全的可见性
 * volatile关键字修饰的变量只是具有多个线程之间的可见性，不具有原子性
 *
 */
public class VolatileTest extends Thread{

    /**
     * 被volatile关键字修饰的变量，当变量改变时会强制线程执行引擎去主内存中取
     * 读取，即强制使用这个变量的线程到主内存中读取变量，在重新把更新后的值拷贝
     * 一份到线程工作内存中
     */
    private volatile boolean isRunning = true;

    private void setRunning(boolean isRunning){
        this.isRunning = isRunning;
    }

    public void run(){
        System.out.println("进入了run方法");
        while(isRunning){
            //
        }
        System.out.println("线程停止！");
    }

    public static void main(String[] args) throws Exception{
        VolatileTest vt = new VolatileTest();
        vt.start();
        Thread.sleep(3000);
        vt.setRunning(false);
        System.out.println("isRunning的值已经被设置了false");
        Thread.sleep(1000);
        System.out.println(vt.isRunning);
    }

}
