package com.fxf.designMode.factory.abstractFactory;

/**
 * @Classname NYPizzaIngredientFactory
 * @Description TODO
 * @Version 1.0.0
 * @Date 2022/5/8 16:04
 * @Created by 饭小范
 */
public class NYPizzaIngredientFactory implements PizzaIngredientFactory{
    @Override
    public Dough createDough() {
        return null;
    }

    @Override
    public Sauce createSauce() {
        return null;
    }

    @Override
    public Cheese createCheese() {
        return null;
    }

    @Override
    public Clams createClams() {
        return null;
    }

    @Override
    public Pepperoni createPepperoni() {
        return null;
    }

    @Override
    public String[] createVeggies() {
        return new String[0];
    }
}
