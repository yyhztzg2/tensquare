package com.tensquare.test;


import com.tensquare.sms.SmsApplication;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.internet.MimeMessage;

@SpringBootTest(classes = SmsApplication.class)
@RunWith(SpringRunner.class)


public class Test {


    @Value("${spring.mail.username}")
    //使用@Value注入application.properties中指定的用户名
    private String from;
    @Autowired
    //用于发送文件
    private JavaMailSender mailSender;
    @org.junit.Test
    public void contextLoads() {
        SimpleMailMessage message = new SimpleMailMessage();
        String arr[]=new String[]{"yyhztzg2@qq.com","w440444@126.com","willie01_lw@meten.com"};
        message.setTo(arr);
//        message.setTo("yyhztzg2@qq.com");//收信人
        message.setSubject("subject");//主题
        message.setText("content");//内容
        message.setFrom(from);//发信人

        mailSender.send(message);

    }
}
