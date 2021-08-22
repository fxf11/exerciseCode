package com.fxf.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.internet.MimeMessage;
import java.util.Map;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO
 * @date 2021/8/22 23:38
 */
@Component
public class MailUtil {

    private String sender = "2099512771@qq.com";
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private TemplateEngine templateEngine;

    /**
     * @Author thailandking
     * @Date 2020/1/3 10:46
     * @LastEditors thailandking
     * @LastEditTime 2020/1/3 10:46
     * @Description 6、发送模板邮件
     */
    public void sendTemplateMail(String receiver, String subject, String emailTemplate, Map<String, Object> dataMap) throws Exception {
        Context context = new Context();
        for (Map.Entry<String, Object> entry : dataMap.entrySet()) {
            context.setVariable(entry.getKey(), entry.getValue());
        }
        String templateContent = templateEngine.process(emailTemplate, context);
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(sender);
        helper.setTo(receiver);
        helper.setSubject(subject);
        helper.setText(templateContent, true);
        javaMailSender.send(message);
    }

}
