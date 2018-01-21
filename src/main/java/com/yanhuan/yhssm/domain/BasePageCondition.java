package com.yanhuan.yhssm.domain;

/**
 * Created by yanhuan1 on 2018/1/20.
 */
public class BasePageCondition extends BaseBussinessDomain {

    private int pageNum;

    private int pageSize;

    private String orderBy;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }
}
