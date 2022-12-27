package com.fxf.designMode.observer.impl;

import com.fxf.designMode.observer.Subject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.fxf.designMode.observer.Observer;


/**
 * @Classname WeaterData
 * @Description TODO
 * @Version 1.0.0
 * @Date 2022/4/18 22:38
 * @Created by 饭小范
 */
public class WeatherData implements Subject {

    private ArrayList observers;

    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
        observers = new ArrayList();

    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObserver() {
        //通知到所有观察者
        for (Object observer : observers) {
            Observer observer1 = (Observer) observer;
            observer1.update(temperature,humidity,pressure);
        }
    }

    //主题接收到数据并更新然后去通知所有观察者
    public void setMeasurements(float temp, float humidity, float pressure){
        this.temperature = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        notifyObserver();
    }
}
