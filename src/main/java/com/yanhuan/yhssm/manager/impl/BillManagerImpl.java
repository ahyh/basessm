package com.yanhuan.yhssm.manager.impl;

import com.google.common.base.Preconditions;
import com.yanhuan.yhssm.dao.BillDao;
import com.yanhuan.yhssm.domain.pojo.Bill;
import com.yanhuan.yhssm.manager.BillManager;
import com.yanhuan.yhssm.manager.BillSubMainManager;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * BillManagerImpl
 */
@Component
public class BillManagerImpl implements BillManager {

    @Resource
    private BillDao billDao;

    @Resource
    private BillSubMainManager billSubMainManager;

    @Override
    @Transactional
    public Integer insert(Bill bill) {
        Preconditions.checkNotNull(bill);
        Preconditions.checkArgument(CollectionUtils.isNotEmpty(bill.getBillSubMainList()), "BillSubMainList cannot null");
        Integer billRecords = billDao.insert(bill);
        if (billRecords != 1) {
            throw new RuntimeException("Insert billRecords is not equals 1");
        }
        billSubMainManager.insertBatch(bill.getBillSubMainList());
        return 1;
    }
}
