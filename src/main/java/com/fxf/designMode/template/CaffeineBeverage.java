package com.fxf.designMode.template;

/**
 * @Classname CaffeineBeverage
 * @Description TODO 咖啡因饮料超类，给泡咖啡和泡茶定义一个通用的抽象类模板
 * 不同的地方使用抽象方法，子类继承来重写
 * @Version 1.0.0
 * @Date 2022/12/24 17:19
 * @Created by 饭小范
 */
public abstract class CaffeineBeverage {

    final void prepareRecipe(){
        //烧水
        boilWater();
        //冲咖啡 / 泡茶叶
        brew();
        //倒进杯子
        pourInCup();
        //加糖或牛奶 / 加柠檬
        addCondiments();
    }

    //将不同的地方定义为抽象方法，子类继承实现
    abstract void brew();

    abstract void addCondiments();

    void boilWater(){
        System.out.println("Boiling water");
    }

    void pourInCup(){
        System.out.println("Pouring into cup");
    }

}
