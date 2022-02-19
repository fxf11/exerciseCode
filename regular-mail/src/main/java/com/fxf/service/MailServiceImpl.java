package com.fxf.service;

import com.alibaba.fastjson.JSONObject;
import com.fxf.util.HttpUtils;
import com.fxf.util.MailUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO
 * @date 2021/8/22 23:01
 */
@Service
@Slf4j
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private MailUtil mailUtil;

    @Scheduled(cron="0/5 * *  * * ? ")
    public void test(){
//        System.out.println(123123123);
    }

    @Override
    @Scheduled(cron = "0 48 9 ? * MON-FRI")
    public void sentMail() {
        String receiver = "2218142110@qq.com";
        //发送邮件
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        String subject = "邮件主题";
        String emailTemplate = "registerTemplate";
        String qh = HttpUtils.sendGet("https://api.vvhan.com/api/love");
        String xh = HttpUtils.sendGet("https://api.vvhan.com/api/xh");
        String tq = HttpUtils.sendGet("https://api.vvhan.com/api/weather");
        JSONObject jsonObject = JSONObject.parseObject(tq);
        Map<String,Object> info = (Map) jsonObject.get("info");
        info.put("qh", qh);
//        info.put("daoqian",daoqian);
        info.put("xh", xh);
        info.put("createTime", sdf.format(new Date()));
        try {
            mailUtil.sendTemplateMail(receiver, subject, emailTemplate, info);
            sendSelfMail();
        } catch (Exception e) {
            e.printStackTrace();
//            return;
        }
    }

    public void sendSelfMail(){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        // 发件人
        simpleMailMessage.setFrom("2099512771@qq.com");
        // 收件人
        simpleMailMessage.setTo("2298831219@qq.com");
        // 邮件主题
        simpleMailMessage.setSubject("邮件已发送");
        // 邮件内容
        simpleMailMessage.setText("邮件已发送");
        javaMailSender.send(simpleMailMessage);
    }

}
