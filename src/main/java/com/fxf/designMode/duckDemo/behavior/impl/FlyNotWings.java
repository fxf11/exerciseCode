package com.fxf.designMode.duckDemo.behavior.impl;

import com.fxf.designMode.duckDemo.behavior.FlyBehavior;

/**
 * @Classname FlyNotWings
 * @Description TODO
 * @Version 1.0.0
 * @Date 2022/4/17 12:59
 * @Created by 饭小范
 */
public class FlyNotWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("不会飞的鸭子");
    }
}
