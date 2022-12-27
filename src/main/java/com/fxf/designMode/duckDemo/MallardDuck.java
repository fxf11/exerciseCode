package com.fxf.designMode.duckDemo;

import com.fxf.designMode.duckDemo.behavior.impl.FlyNotWings;
import com.fxf.designMode.duckDemo.behavior.impl.FlyWithWings;
import com.fxf.designMode.duckDemo.behavior.impl.Quack;

/**
 * @Classname MallardDuck 绿头鸭实体类
 * @Description TODO
 * @Version 1.0.0
 * @Date 2022/4/17 12:56
 * @Created by 饭小范
 */
public class MallardDuck extends Duck{

    public MallardDuck() {

        quackBehavior = new Quack();
        flyBehavior = new FlyNotWings();

    }

    public void display(){
        System.out.println("这是一只绿头鸭");
    }

    public static void main(String[] args) {
        Duck mallardDuck = new MallardDuck();
        mallardDuck.preformFly();
        mallardDuck.prefromQuack();
    }
}
