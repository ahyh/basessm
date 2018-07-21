package thread.test.wangwenjun.base;

public class TryConcurrent {

    public static void main(String[] args) {
        new Thread(TryConcurrent::listenMusic).start();
        new Thread(TryConcurrent::seeNews).start();
    }

    private static void seeNews() {
        try {
            for (; ; ) {
                System.out.println("seeNews...");
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void listenMusic() {
        try {
            for (; ; ) {
                System.out.println("listenMusic...");
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
