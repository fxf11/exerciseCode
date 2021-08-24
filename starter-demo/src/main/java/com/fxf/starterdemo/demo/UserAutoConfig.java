package com.fxf.starterdemo.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO
 * @date 2021/8/24 22:35
 */
@Configuration
@ConditionalOnClass(UserService.class)
@EnableConfigurationProperties(UserProperties.class)
public class UserAutoConfig {

    @Autowired
    private UserProperties userProperties;

    @Bean
    @ConditionalOnMissingBean(UserService.class)
    public UserService userService(){
        return new UserService(userProperties.getUserName(), userProperties.getAge());
    }
}
