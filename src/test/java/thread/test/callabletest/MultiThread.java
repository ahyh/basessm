package thread.test.callabletest;

/**
 * synchronized关键字
 */
public class MultiThread {

    private static int num = 0;

    /**
     * 如果不加static，一个对象一个锁
     * 加static后，那么这个方法的锁是类级别的锁
     * 不管new出来多少个对象及一个锁
     * 关键字synchronized取得的锁都是对象锁，而不是把一段代码当做锁
     * 如果不加static那么每次new一个对象出来就会有自己的锁，他们之间不会相互影响
     * 有一种情况则是相同的锁，即在静态方法上加synchronized关键字，
     * 表示锁定.class类，类级别的锁
     */
    public static synchronized void printNum(String str) {
        try {
            if ("a".equals(str)) {
                num = 100;
                System.out.println("tag a,set num over!");
                Thread.sleep(1000);
            } else {
                num = 200;
                System.out.println("tag b,set num over!");
            }
            System.out.println("tag" + str + ",num:" + num);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        final MultiThread multiThread1 = new MultiThread();
        final MultiThread multiThread2 = new MultiThread();
        Thread thread1 = new Thread(() -> {
            multiThread1.printNum("a");
        });
        Thread thread2 = new Thread(() -> {
            multiThread2.printNum("b");
        });
        thread1.start();
        thread2.start();
    }
}
