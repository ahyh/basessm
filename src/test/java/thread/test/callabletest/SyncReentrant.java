package thread.test.callabletest;

/**
 * Synchronized也有锁重入的功能
 * 锁重入功能：在使用synchronized关键字时，当一个线程得到一个对象的锁后
 * 再次请求该对象时还是可以得到这个对象的锁的
 */
public class SyncReentrant {

    public synchronized void method1(){
        System.out.println("method1");
        method2();
    }

    public synchronized void method2(){
        System.out.println("method2");
        method3();
    }

    public synchronized void method3(){
        System.out.println("method3");
    }

    /**
     * 这种方式就是简单的锁重入功能
     */
    public static void main(String[] args){
        final SyncReentrant sr = new SyncReentrant();
        Thread t1 = new Thread(()->sr.method1());
        t1.start();
    }
}
