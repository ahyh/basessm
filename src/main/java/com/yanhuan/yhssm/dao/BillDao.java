package com.yanhuan.yhssm.dao;

import com.yanhuan.yhssm.domain.condition.BillCondition;
import com.yanhuan.yhssm.domain.pojo.Bill;

import java.util.List;

/**
 * Dao:bill表
 */
public interface BillDao {

    Integer insert(Bill bill);

    Integer update(Bill bill);

    Integer delete(Long id);

    Bill get(Long id);

    List<Bill> findBillList(BillCondition billCondition);

}
