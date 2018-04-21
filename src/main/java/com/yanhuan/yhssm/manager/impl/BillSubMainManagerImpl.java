package com.yanhuan.yhssm.manager.impl;

import com.google.common.base.Preconditions;
import com.yanhuan.yhssm.dao.BillSubDetailDao;
import com.yanhuan.yhssm.dao.BillSubMainDao;
import com.yanhuan.yhssm.domain.pojo.BillSubMain;
import com.yanhuan.yhssm.manager.BillSubMainManager;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

/**
 * Created by yanhuan1 on 2018/4/21.
 */
@Component
public class BillSubMainManagerImpl implements BillSubMainManager {

    @Resource
    private BillSubMainDao billSubMainDao;

    @Resource
    private BillSubDetailDao billSubDetailDao;

    @Override
    @Transactional
    public Integer insert(BillSubMain billSubMain) {
        Preconditions.checkNotNull(billSubMain);
        Preconditions.checkArgument(CollectionUtils.isNotEmpty(billSubMain.getBillSubDetailList()));
        Preconditions.checkArgument(billSubMainDao.insert(billSubMain) == 1,"Insert bill_sub_main failed!");

        return null;
    }
}
