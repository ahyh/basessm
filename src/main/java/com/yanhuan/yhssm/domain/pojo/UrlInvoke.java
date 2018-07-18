package com.yanhuan.yhssm.domain.pojo;

import com.yanhuan.yhssm.domain.BaseDomain;

import java.util.Date;

/**
 * url_invoke表映射对象
 *
 * @author yanhuan1
 */
public class UrlInvoke extends BaseDomain {

    /**
     * url
     */
    private String url;

    /**
     * 用户名
     */
    private String username;

    /**
     * 调用时间
     */
    private Date invokeTime;

    /**
     * 执行时长，毫秒数
     */
    private Long invokeDuration;

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

    public Date getInvokeTime() {
        return invokeTime;
    }

    public void setInvokeTime(Date invokeTime) {
        this.invokeTime = invokeTime;
    }

    public Long getInvokeDuration() {
        return invokeDuration;
    }

    public void setInvokeDuration(Long invokeDuration) {
        this.invokeDuration = invokeDuration;
    }

    public Byte getIsException() {
        return isException;
    }

    public void setIsException(Byte isException) {
        this.isException = isException;
    }
}
