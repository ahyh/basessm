package com.yanhuan.yhssm.service;

/**
 * Email相关方法
 */
public interface EmailService {

    /**
     * 发送邮件方法
     *
     * @param to       邮件接收者的地址
     * @param subject  邮件的主题
     * @param htmlText 邮件的html文档
     */
    void sendEmail(String to, String subject, String htmlText);
}
