package com.yanhuan.yhssm.domain.condition;

import com.yanhuan.yhssm.domain.BasePageCondition;

import java.util.Date;

/**
 * 查询条件对象
 * Created by yanhuan1 on 2018/1/16.
 */
public class UrlInvokeCondition extends BasePageCondition {

    /**
     * url
     */
    private String url;

    /**
     * 用户名
     */
    private String username;

    /**
     * 开始调用时间
     */
    private String invokeTimeStart;

    /**
     * 结束调用时间
     */
    private String invokeTimeEnd;

    /**
     * 执行时长，毫秒数
     */
    private Integer invokeDuration;

    /**
     * 是否有异常：1-异常，0-无异常
     */
    private Byte isException;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getInvokeTimeStart() {
        return invokeTimeStart;
    }

    public void setInvokeTimeStart(String invokeTimeStart) {
        this.invokeTimeStart = invokeTimeStart;
    }

    public String getInvokeTimeEnd() {
        return invokeTimeEnd;
    }

    public void setInvokeTimeEnd(String invokeTimeEnd) {
        this.invokeTimeEnd = invokeTimeEnd;
    }

    public Integer getInvokeDuration() {
        return invokeDuration;
    }

    public void setInvokeDuration(Integer invokeDuration) {
        this.invokeDuration = invokeDuration;
    }

    public Byte getIsException() {
        return isException;
    }

    public void setIsException(Byte isException) {
        this.isException = isException;
    }
}
