package thread.test.future;

import java.util.concurrent.TimeUnit;

public class FutureTest {

    public static void main(String[] args) throws Exception {
        FutureService<Void, Void> service = FutureService.newService();
        Future<?> future = service.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("I am finish done!");
        });
        future.get();


        FutureService<String, Integer> service1 = FutureService.newService();
        Future<Integer> future1 = service1.submit(input -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return input.length();
        }, "Hello", System.out::println);
        System.out.println(future1.get());
    }
}
