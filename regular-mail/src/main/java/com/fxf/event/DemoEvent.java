package com.fxf.event;

import org.springframework.context.ApplicationEvent;

/**
 * @Classname DemoEvent
 * @Description TODO
 * @Version 1.0.0
 * @Date 2022/3/13 17:39
 * @Created by 饭小范
 */
public class DemoEvent extends ApplicationEvent {

    private String msg;

    public DemoEvent(Object source,String msg) {
        super(source);
        this.msg = msg;
    }

    public void printMsg(){
        System.out.println("msg = "+msg);
    }
}
