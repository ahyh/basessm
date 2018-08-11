package thread.test.wangwenjun.activeobject;


import java.util.concurrent.Future;

public interface OrderService {

    /**
     * 根据订单编号查询订单明细
     *
     * @param orderId 订单编号
     * @return Future
     */
    Future<String> findOrderDetails(Long orderId);

    /**
     * 提交订单没有返回值
     *
     * @param account 账户
     * @param orderId 订单编号
     */
    void order(String account, Long orderId);
}
