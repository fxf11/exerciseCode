package com.fxf.config;

import com.fxf.service.MailService;
import com.fxf.service.MailServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Classname AnnotationConfig
 * @Description TODO
 * @Version 1.0.0
 * @Date 2022/3/25 1:11
 * @Created by 饭小范
 */
@EnableAspectJAutoProxy
@Configuration
public class AnnotationConfig {

    @Bean
    public MailService mailService(){
        return new MailServiceImpl();
    }
}
