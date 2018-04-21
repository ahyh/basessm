package com.yanhuan.yhssm.manager.impl;

import com.google.common.base.Preconditions;
import com.yanhuan.yhssm.dao.BillDao;
import com.yanhuan.yhssm.dao.BillSubDetailDao;
import com.yanhuan.yhssm.dao.BillSubMainDao;
import com.yanhuan.yhssm.domain.pojo.Bill;
import com.yanhuan.yhssm.manager.BillManager;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import org.springframework.transaction.annotation.Transactional;

/**
 * BillManagerImpl
 */
@Component
public class BillManagerImpl implements BillManager {

    @Resource
    private BillDao billDao;

    @Resource
    private BillSubMainDao billSubMainDao;

    @Resource
    private BillSubDetailDao billSubDetailDao;

    @Override
    @Transactional
    public Integer insert(Bill bill) {
        Preconditions.checkNotNull(bill);
        Preconditions.checkArgument(CollectionUtils.isNotEmpty(bill.getBillSubMainList()),"BillSubMainList cannot null");

        return null;
    }
}
