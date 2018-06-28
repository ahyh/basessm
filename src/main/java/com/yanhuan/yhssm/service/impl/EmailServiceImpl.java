package com.yanhuan.yhssm.service.impl;

import com.yanhuan.yhssm.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;

/**
 * 邮件服务
 *
 * @author yanhuan1
 */
@Service
public class EmailServiceImpl implements EmailService {

    private static final Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);

    @Resource
    private JavaMailSender javaMailSender;

    @Value("${email.systemEmail}")
    private String systemEmail;

    /**
     * 发送邮件服务
     *
     * @param to       邮件接收者的地址
     * @param subject  邮件的主题
     * @param htmlText 邮件的html文档
     */
    @Override
    public void sendEmail(String to, String subject, String htmlText) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper msgHelper = new MimeMessageHelper(mimeMessage, true, "utf-8");
            msgHelper.setFrom(systemEmail);
            msgHelper.setTo(to);
            msgHelper.setSubject(subject);
            msgHelper.setText(htmlText, true);
            javaMailSender.send(mimeMessage);
        } catch (Exception e) {
            logger.error("EmailServiceImpl sendEmail error:", e);
        }
    }
}
