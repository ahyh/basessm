package thread.test.callabletest;

/**
 * synchronized锁重入功能
 * 父类和子类都是sychronized修饰的方法也是线程安全的
 */
public class SyncReentrant2 {

    static class Main {
        public int i = 10;
        public synchronized void operateMain() {
            try {
                i--;
                System.out.println("Main print i:" + i);
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static class Sub extends Main {
        public synchronized void operateSub() {
            try {
                while (i > 0) {
                    i--;
                    System.out.println("Sub print i:" + i);
                    Thread.sleep(100);
                    this.operateMain();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            Sub sub = new Sub();
            sub.operateSub();
        });
        t1.start();
    }
}
