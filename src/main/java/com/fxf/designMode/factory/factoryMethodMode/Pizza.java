package com.fxf.designMode.factory.factoryMethodMode;

import java.util.ArrayList;

/**
 * @Classname Pizza
 * @Description TODO Pizza 产品类 该类和创建者类是属于平行的层级
 * @Version 1.0.0
 * @Date 2022/5/6 22:54
 * @Created by 饭小范
 */
public abstract class Pizza {
    public String name;
    public String dough;
    public String sauce;

    /**
     * 佐料
     */
    public ArrayList<String> toppings = new ArrayList<>();

    public void prepare(){
        System.out.println("Preparing"+name);
        System.out.println("Tossing dough...");
        System.out.println("Adding sauce...");
        System.out.println("Adding toppings:");
        for (Object topping : toppings) {
            System.out.println("  " + topping);
        }
    }

    public void bake(){
        System.out.println("bake for 25 minutes at 250");
    }

    public void cut(){
        System.out.println("cutting the pizza into diagonal slices");
    }

    public void box(){
        System.out.println("用圆形的盒子装");
    }

    public String getName(){
        return name;
    }

}
