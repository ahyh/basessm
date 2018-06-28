package com.yanhuan.yhssm.service.impl;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.yanhuan.yhssm.dao.BillSubDetailDao;
import com.yanhuan.yhssm.domain.pojo.BillSubDetail;
import com.yanhuan.yhssm.service.BillSubDetailService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * BillSubDetailServiceImpl
 */
@Service
public class BillSubDetailServiceImpl implements BillSubDetailService {

    @Resource
    private BillSubDetailDao billSubDetailDao;

    @Override
    public Integer insert(BillSubDetail billSubDetail) {
        Preconditions.checkNotNull(billSubDetail);
        Preconditions.checkArgument(billSubDetailDao.insert(billSubDetail) == 1, "Insert billSubDetail failed!" + JSON.toJSONString(billSubDetail));
        return 1;
    }

    @Override
    public Integer insertBatch(List<BillSubDetail> billSubDetailList) {
        Preconditions.checkNotNull(CollectionUtils.isNotEmpty(billSubDetailList), "billSubDetailList cannot be null!");
        Integer insertRecords = billSubDetailDao.insertBatch(billSubDetailList);
        if (insertRecords != billSubDetailList.size()) {
            throw new RuntimeException("Insert Records is not equals billSubDetailList's size!");
        }
        return billSubDetailList.size();
    }
}
