package com.yanhuan.yhssm.domain.pojo;

import com.yanhuan.yhssm.domain.BaseBussinessDomain;

import javax.persistence.criteria.CriteriaBuilder;
import java.math.BigDecimal;

/**
 * 订单明细
 * Created by yanhuan1 on 2018/1/20.
 */
public class OrderDetail extends BaseBussinessDomain {

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 商品编码
     */
    private String goodsNo;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品类型：0-非图书，1-图书
     */
    private Byte goodsType;

    /**
     * 品牌
     */
    private String brand;

    /**
     * 颜色
     */
    private String color;

    /**
     * 商品条码
     */
    private String barcode;

    /**
     * 商品价格
     */
    private BigDecimal price;

    /**
     * 折扣
     */
    private BigDecimal discount;

    /**
     * 一级分类编号
     */
    private Integer firstCateNo;
    /**
     * 一级分类名称
     */
    private String firstCateName;

    /**
     * 二级分类编号
     */
    private Integer secondCateNo;

    /**
     * 二级分类名称
     */
    private String secondCateName;

    /**
     * 三级分类编号
     */
    private Integer thirdCateNo;

    /**
     * 三级分类名称
     */
    private String thirdCateName;

    /**
     * 数量
     */
    private Integer qty;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
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

    public Byte getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(Byte goodsType) {
        this.goodsType = goodsType;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public Integer getFirstCateNo() {
        return firstCateNo;
    }

    public void setFirstCateNo(Integer firstCateNo) {
        this.firstCateNo = firstCateNo;
    }

    public String getFirstCateName() {
        return firstCateName;
    }

    public void setFirstCateName(String firstCateName) {
        this.firstCateName = firstCateName;
    }

    public Integer getSecondCateNo() {
        return secondCateNo;
    }

    public void setSecondCateNo(Integer secondCateNo) {
        this.secondCateNo = secondCateNo;
    }

    public String getSecondCateName() {
        return secondCateName;
    }

    public void setSecondCateName(String secondCateName) {
        this.secondCateName = secondCateName;
    }

    public Integer getThirdCateNo() {
        return thirdCateNo;
    }

    public void setThirdCateNo(Integer thirdCateNo) {
        this.thirdCateNo = thirdCateNo;
    }

    public String getThirdCateName() {
        return thirdCateName;
    }

    public void setThirdCateName(String thirdCateName) {
        this.thirdCateName = thirdCateName;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }
}
