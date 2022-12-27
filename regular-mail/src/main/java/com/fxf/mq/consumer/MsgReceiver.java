//package com.fxf.mq.consumer;
//
//import com.fxf.mq.config.RabbitConfig;
//import com.rabbitmq.client.Channel;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.amqp.core.Message;
//import org.springframework.amqp.rabbit.annotation.RabbitHandler;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Component;
//
//
//import java.io.IOException;
//
///**
// * @Classname MsgReceiver
// * @Description TODO
// * @Version 1.0.0
// * @Date 2022/4/5 15:58
// * @Created by 饭小范
// */
//@Slf4j
//@Component
//public class MsgReceiver {
//
//    @RabbitHandler
//    @RabbitListener(queues = "topicC")
//    public void receive(Message message, Channel channel) throws IOException {
//        try {
//            channel.basicAck(message.getMessageProperties().getDeliveryTag(),true);
//            System.out.println("接受到的消息为"+new String(message.getBody(),"UTF-8"));
//        } catch (Exception e) {
//            channel.basicNack(message.getMessageProperties().getDeliveryTag(),false,false);
//        }
//    }
//
//
//}
