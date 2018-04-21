package com.yanhuan.yhssm.service.impl;

import com.yanhuan.yhssm.domain.pojo.BillSubMain;
import com.yanhuan.yhssm.manager.BillSubMainManager;
import com.yanhuan.yhssm.service.BillSubMainService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yanhuan1 on 2018/4/21.
 */
@Service
public class BillSubMainServiceImpl implements BillSubMainService {

    @Resource
    private BillSubMainManager billSubMainManager;

    @Override
    public Integer insert(BillSubMain billSubMain) {
        return billSubMainManager.insert(billSubMain);
    }

    @Override
    public Integer insertBatch(List<BillSubMain> billSubMainList) {
        return billSubMainManager.insertBatch(billSubMainList);
    }
}
