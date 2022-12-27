package com.fxf.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Classname DemoListenner
 * @Description TODO
 * @Version 1.0.0
 * @Date 2022/3/13 17:40
 * @Created by 饭小范
 */
@Component
public class DemoListenner implements ApplicationListener<DemoEvent> {
    @Override
    public void onApplicationEvent(DemoEvent event) {
        event.printMsg();
    }
}
