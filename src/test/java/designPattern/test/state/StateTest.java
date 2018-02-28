package designPattern.test.state;

import com.google.common.base.Preconditions;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 状态模式测试
 */
public class StateTest {

    /**
     * 模拟从数据库中查询出一个order，根据order的状态进行不同的处理
     */
    @Test
    public void testState() {
        Order order = new Order("BJ10021", "ppp", OrderStateEnum.HANDLING.getKey(), new BigDecimal(100), new Date());
        OrderState orderState = getOrderState(order);
        Result result = orderState.handle(order);
        Assert.assertTrue(result.getResultCode() == 1);
    }

    /**
     * 根据订单的状态获取对应的OrderState具体实现类
     */
    private OrderState getOrderState(Order order) {
        Preconditions.checkNotNull(order);
        switch (OrderStateEnum.getByCode(order.getStatus())) {
            case NEW:
                return new NewOrderStateImpl();
            case HANDLING:
                return new HandlingOrderStateImpl();
            case FINISHED:
                return new FinishedOrderStateImpl();
            case CANCEL:
                return new CancelOrderStateImpl();
            default:
                throw new RuntimeException("The state of order is wrong!");
        }
    }

}
