package com.yanhuan.yhssm.service;

import com.yanhuan.yhssm.domain.pojo.Bill;

/**
 * Created by yanhuan1 on 2018/4/21.
 */
public interface BillService {

    Integer insert(Bill bill);

    Bill getBillWithSubs(Long id);

}
