package com.fxf.pojo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Classname Users
 * @Description TODO
 * @Version 1.0.0
 * @Date 2022/3/20 12:23
 * @Created by 饭小范
 */
@Configuration
public class Users {

    private int id;

    private String name;

    private String beanName;

    public Users(){
        System.out.println("User 被实例化");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("设置："+name);
        this.name = name;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }
    /**
     * 自定义的初始化方法
     */

    public void start(){
        System.out.println("User 中自定义的初始化方法");
    }

}
