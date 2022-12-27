package com.fxf.designMode.duckDemo;


import com.fxf.designMode.duckDemo.behavior.FlyBehavior;
import com.fxf.designMode.duckDemo.behavior.QuackBehavior;

/**
 * @Classname Duck 鸭子超类
 * @Description TODO
 * @Version 1.0.0
 * @Date 2022/4/17 12:49
 * @Created by 饭小范
 */
public class Duck {

    public String duckType;

    public FlyBehavior flyBehavior;

    public QuackBehavior quackBehavior;

    public void swim(){
        System.out.println("游泳行为");
    }

    public void display(){
        System.out.println("其他行为");
    }

    /**
     * 每只鸭子都会引用实现QuackBehavior接口的对象
     */
    public void prefromQuack(){
        quackBehavior.quack();
    }

    /**
     * 鸭子对象不亲自处理飞行的行为，而是委托给quackBehavior引用的对象
     */
    public void preformFly(){
        flyBehavior.fly();
    }
}
