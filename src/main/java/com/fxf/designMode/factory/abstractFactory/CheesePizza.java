package com.fxf.designMode.factory.abstractFactory;

/**
 * @Classname CheesePizza
 * @Description TODO
 * @Version 1.0.0
 * @Date 2022/5/7 22:05
 * @Created by 饭小范
 */
public class CheesePizza extends Pizza{
    public PizzaIngredientFactory factory;

    public CheesePizza(PizzaIngredientFactory factory) {
        this.factory = factory;
    }

    @Override
    public void prepare() {
        dough = factory.createDough();
        cheese = factory.createCheese();
        sauce = factory.createSauce();
    }
}
