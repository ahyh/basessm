package com.yanhuan.yhssm.manager;

import com.yanhuan.yhssm.domain.pojo.BillSubMain;

import java.util.List;

/**
 * BillSubMainManager
 */
public interface BillSubMainManager {

    Integer insert(BillSubMain billSubMain);

    Integer insertBatch(List<BillSubMain> billSubMainList);
}
