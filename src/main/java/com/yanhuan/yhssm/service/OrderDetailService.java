package com.yanhuan.yhssm.service;

import com.github.pagehelper.PageInfo;
import com.yanhuan.yhssm.domain.condition.OrderDetailCondition;
import com.yanhuan.yhssm.domain.pojo.OrderDetail;

import java.util.List;

/**
 * Created by yanhuan1 on 2018/1/16.
 */
public interface OrderDetailService {

    Integer insert(OrderDetail orderDetail);

    Integer update(OrderDetail orderDetail);

    Integer delete(Long id);

    OrderDetail getOrderDetailByCondition(OrderDetailCondition condition);

    List<OrderDetail> findOrderDetailList(OrderDetailCondition condition);

    PageInfo<OrderDetail> selectOrderDetailPage(OrderDetailCondition condition);

    /**
     * 批量插入方法
     */
    Integer batchInsert(List<OrderDetail> orderDetailList);

    /**
     * 批量删除方法
     */
    Integer batchDelete(List<Long> idList);

    /**
     * 批量插入或更新方法（不存在就插入，否则更新）
     */
    Integer batchInsertOrUpdate(List<OrderDetail> orderDetailList);

    /**
     * 物理删除
     */
    Integer deletePhysics(Long id);

}
