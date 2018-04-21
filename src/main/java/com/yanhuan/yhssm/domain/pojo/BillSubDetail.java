package com.yanhuan.yhssm.domain.pojo;

import com.yanhuan.yhssm.domain.BaseDomain;

import java.math.BigDecimal;

/**
 * 数据库表映射对象：bill_sub_detail
 */
public class BillSubDetail extends BaseDomain {

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

    /**
     * 数量
     */
    private Integer qty;

    /**
     * 价格
     */
    private BigDecimal price;

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

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
