package thread.test.callabletest;

/**
 * synchronized锁
 */
public class ObjectLock {

    /**
     * this:以ObjectLock的实例对象为锁
     */
    public void method1() {
        synchronized (this) {
            System.out.println("method1......");
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 类级别的锁
     */
    public void method2() {
        synchronized (ObjectLock.class) {
            System.out.println("method2......");
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 新建一个锁对象
     */
    private Object lock = new Object();
    public void method3(){
        synchronized (lock){
            try{
                System.out.println("method3......");
                Thread.sleep(1000);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        ObjectLock objectLock = new ObjectLock();
        Thread thread1 = new Thread(()->objectLock.method1(),"t1");
        Thread thread2 = new Thread(()->objectLock.method2(),"t2");
        Thread thread3 = new Thread(()->objectLock.method3(),"t3");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
