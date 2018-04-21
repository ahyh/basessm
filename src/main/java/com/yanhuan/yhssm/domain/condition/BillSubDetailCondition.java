package com.yanhuan.yhssm.domain.condition;

import com.yanhuan.yhssm.domain.BasePageCondition;

/**
 * 数据库表查询条件：bill
 */
public class BillSubDetailCondition extends BasePageCondition {

    /**
     * 子单号
     */
    private String subMainNo;

    /**
     * 商品编码
     */
    private String goodsNo;

    /**
     * 商品名称
     */
    private String goodsName;

    public String getSubMainNo() {
        return subMainNo;
    }

    public void setSubMainNo(String subMainNo) {
        this.subMainNo = subMainNo;
    }

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
}
