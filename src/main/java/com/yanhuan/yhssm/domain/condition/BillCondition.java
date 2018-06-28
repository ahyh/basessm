package com.yanhuan.yhssm.domain.condition;

import com.yanhuan.yhssm.domain.BasePageCondition;

/**
 * 数据库表查询条件：bill
 */
public class BillCondition extends BasePageCondition {

    /**
     * 单号
     */
    private String billNo;

    /**
     * 状态
     */
    private Byte status;

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}
