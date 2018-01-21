package com.yanhuan.yhssm.domain.bussiness;

import java.io.Serializable;

/**
 * Created by yanhuan1 on 2018/1/20.
 */
public class Store implements Serializable {

    private Integer provinceNo;

    private String provinceName;

    private Integer cityNo;

    private String cityName;

    private Integer storeNo;

    private String storeName;

    public Store() {
    }

    public Store(Integer provinceNo, String provinceName, Integer cityNo, String cityName, Integer storeNo, String storeName) {
        this.provinceNo = provinceNo;
        this.provinceName = provinceName;
        this.cityNo = cityNo;
        this.cityName = cityName;
        this.storeNo = storeNo;
        this.storeName = storeName;
    }

    public Integer getProvinceNo() {
        return provinceNo;
    }

    public void setProvinceNo(Integer provinceNo) {
        this.provinceNo = provinceNo;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public Integer getCityNo() {
        return cityNo;
    }

    public void setCityNo(Integer cityNo) {
        this.cityNo = cityNo;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Integer getStoreNo() {
        return storeNo;
    }

    public void setStoreNo(Integer storeNo) {
        this.storeNo = storeNo;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
}
