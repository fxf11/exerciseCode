package com.fxf.designMode.observer.impl;

import com.fxf.designMode.observer.DisplayElement;
import com.fxf.designMode.observer.Observer;
import com.fxf.designMode.observer.Subject;

/**
 * @Classname CurrentConfitionsDisplay
 * @Description TODO
 * @Version 1.0.0
 * @Date 2022/4/18 22:37
 * @Created by 饭小范
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {

    private float temp;
    private float humidity;
    private Subject weatherData;

    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        //将当前对象注册到观察者中
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {//显示观察者接收到的参数
        System.out.println("current conditions："+temp+"F degrees and "+ humidity +"% humidity");
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.humidity = humidity;
        display();
    }
}
