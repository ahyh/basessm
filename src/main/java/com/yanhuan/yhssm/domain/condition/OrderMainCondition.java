package com.yanhuan.yhssm.domain.condition;

import com.yanhuan.yhssm.domain.BasePageCondition;

import java.math.BigDecimal;

/**
 * 查询条件对象
 * Created by yanhuan1 on 2018/1/16.
 */
public class OrderMainCondition extends BasePageCondition {

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 订单类型：0-线下订单，1-线上订单，2-促销订单，3-京东转单，4-淘宝转单
     */
    private Byte orderType;

    /**
     * 订单状态：0-新建单，1-暂停，2-取消，3-病单
     */
    private Byte orderStatus;

    /**
     * 支付状态：0-未支付，1-已支付，2-退款中，3-已退款，4-订单取消
     */
    private Byte payStatus;

    /**
     * sku数
     */
    private Integer skuCount;

    /**
     * 商品总件数
     */
    private Integer goodsCount;

    /**
     * 下单人
     */
    private String buyer;

    /**
     * 是否是会员：1-是，0-否
     */
    private Byte isVip;

    /**
     * 销售员编号
     */
    private String saleManNo;

    /**
     * 销售员名称
     */
    private String saleManName;

    /**
     * 支付方式：0-现金，1-支付宝，2-微信支付，3-网银
     */
    private Byte payWayType;

    /**
     * 订单金额
     */
    private BigDecimal orderAmount;

    /**
     * 实付金额
     */
    private BigDecimal actualAmount;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Byte getOrderType() {
        return orderType;
    }

    public void setOrderType(Byte orderType) {
        this.orderType = orderType;
    }

    public Byte getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Byte orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Byte getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Byte payStatus) {
        this.payStatus = payStatus;
    }

    public Integer getSkuCount() {
        return skuCount;
    }

    public void setSkuCount(Integer skuCount) {
        this.skuCount = skuCount;
    }

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public Byte getIsVip() {
        return isVip;
    }

    public void setIsVip(Byte isVip) {
        this.isVip = isVip;
    }

    public String getSaleManNo() {
        return saleManNo;
    }

    public void setSaleManNo(String saleManNo) {
        this.saleManNo = saleManNo;
    }

    public String getSaleManName() {
        return saleManName;
    }

    public void setSaleManName(String saleManName) {
        this.saleManName = saleManName;
    }

    public Byte getPayWayType() {
        return payWayType;
    }

    public void setPayWayType(Byte payWayType) {
        this.payWayType = payWayType;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public BigDecimal getActualAmount() {
        return actualAmount;
    }

    public void setActualAmount(BigDecimal actualAmount) {
        this.actualAmount = actualAmount;
    }
}
