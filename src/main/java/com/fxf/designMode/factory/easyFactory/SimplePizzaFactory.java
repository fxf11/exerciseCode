package com.fxf.designMode.factory.easyFactory;



import com.fxf.designMode.factory.factoryMethodMode.Pizza;

/**
 * @Classname SimplePizzaFactory
 * @Description TODO 简单工厂负责实例化对象并返回给工厂的客户
 * @Version 1.0.0
 * @Date 2022/5/8 14:00
 * @Created by 饭小范
 */
public class SimplePizzaFactory {

    public static Pizza createPizza(String type){
        Pizza pizza = null;

        //创建对象实例的业务逻辑
        if (type.equals("cheese")){
            pizza = new CheesePizza();
        }else {
            //TODO ....
        }
        return pizza;
    }
}
