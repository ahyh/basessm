package designPattern.test.state;

import com.google.common.base.Preconditions;

/**
 * 取消订单状态的行为
 */
public class CancelOrderStateImpl implements OrderState {

    /**
     * 取消订单的处理逻辑
     */
    @Override
    public Result handle(Order order) {
        Preconditions.checkNotNull(order);
        System.out.println("取消订单处理......");
        return new Result(1, "success", order);
    }
}
