package com.yanhuan.yhssm.manager.impl;

import com.google.common.base.Preconditions;
import com.yanhuan.yhssm.dao.BillSubDetailDao;
import com.yanhuan.yhssm.dao.BillSubMainDao;
import com.yanhuan.yhssm.domain.pojo.BillSubMain;
import com.yanhuan.yhssm.manager.BillSubMainManager;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * BillSubMainManagerImpl
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
        Preconditions.checkArgument(billSubMainDao.insert(billSubMain) == 1, "Insert bill_sub_main failed!");
        Integer detailRecords = billSubDetailDao.insertBatch(billSubMain.getBillSubDetailList());
        if (detailRecords != billSubMain.getBillSubDetailList().size()) {
            throw new RuntimeException("Insert detail records is not equals list's size!");
        }
        return 1;
    }

    @Override
    @Transactional
    public Integer insertBatch(List<BillSubMain> billSubMainList) {
        Preconditions.checkArgument(CollectionUtils.isNotEmpty(billSubMainList));
        for (BillSubMain billSubMain : billSubMainList) {
            insert(billSubMain);
        }
        return billSubMainList.size();
    }
}
