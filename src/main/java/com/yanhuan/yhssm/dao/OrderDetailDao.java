package com.yanhuan.yhssm.dao;

import com.yanhuan.yhssm.domain.condition.OrderDetailCondition;
import com.yanhuan.yhssm.domain.condition.OrderMainCondition;
import com.yanhuan.yhssm.domain.pojo.OrderDetail;
import com.yanhuan.yhssm.domain.pojo.OrderMain;
import com.yanhuan.yhssm.domain.pojo.Salary;
import org.apache.ibatis.annotations.Param;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * Dao:salary表
 * Created by yanhuan1 on 2018/1/16.
 */
public interface OrderDetailDao {

    Integer insert(OrderDetail orderMain);

    Integer update(OrderDetail orderMain);

    Integer delete(Long id);

    OrderDetail getOrderDetailByCondition(OrderDetailCondition condition);

    List<OrderDetail> findOrderDetailList(OrderDetailCondition condition);

    List<OrderDetail> findOrderDetailPage(OrderDetailCondition condition);

    /**
     * 批量插入方法
     */
    Integer batchInsert(@Param("list") List<OrderDetail> orderDetailList);

    /**
     * 批量删除方法
     */
    Integer batchDelete(@Param("list") List<Long> idList);

    /**
     * 批量插入或更新方法（不存在就插入，否则更新）
     */
    Integer batchInsertOrUpdate(@Param("list") List<OrderDetail> orderDetailList);

    /**
     * 物理删除
     */
    Integer deletePhysics(@Param("id") Long id);

    Integer batchDelByOrderNo(@Param("orderNo") String orderNo);
}
