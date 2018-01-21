package com.yanhuan.yhssm.domain.bussiness;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 商品
 * Created by yanhuan1 on 2018/1/20.
 */
public class Goods implements Serializable {

    private Byte goodsType;

    private String goodsNo;

    private String goodsName;

    private Integer firstCateNo;

    private String firstCateName;

    private Integer secondCateNo;

    private String secondCateName;

    private Integer thirdCateNo;

    private String thirdCateName;

    private String brand;

    private String color;

    private BigDecimal price;

    public Goods() {
    }

    public Goods(Byte goodsType,String goodsNo, String goodsName, Integer firstCateNo, String firstCateName, Integer secondCateNo, String secondCateName, Integer thirdCateNo, String thirdCateName, String brand, String color, BigDecimal price) {
        this.goodsType = goodsType;
        this.goodsNo = goodsNo;
        this.goodsName = goodsName;
        this.firstCateNo = firstCateNo;
        this.firstCateName = firstCateName;
        this.secondCateNo = secondCateNo;
        this.secondCateName = secondCateName;
        this.thirdCateNo = thirdCateNo;
        this.thirdCateName = thirdCateName;
        this.brand = brand;
        this.color = color;
        this.price = price;
    }

    public Byte getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(Byte goodsType) {
        this.goodsType = goodsType;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
