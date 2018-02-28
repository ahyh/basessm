package thread.test.callabletest;

/**
 * Synchronized异常
 */
public class SyncException {

    private int i = 0;

    public synchronized void operate() {
        while (true) {
            try {
                i++;
                Thread.sleep(500);
                System.out.println(Thread.currentThread().getName() + "i:" + i);
                if (i == 10) {
                    Integer.parseInt("a");
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        final SyncException se = new SyncException();
        Thread thread = new Thread(() -> se.operate(), "t1");
        thread.start();
    }
}
