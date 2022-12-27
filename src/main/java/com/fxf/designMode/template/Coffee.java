package com.fxf.designMode.template;

/**
 * @Classname Coffee
 * @Description TODO
 * @Version 1.0.0
 * @Date 2022/12/24 17:25
 * @Created by 饭小范
 */
public class Coffee extends CaffeineBeverage{
    @Override
    void brew() {
        System.out.println("Dripping Coffee through filter");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding Sugar and Milk");
    }

    public static void main(String[] args) {
        System.out.println(1);
    }
}
