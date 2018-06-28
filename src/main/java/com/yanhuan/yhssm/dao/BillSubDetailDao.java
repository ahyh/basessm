package com.yanhuan.yhssm.dao;

import com.yanhuan.yhssm.domain.condition.BillSubDetailCondition;
import com.yanhuan.yhssm.domain.condition.BillSubMainCondition;
import com.yanhuan.yhssm.domain.pojo.BillSubDetail;
import com.yanhuan.yhssm.domain.pojo.BillSubMain;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Dao:bill_sub_main表
 */
public interface BillSubDetailDao {

    Integer insert(BillSubDetail billSubDetail);

    Integer update(BillSubDetail billSubDetail);

    Integer delete(Long id);

    BillSubDetail get(Long id);

    List<BillSubDetail> findBillSubDetailList(BillSubDetailCondition billSubDetailCondition);

    Integer insertBatch(@Param("list") List<BillSubDetail> billSubDetailList);

}
