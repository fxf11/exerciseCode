package com.fxf.starterdemo.demo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO
 * @date 2021/8/24 22:34
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "user")
public class UserProperties {

    String userName;
    Integer age;

}
