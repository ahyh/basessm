package designPattern.test.state;

import com.google.common.base.Preconditions;

/**
 * 完成订单状态的行为
 */
public class FinishedOrderStateImpl implements OrderState {

    /**
     * 完成订单的处理逻辑
     */
    @Override
    public Result handle(Order order) {
        Preconditions.checkNotNull(order);
        System.out.println("完成订单处理......");
        return new Result(1, "success", order);
    }
}
