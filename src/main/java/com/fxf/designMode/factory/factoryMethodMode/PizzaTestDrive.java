package com.fxf.designMode.factory.factoryMethodMode;

import com.fxf.designMode.factory.factoryMethodMode.store.NYPizzaStore;
import com.fxf.designMode.factory.abstractFactory.Pizza;

/**
 * @Classname PizzaTestDrive
 * @Description TODO 工厂方法模式
 * @Version 1.0.0
 * @Date 2022/5/6 23:16
 * @Created by 饭小范
 *
 * 工厂方法模式定义了一个创建对象的接口，但由子类决定要实例化的类是哪一个，将类的实例化交由子类来处理
 *
 * 依赖倒置原则:
 *      定义：高层模块不应该依赖于底层模块，两者都应该依赖其抽象；抽象不应该依赖细节，细节要改依赖抽象（要面向接口编程而不是面向实现编程）
 */
public class PizzaTestDrive {
    public static void main(String[] args) {
        NYPizzaStore nyPizzaStore = new NYPizzaStore();
//        Pizza cheese = nyPizzaStore.orderPizza("cheese");

    }
}
