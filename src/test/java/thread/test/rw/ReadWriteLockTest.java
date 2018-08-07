package thread.test.rw;

public class ReadWriteLockTest {

    private static final String data = "This is a ReadWriteLockTest";

    public static void main(String[] args) {
        final ShareData shareData = new ShareData(50);
        for (int i = 0; i <= 1; i++) {
            new Thread(() -> {
                for (int j = 0; j < data.length(); j++) {
                    try {
                        char c = data.charAt(j);
                        shareData.write(c);
                        System.out.println(Thread.currentThread() + " write " + c);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, "Write" + i).start();
        }

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (true) {
                    try {
                        System.out.println(Thread.currentThread() + " read " + new String(shareData.read()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, "Reader" + i).start();
        }
    }
}
