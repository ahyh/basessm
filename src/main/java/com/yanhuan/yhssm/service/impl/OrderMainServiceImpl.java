package com.yanhuan.yhssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Preconditions;
import com.yanhuan.yhssm.dao.OrderMainDao;
import com.yanhuan.yhssm.domain.condition.OrderMainCondition;
import com.yanhuan.yhssm.domain.pojo.OrderMain;
import com.yanhuan.yhssm.manager.OrderMainManager;
import com.yanhuan.yhssm.service.OrderMainService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * SalaryService服务：基本的增删改查方法
 * Created by yanhuan1 on 2018/1/16.
 */
@Service
public class OrderMainServiceImpl implements OrderMainService {

    @Resource
    private OrderMainDao orderMainDao;

    @Resource
    private OrderMainManager orderMainManager;

    @Override
    public Boolean insert(OrderMain orderMain) {
        return orderMainManager.insert(orderMain);
    }

    @Override
    public Integer update(OrderMain orderMain) {
        Preconditions.checkNotNull(orderMain);
        return orderMainDao.update(orderMain);
    }

    @Override
    public Boolean delete(Long id) {
        Preconditions.checkArgument(id != null, "OrderMainService delete id cannot null!");
        OrderMain orderMain = orderMainDao.get(id);
        if(null != orderMain){
            return orderMainManager.delete(orderMain);
        }
        return false;
    }

    @Override
    public OrderMain get(Long id) {
        return orderMainDao.get(id);
    }

    @Override
    public OrderMain getOrderMainByCondition(OrderMainCondition condition) {
        Preconditions.checkArgument(condition != null, "condition cannot null!");
        return orderMainDao.getOrderMainByCondition(condition);
    }

    @Override
    public List<OrderMain> findOrderMainList(OrderMainCondition condition) {
        return orderMainDao.findOrderMainList(condition);
    }

    @Override
    public PageInfo<OrderMain> selectOrderMainPage(OrderMainCondition condition) {
        PageHelper.startPage(condition.getPageNum(), condition.getPageSize(), condition.getOrderBy());
        List<OrderMain> salaries = orderMainDao.findOrderMainPage(condition);
        PageInfo<OrderMain> pageInfo = new PageInfo<>(salaries);
        return pageInfo;
    }

    @Override
    public Integer batchInsert(List<OrderMain> orderMainList) {
        if (CollectionUtils.isNotEmpty(orderMainList)) {
            return orderMainDao.batchInsert(orderMainList);
        }
        return 0;
    }

    @Override
    public Integer batchDelete(List<Long> idList) {
        if (CollectionUtils.isNotEmpty(idList)) {
            return orderMainDao.batchDelete(idList);
        }
        return 0;
    }

    @Override
    public Integer batchInsertOrUpdate(List<OrderMain> orderMainList) {
        if (CollectionUtils.isNotEmpty(orderMainList)) {
            return orderMainDao.batchInsertOrUpdate(orderMainList);
        }
        return 0;
    }

    @Override
    public Integer deletePhysics(Long id) {
        return orderMainDao.deletePhysics(id);
    }

}
