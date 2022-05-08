package com.fxf.designMode.factory.factoryMethodMode.store;

import com.fxf.designMode.factory.factoryMethodMode.Pizza;
import com.fxf.designMode.factory.factoryMethodMode.pizza.NYStyleCheesePizza;

/**
 * @Classname NYPizzaStore
 * @Description TODO
 * @Version 1.0.0
 * @Date 2022/5/6 23:10
 * @Created by 饭小范
 */
public class NYPizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(String type) {
        if ("cheese".equals(type)){
            return new NYStyleCheesePizza();
        }
        return null;
    }
}
