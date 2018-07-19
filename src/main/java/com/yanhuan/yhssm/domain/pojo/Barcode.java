package com.yanhuan.yhssm.domain.pojo;

import java.io.Serializable;

/**
 * 条码
 */
public class Barcode implements Serializable {

    /**
     * 条码内容
     */
    private String content;

    /**
     * 条码数量
     */
    private Integer qty;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }
}
