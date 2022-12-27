package com.fxf;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;

/**
 * @Classname MyBeanPostProcessor
 * @Description TODO
 * @Version 1.0.0
 * @Date 2022/3/20 12:14
 * @Created by 饭小范
 */
@Configuration
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        System.out.println("before--实例化的bean对象："+bean+",beanName:"+beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        System.out.println("after--实例化的bean对象："+bean+",beanName:"+beanName);
        return bean;
    }
}
