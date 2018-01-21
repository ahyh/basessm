package com.yanhuan.yhssm.manager;

import com.yanhuan.yhssm.domain.pojo.OrderMain;

/**
 * 所有事务方法写在这里
 * Created by yanhuan1 on 2018/1/20.
 */
public interface OrderMainManager {

    /**
     * 插入订单主档和明细
     */
    Boolean insert(OrderMain orderMain);

    /**
     * 删除订单主档及明细（逻辑删除）
     */
    Boolean delete(OrderMain orderMain);

}
