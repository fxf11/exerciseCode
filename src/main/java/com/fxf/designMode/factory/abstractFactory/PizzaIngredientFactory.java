package com.fxf.designMode.factory.abstractFactory;

/**
 * @Classname PiizzaIngredientFactory
 * @Description TODO 创建原料接口
 * @Version 1.0.0
 * @Date 2022/5/7 0:51
 * @Created by 饭小范
 */
public interface PizzaIngredientFactory {

    Dough createDough();
    Sauce createSauce();
    Cheese createCheese();
    Clams createClams();
    Pepperoni createPepperoni();
    String[] createVeggies();

}
