package com.fxf.designMode.observer;

/**
 * @Classname Observer 所有观察者都必须实现此接口，去修改通知到的参数
 * @Description TODO
 * @Version 1.0.0
 * @Date 2022/4/18 22:33
 * @Created by 饭小范
 */
public interface Observer {

    void update(float temp,float humidity,float pressure);
}
