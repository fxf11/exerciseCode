//package com.fxf.redis;
//
//import lombok.var;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.connection.stream.Consumer;
//import org.springframework.data.redis.connection.stream.MapRecord;
//import org.springframework.data.redis.connection.stream.ReadOffset;
//import org.springframework.data.redis.connection.stream.StreamOffset;
//import org.springframework.data.redis.stream.StreamMessageListenerContainer;
//import org.springframework.data.redis.stream.Subscription;
//
//import java.time.Duration;
//
///**
// * @Classname RedisStreamConfig
// * @Description TODO
// * @Version 1.0.0
// * @Date 2022/5/15 17:56
// * @Created by 饭小范
// */
//@Configuration
//public class RedisStreamConfig {
//
//    @Autowired
//    private ListenerMessage streamListener;
//
//    @Bean
//    public Subscription subscription(RedisConnectionFactory factory){
//        /**
//         * 构建一个监听器
//         */
//        StreamMessageListenerContainer.StreamMessageListenerContainerOptions<String, MapRecord<String, String, String>> build = StreamMessageListenerContainer
//                .StreamMessageListenerContainerOptions
//                .builder()
//                .pollTimeout(Duration.ofSeconds(1))
//                .build();
//        StreamMessageListenerContainer<String, MapRecord<String, String, String>> listenerContainer = StreamMessageListenerContainer.create(factory, build);
//        Subscription subscription = listenerContainer.receiveAutoAck(Consumer.from("mygroup", "fxf"),
//                StreamOffset.create("mystream", ReadOffset.lastConsumed()), streamListener);
//        listenerContainer.start();
//        return subscription;
//    }
//
//    @Bean
//    public Subscription subscription2(RedisConnectionFactory factory) {
//        var options = StreamMessageListenerContainer
//                .StreamMessageListenerContainerOptions
//                .builder()
//                .pollTimeout(Duration.ofSeconds(1))
//                .build();
////        initStream("mystream", "mygroup");    //详细描述请看下方的问题补充——初始化key和group
//        var listenerContainer = StreamMessageListenerContainer.create(factory, options);
//        var subscription = listenerContainer.receiveAutoAck(Consumer.from("mygroup", "fxf2"),
//                StreamOffset.create("mystream2", ReadOffset.lastConsumed()), streamListener);
//        listenerContainer.start();
//        return subscription;
//    }
//}
