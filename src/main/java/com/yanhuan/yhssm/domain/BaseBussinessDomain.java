package com.yanhuan.yhssm.domain;

/**
 * Created by yanhuan1 on 2018/1/20.
 */
public class BaseBussinessDomain extends BaseDomain {

    /**
     * 省公司编号
     */
    private Integer provinceNo;

    /**
     * 省公司名称
     */
    private String provinceName;

    /**
     * 市公司编号
     */
    private Integer cityNo;

    /**
     * 市公司名称
     */
    private String cityName;

    /**
     * 店编号
     */
    private Integer storeNo;

    /**
     * 店名称
     */
    private String storeName;

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
