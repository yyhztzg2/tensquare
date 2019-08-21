package com.tensquare.sms.listener;

import com.aliyuncs.exceptions.ClientException;
import com.tensquare.sms.utils.SmsUtil;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RabbitListener(queues = "sms")
public class SmsListener {
    @Value("${spring.mail.username}")
    //使用@Value注入application.properties中指定的用户名
    private String from;
    @Autowired
    //用于发送文件
    private JavaMailSender mailSender;

    @Autowired
    private SmsUtil smsUtil;

    @Value("${aliyun.sms.template_code}")
    private String template_code;

    @Value("${aliyun.sms.sign_name}")
    private String sign_name;

    @RabbitHandler
    public void executeSms(Map<String, String> map){
        String mobile = map.get("mobile");
        String checkcode = map.get("checkcode");
        System.out.println("手机号："+map.get("mobile"));
        System.out.println("验证码："+map.get("checkcode"));
        try {
//            发送短信
            smsUtil.sendSms(mobile, template_code, sign_name, "{\"code\":\""+checkcode+"\"}");
//

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void sendEmail() {
        SimpleMailMessage message = new SimpleMailMessage();
        String arr[]=new String[]{"w440444@126.com","willie01_lw@meten.com"};
        message.setTo(arr);

        message.setSubject("测试结果");//主题
        message.setText("自动化测试失败");//内容
        message.setFrom(from);//发信人

        mailSender.send(message);

    }
}
