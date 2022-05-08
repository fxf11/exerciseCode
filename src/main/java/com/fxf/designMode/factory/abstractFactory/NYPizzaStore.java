package com.fxf.designMode.factory.abstractFactory;

import com.fxf.designMode.factory.abstractFactory.Pizza;
import com.fxf.designMode.factory.factoryMethodMode.pizza.NYStyleCheesePizza;
import com.fxf.designMode.factory.abstractFactory.PizzaStore;

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
        Pizza pizza = null;

        PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();
        if ("cheese".equals(type)){
            pizza =  new CheesePizza(ingredientFactory);
            pizza.setName("纽约风味芝士披萨");
        }
        return null;
    }
}
