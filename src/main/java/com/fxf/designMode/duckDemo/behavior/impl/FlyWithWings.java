package com.fxf.designMode.duckDemo.behavior.impl;

import com.fxf.designMode.duckDemo.behavior.FlyBehavior;

/**
 * @Classname FlyWithWings 实现飞行行为
 * @Description TODO
 * @Version 1.0.0
 * @Date 2022/4/17 12:58
 * @Created by 饭小范
 */
public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("会飞的鸭子");
    }
}
