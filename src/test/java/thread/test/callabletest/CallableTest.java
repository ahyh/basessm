package thread.test.callabletest;

import com.yanhuan.yhssm.domain.condition.OrderMainCondition;
import com.yanhuan.yhssm.domain.pojo.OrderMain;
import com.yanhuan.yhssm.service.OrderMainService;
import com.yanhuan.yhssm.test.BaseTest;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by yanhuan1 on 2018/2/8.
 */
public class CallableTest extends BaseTest {

    @Resource
    private OrderMainService orderMainService;

    private final ExecutorService executorService = Executors.newCachedThreadPool();

    @Test
    public void testCallable() throws ExecutionException, InterruptedException {
        Callable<OrderMain> orderMainCallable = () -> {
            System.out.println("Enter callable");
            List<OrderMain> orderMainList = orderMainService.findOrderMainList(new OrderMainCondition());
            for (OrderMain orderMain : orderMainList) {
                orderMain.setPayStatus((byte) 2);
                Thread.sleep(1000);
                orderMainService.update(orderMain);
            }
            System.out.println("Execute callable");
            return orderMainList.get(orderMainList.size() - 1);
        };
        Future<OrderMain> submit = executorService.submit(orderMainCallable);
        System.out.println("after submit");
        OrderMain orderMain = submit.get();
        System.out.println(orderMain.getPayStatus());
    }

}
