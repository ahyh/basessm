package com.yanhuan.yhssm.domain.pojo;

import com.yanhuan.yhssm.domain.BaseDomain;

import java.math.BigDecimal;
import java.util.List;

/**
 * 数据库表映射对象：bill_sub_main
 */
public class BillSubMain extends BaseDomain {

    /**
     * 单号
     */
    private String billNo;

    /**
     * 子单号
     */
    private String subMainNo;

    /**
     * 子单明细数量
     */
    private Integer detailQty;

    /**
     * 子单金额
     */
    private BigDecimal amount;

    /**
     * 子单明细
     */
    private List<BillSubDetail> billSubDetailList;

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

    public Integer getDetailQty() {
        return detailQty;
    }

    public void setDetailQty(Integer detailQty) {
        this.detailQty = detailQty;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public List<BillSubDetail> getBillSubDetailList() {
        return billSubDetailList;
    }

    public void setBillSubDetailList(List<BillSubDetail> billSubDetailList) {
        this.billSubDetailList = billSubDetailList;
    }
}
