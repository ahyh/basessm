package com.yanhuan.yhssm.service;

import com.yanhuan.yhssm.domain.pojo.BillSubMain;

import java.util.List;


/**
 * Created by yanhuan1 on 2018/4/21.
 */
public interface BillSubMainService {

    Integer insert(BillSubMain billSubMain);

    Integer insertBatch(List<BillSubMain> billSubMainList);
}
