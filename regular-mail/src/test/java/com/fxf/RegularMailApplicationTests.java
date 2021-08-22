package com.fxf;

import com.alibaba.fastjson.JSONObject;
import com.fxf.util.HttpUtils;
import com.fxf.util.MailUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class RegularMailApplicationTests {

    @Autowired
    private MailUtil mailUtil;

    @Test
    void contextLoads() {
        String receiver = "2298831219@qq.com";
        //发送邮件
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        String subject = "SecondGoodTrade用户注册";
        String emailTemplate = "registerTemplate";
        String code = "123123123";
        Map<String, Object> dataMap = new HashMap<>();
//        dataMap.put("email", email);
        dataMap.put("code", code);
        dataMap.put("createTime", sdf.format(new Date()));
        try {
            mailUtil.sendTemplateMail(receiver, subject, emailTemplate, dataMap);
        } catch (Exception e) {
            return;
        }
    }

    @Test
    void apiTest(){
        String s = HttpUtils.sendGet("https://api.vvhan.com/api/weather");

        JSONObject jsonObject = JSONObject.parseObject(s);
        Map<String,Object> info = (Map) jsonObject.get("info");
        System.out.println(info.get("date"));
        System.out.println(s);
    }

}
