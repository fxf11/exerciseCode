package com.fxf.controller;


import com.fxf.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO
 * @date 2021/8/23 0:33
 */
@RestController
@RequestMapping("/mail")
public class MailController {

    @Autowired
    private MailService mailService;
//    @Autowired
//    private MsgProducer msgProducer;

    @RequestMapping("/sendMail")
    public void sendMail(){

//        mailService.sentMail();
//        for (int i = 0; i < 100; i++) {
//            msgProducer.sendMsg("消费者发送消息"+i);
//        }

        Thread thread = new Thread(() -> {
            while (true) {
                System.out.println("cpu");
            }
        }, "cpu test");

        thread.start();

    }


}
