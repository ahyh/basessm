package com.yanhuan.yhssm.service.impl;

import com.google.common.base.Preconditions;
import com.yanhuan.yhssm.dao.BillDao;
import com.yanhuan.yhssm.domain.pojo.Bill;
import com.yanhuan.yhssm.manager.BillManager;
import com.yanhuan.yhssm.service.BillService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * BillService
 */
@Service
public class BillServiceImpl implements BillService {

    @Resource
    private BillDao billDao;

    @Resource
    private BillManager billManager;

    @Override
    public Integer insert(Bill bill) {
        return billManager.insert(bill);
    }

    @Override
    public Bill getBillWithSubs(Long id) {
        Preconditions.checkNotNull(id);
        return billDao.getBillWithSubs(id);
    }
}
