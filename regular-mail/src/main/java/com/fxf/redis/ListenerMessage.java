package com.fxf.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.stream.MapRecord;
import org.springframework.data.redis.stream.StreamListener;
import org.springframework.stereotype.Component;

/**
 * @Classname ListenerMessage
 * @Description TODO
 * @Version 1.0.0
 * @Date 2022/5/15 17:55
 * @Created by 饭小范
 */
@Slf4j
@Component
public class ListenerMessage implements StreamListener<String, MapRecord<String, String, String>> {

    @Override
    public void onMessage(MapRecord<String, String, String> entries) {
        log.info("接受到来自redis的消息---------------------");
        System.out.println("message id "+entries.getId());
        System.out.println("stream "+entries.getStream());
        System.out.println("body "+entries.getValue());
    }

}
