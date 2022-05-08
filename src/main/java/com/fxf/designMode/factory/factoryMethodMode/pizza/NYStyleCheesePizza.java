package com.fxf.designMode.factory.factoryMethodMode.pizza;

import com.fxf.designMode.factory.factoryMethodMode.Pizza;

/**
 * @Classname NYStypeCheesePizza
 * @Description TODO
 * @Version 1.0.0
 * @Date 2022/5/6 23:11
 * @Created by 饭小范
 */
public class NYStyleCheesePizza extends Pizza {

    public NYStyleCheesePizza() {
        dough = "thin Crust Dough";
        name = "纽约风味芝士Pizza";
        sauce = "thin Crust Dough";
        toppings.add("Crated reggiano cheese");
    }
}
