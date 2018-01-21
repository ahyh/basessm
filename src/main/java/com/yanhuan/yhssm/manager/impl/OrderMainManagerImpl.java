package com.yanhuan.yhssm.manager.impl;

import com.google.common.base.Preconditions;
import com.yanhuan.yhssm.dao.OrderDetailDao;
import com.yanhuan.yhssm.dao.OrderMainDao;
import com.yanhuan.yhssm.domain.pojo.OrderMain;
import com.yanhuan.yhssm.manager.OrderMainManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by yanhuan1 on 2018/1/20.
 */
@Component
public class OrderMainManagerImpl implements OrderMainManager {

    @Resource
    private OrderMainDao orderMainDao;

    @Resource
    private OrderDetailDao orderDetailDao;

    @Override
    @Transactional
    public Boolean insert(OrderMain orderMain) {
        Preconditions.checkArgument(orderMain != null, "OrderMainManagerImpl insert orderMain cannot null!");
        Integer mainInsertNum = orderMainDao.insert(orderMain);
        Preconditions.checkArgument(mainInsertNum == 1, "OrderMainManagerImpl insert orderMain false!");
        Integer detailInsertNum = orderDetailDao.batchInsert(orderMain.getOrderDetailList());
        Preconditions.checkArgument(detailInsertNum == orderMain.getOrderDetailList().size(), "OrderMainManagerImpl insert orderDetailList false!");
        return true;
    }

    @Override
    @Transactional
    public Boolean delete(OrderMain orderMain) {
        Integer mainDelNum = orderMainDao.delete(orderMain.getId());
        Preconditions.checkArgument(mainDelNum == 1, "OrderManagerImpl delete main false!");
        Integer detailDelNum = orderDetailDao.batchDelByOrderNo(orderMain.getOrderNo());
        Preconditions.checkArgument(detailDelNum == orderMain.getSkuCount(), "OrderMainManagerImpl delete details fasle");
        return true;
    }


}
