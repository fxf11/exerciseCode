package com.fxf.designMode.observer;

import com.fxf.designMode.observer.Observer;

/**
 * @Classname Subject 观察者模式 主题接口
 * @Description TODO
 * @Version 1.0.0
 * @Date 2022/4/18 22:28
 * @Created by 饭小范
 */
public interface Subject {

    /**
     * 注册称为观察者
     * @param o
     */
    void registerObserver(Observer o);

    /**
     * 从观察者列表中删除
     * @param o
     */
    void removeObserver(Observer o);

    /**
     * 通知方法，主题状态被改变的时候会被调用 然后通知观察者
     */
    void notifyObserver();
}
