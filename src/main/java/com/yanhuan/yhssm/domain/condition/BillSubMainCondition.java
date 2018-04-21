package com.yanhuan.yhssm.domain.condition;

import com.yanhuan.yhssm.domain.BasePageCondition;

/**
 * 数据库表查询条件：bill
 */
public class BillSubMainCondition extends BasePageCondition {

    /**
     * 单号
     */
    private String billNo;

    /**
     * 子单号
     */
    private String subMainNo;

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public String getSubMainNo() {
        return subMainNo;
    }

    public void setSubMainNo(String subMainNo) {
        this.subMainNo = subMainNo;
    }
}
