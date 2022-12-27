package com.fxf.designMode.observer;

import com.fxf.designMode.observer.impl.CurrentConditionsDisplay;
import com.fxf.designMode.observer.impl.CurrentConditionsDisplayV2;
import com.fxf.designMode.observer.impl.WeatherData;

/**
 * @Classname WeatherStation
 * @Description TODO
 * @Version 1.0.0
 * @Date 2022/4/18 22:51
 * @Created by 饭小范
 */
public class WeatherStation {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplayV2 currentConditionsDisplayV2 = new CurrentConditionsDisplayV2(weatherData);
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);

        weatherData.setMeasurements(1f,2f,3f);
    }

}
