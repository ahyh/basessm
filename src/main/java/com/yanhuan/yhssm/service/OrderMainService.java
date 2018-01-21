package com.yanhuan.yhssm.service;

import com.github.pagehelper.PageInfo;
import com.yanhuan.yhssm.domain.condition.OrderMainCondition;
import com.yanhuan.yhssm.domain.pojo.OrderMain;

import java.util.List;

/**
 * Created by yanhuan1 on 2018/1/16.
 */
public interface OrderMainService {

    Boolean insert(OrderMain orderMain);

    Integer update(OrderMain orderMain);

    Boolean delete(Long id);

    OrderMain get(Long id);

    OrderMain getOrderMainByCondition(OrderMainCondition condition);

    List<OrderMain> findOrderMainList(OrderMainCondition condition);

    PageInfo<OrderMain> selectOrderMainPage(OrderMainCondition condition);

    /**
     * 批量插入方法
     */
    Integer batchInsert(List<OrderMain> orderMainList);

    /**
     * 批量删除方法
     */
    Integer batchDelete(List<Long> idList);

    /**
     * 批量插入或更新方法（不存在就插入，否则更新）
     */
    Integer batchInsertOrUpdate(List<OrderMain> orderMainList);

    /**
     * 物理删除
     */
    Integer deletePhysics(Long id);

}
