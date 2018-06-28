package com.yanhuan.yhssm.test;

import com.yanhuan.yhssm.service.EmailService;
import org.junit.Test;

import javax.annotation.Resource;

public class EmailServiceTest extends BaseTest {

    @Resource
    private EmailService emailService;

    @Test
    public void testSendEmail() {
        String to = "yanhuan1@jd.com";
        String subject = "iloveyou";
        String htmlText = "<h1 style='color:red'>Success</h1>";
        emailService.sendEmail(to, subject, htmlText);
    }
}
