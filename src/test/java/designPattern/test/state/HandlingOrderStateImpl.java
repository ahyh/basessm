package designPattern.test.state;

import com.google.common.base.Preconditions;

/**
 * 处理中订单处理逻辑
 */
public class HandlingOrderStateImpl implements OrderState{

    /**
     * 处理中订单处理逻辑
     */
    @Override
    public Result handle(Order order) {
        Preconditions.checkNotNull(order);
        System.out.println("处理中订单处理......");
        order.setStatus(OrderStateEnum.FINISHED.getKey());
        return new Result(1, "success", order);
    }
}
