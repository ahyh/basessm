package com.yanhuan.yhssm.domain.pojo;

import com.yanhuan.yhssm.domain.BaseDomain;

import java.io.Serializable;
import java.util.List;

/**
 * 数据库映射对象
 */
public class Bill extends BaseDomain implements Serializable {

    /**
     * 单号
     */
    private String billNo;

    /**
     * 状态
     */
    private Byte status;

    /**
     * 子单数量
     */
    private Integer mainQty;

    /**
     * 子单集合
     */
    private List<BillSubMain> billSubMainList;

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

    public Integer getMainQty() {
        return mainQty;
    }

    public void setMainQty(Integer mainQty) {
        this.mainQty = mainQty;
    }

    public List<BillSubMain> getBillSubMainList() {
        return billSubMainList;
    }

    public void setBillSubMainList(List<BillSubMain> billSubMainList) {
        this.billSubMainList = billSubMainList;
    }
}
