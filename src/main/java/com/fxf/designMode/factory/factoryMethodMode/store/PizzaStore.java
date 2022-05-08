package com.fxf.designMode.factory.factoryMethodMode.store;

import com.fxf.designMode.factory.factoryMethodMode.Pizza;

/**
 * @Classname PizzaStore
 * @Description TODO 抽象创建者类，定义了一个抽象的工厂方法 createPizza 来制造Pizza
 * @Version 1.0.0
 * @Date 2022/5/6 22:53
 * @Created by 饭小范
 */
public abstract class PizzaStore {

    /**
     * 创建Pizza订单，交由Pizza工厂方法来实例化不同风味Pizza
     * @param type
     * @return
     */
    public Pizza orderPizza(String type){
        Pizza pizza;
        pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    /**
     * 实例化pizza的工厂方法用来生产不同的pizza 将创建pizza功能交给子类自己来处理
     * @param type
     * @return
     */
    protected abstract Pizza createPizza(String type);

}
