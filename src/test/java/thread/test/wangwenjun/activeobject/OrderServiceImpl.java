package thread.test.wangwenjun.activeobject;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class OrderServiceImpl implements OrderService {

    private static final ExecutorService executorService = Executors.newCachedThreadPool();

    @Override
    public Future<String> findOrderDetails(Long orderId) {
        return executorService.submit(() -> "OrderServiceImpl orderId:" + orderId);
    }

    @Override
    public void order(String account, Long orderId) {
        try {
            TimeUnit.SECONDS.sleep(2);
            System.out.println("The account:" + account + " ,orderId" + orderId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
