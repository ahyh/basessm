package com.yanhuan.yhssm.service;

import com.yanhuan.yhssm.domain.pojo.BillSubDetail;

import java.util.List;


/**
 * BillSubDetailService
 */
public interface BillSubDetailService {

    Integer insert(BillSubDetail billSubDetail);

    Integer insertBatch(List<BillSubDetail> billSubDetailList);
}
