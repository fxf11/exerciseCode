package com.fxf.designMode.duckDemo.behavior.impl;

import com.fxf.designMode.duckDemo.behavior.QuackBehavior;

/**
 * @Classname Quack
 * @Description TODO
 * @Version 1.0.0
 * @Date 2022/4/17 13:00
 * @Created by 饭小范
 */public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("呱呱叫");
    }
}
