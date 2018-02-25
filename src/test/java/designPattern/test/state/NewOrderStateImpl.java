package designPattern.test.state;

import com.google.common.base.Preconditions;

/**
 * 新建订单状态的行为
 */
public class NewOrderStateImpl implements OrderState {

    /**
     * 新建订单的处理逻辑
     */
    @Override
    public Result handle(Order order) {
        Preconditions.checkNotNull(order);
        System.out.println("新建订单处理......");
        order.setStatus(OrderStateEnum.HANDLING.getKey());
        return new Result(1, "success", order);
    }
}
