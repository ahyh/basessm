package designPattern.test.state;

/**
 * 订单状态接口
 */
public interface OrderState {
    /**
     * 订单处理方法，每一种订单状态都有对应的处理方法
     */
    Result handle(Order order);
}
