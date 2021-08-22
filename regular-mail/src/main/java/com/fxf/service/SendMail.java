package com.fxf.service;

import com.alibaba.fastjson.JSONObject;
import com.fxf.util.HttpUtils;
import com.fxf.util.MailUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO
 * @date 2021/8/22 23:46
 */
public class SendMail {

    @Autowired
    private MailUtil mailUtil;


    public void morningMail(){
        String receiver = "2298831219@qq.com";
        //发送邮件
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        String subject = "早安邮件";
        String emailTemplate = "registerTemplate";
        String code = "123123123";
        String qh = HttpUtils.sendGet("https://api.vvhan.com/api/love");
        String xh = HttpUtils.sendGet("https://api.vvhan.com/xiaohua.html");
        String tq = HttpUtils.sendGet("https://api.vvhan.com/api/weather");
        JSONObject jsonObject = JSONObject.parseObject(tq);
        Map<String,Object> info = (Map) jsonObject.get("info");
        info.put("qh", qh);
        info.put("xh", qh);
        info.put("code", code);
        info.put("createTime", sdf.format(new Date()));
        try {
            mailUtil.sendTemplateMail(receiver, subject, emailTemplate, info);
        } catch (Exception e) {
            return;
        }
    }
}
