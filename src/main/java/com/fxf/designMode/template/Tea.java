package com.fxf.designMode.template;

/**
 * @Classname Tea
 * @Description TODO
 * @Version 1.0.0
 * @Date 2022/12/24 17:25
 * @Created by 饭小范
 */
public class Tea extends CaffeineBeverage{
    @Override
    void brew() {
        System.out.println("Steeping the tea");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding lemon");
    }
}
