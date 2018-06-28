package com.yanhuan.yhssm.dao;

import com.yanhuan.yhssm.domain.condition.BillSubMainCondition;
import com.yanhuan.yhssm.domain.pojo.BillSubDetail;
import com.yanhuan.yhssm.domain.pojo.BillSubMain;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Dao:bill_sub_main表
 */
public interface BillSubMainDao {

    Integer insert(BillSubMain billSubMain);

    Integer update(BillSubMain billSubMain);

    Integer delete(Long id);

    BillSubMain get(Long id);

    List<BillSubMain> findBillSubMainList(BillSubMainCondition billSubMainCondition);

    BillSubMain getBillSubMainWithDetails(Long id);


    Integer insertBatch(@Param("list") List<BillSubMain> billSubMainList);
}
