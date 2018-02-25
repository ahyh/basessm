package com.yanhuan.yhssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Preconditions;
import com.yanhuan.yhssm.dao.OrderDetailDao;
import com.yanhuan.yhssm.domain.condition.OrderDetailCondition;
import com.yanhuan.yhssm.domain.pojo.OrderDetail;
import com.yanhuan.yhssm.service.OrderDetailService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * SalaryService服务：基本的增删改查方法
 * Created by yanhuan1 on 2018/1/16.
 */
@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Resource
    private OrderDetailDao orderDetailDao;

    @Override
    public Integer insert(OrderDetail orderDetail) {
        Preconditions.checkNotNull(orderDetail);
        return orderDetailDao.insert(orderDetail);
    }

    @Override
    public Integer update(OrderDetail orderDetail) {
        Preconditions.checkNotNull(orderDetail);
        return orderDetailDao.update(orderDetail);
    }

    @Override
    public Integer delete(Long id) {
        return orderDetailDao.delete(id);
    }

    @Override
    public OrderDetail getOrderDetailByCondition(OrderDetailCondition condition) {
        Preconditions.checkArgument(condition != null, "condition cannot null!");
        return orderDetailDao.getOrderDetailByCondition(condition);
    }

    @Override
    public List<OrderDetail> findOrderDetailList(OrderDetailCondition condition) {
        return orderDetailDao.findOrderDetailList(condition);
    }

    @Override
    public PageInfo<OrderDetail> selectOrderDetailPage(OrderDetailCondition condition) {
        PageHelper.startPage(condition.getPageNum(), condition.getPageSize(), condition.getOrderBy());
        List<OrderDetail> salaries = orderDetailDao.findOrderDetailPage(condition);
        PageInfo<OrderDetail> pageInfo = new PageInfo<>(salaries);
        return pageInfo;
    }

    @Override
    public Integer batchInsert(List<OrderDetail> orderDetailList) {
        if(CollectionUtils.isNotEmpty(orderDetailList)){
            return orderDetailDao.batchInsert(orderDetailList);
        }
        return 0;
    }

    @Override
    public Integer batchDelete(List<Long> idList) {
        if(CollectionUtils.isNotEmpty(idList)){
            return orderDetailDao.batchDelete(idList);
        }
        return 0;
    }

    @Override
    public Integer batchInsertOrUpdate(List<OrderDetail> orderDetailList) {
        if(CollectionUtils.isNotEmpty(orderDetailList)){
            return orderDetailDao.batchInsertOrUpdate(orderDetailList);
        }
        return 0;
    }

    @Override
    public Integer deletePhysics(Long id) {
        return orderDetailDao.deletePhysics(id);
    }


}
