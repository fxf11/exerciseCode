package com.fxf.file_up_down.valueobject;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Description TODO
 * @Author Administrator
 * @Date 2021/8/18 9:59
 * @Version 1.0
 */
public class Message {

    private String message;


    public Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
