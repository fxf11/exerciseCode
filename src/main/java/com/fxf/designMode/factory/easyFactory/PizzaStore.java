package com.fxf.designMode.factory.easyFactory;

import com.fxf.designMode.factory.factoryMethodMode.Pizza;

/**
 * @Classname PizzaStore
 * @Description TODO 定义工厂的客户：既需要从工厂中获取对象实例的对象
 * @Version 1.0.0
 * @Date 2022/5/8 13:58
 * @Created by 饭小范
 */
public abstract class PizzaStore {

    SimplePizzaFactory factory;

    public PizzaStore(SimplePizzaFactory factory) {
        this.factory = factory;
    }

    public Pizza orderPizza(String type){
        Pizza pizza;
        pizza = factory.createPizza(type);
        pizza.cut();
        pizza.bake();
        pizza.box();
        return pizza;
    }
}
