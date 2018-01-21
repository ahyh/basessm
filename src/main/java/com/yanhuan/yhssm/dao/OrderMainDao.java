package com.yanhuan.yhssm.dao;

import com.yanhuan.yhssm.domain.condition.OrderMainCondition;
import com.yanhuan.yhssm.domain.pojo.OrderMain;
import com.yanhuan.yhssm.domain.pojo.Salary;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Dao:salary表
 * Created by yanhuan1 on 2018/1/16.
 */
public interface OrderMainDao {

    Integer insert(OrderMain orderMain);

    Integer update(OrderMain orderMain);

    Integer delete(Long id);

    OrderMain get(Long id);

    OrderMain getOrderMainByCondition(OrderMainCondition condition);

    List<OrderMain> findOrderMainList(OrderMainCondition condition);

    List<OrderMain> findOrderMainPage(OrderMainCondition condition);

    /**
     * 批量插入方法
     */
    Integer batchInsert(@Param("list") List<OrderMain> orderMainList);

    /**
     * 批量删除方法
     */
    Integer batchDelete(@Param("list") List<Long> idList);

    /**
     * 批量插入或更新方法（不存在就插入，否则更新）
     */
    Integer batchInsertOrUpdate(@Param("list") List<OrderMain> orderMainList);

    /**
     * 物理删除
     */
    Integer deletePhysics(@Param("id") Long id);
}
