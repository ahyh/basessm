package thread.test.observer;

import java.util.concurrent.TimeUnit;

public class ObservableThreadTest {

    public static void main(String[] args) {
        new ObservableThread<>(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("DONE");
            return null;
        }).start();
    }
}
