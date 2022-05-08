package com.fxf.designMode.factory.abstractFactory;

/**
 * @Classname Pizza
 * @Description TODO
 * @Version 1.0.0
 * @Date 2022/5/7 22:02
 * @Created by 饭小范
 */
public abstract class Pizza {
    public String name;
    public Dough dough;
    public Sauce sauce;
    public String veggies;
    public Cheese cheese;
    public String pepproni;
    public Clams clams;

    public abstract void prepare();

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
    public void setName(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                ", dough='" + dough + '\'' +
                ", sauce='" + sauce + '\'' +
                ", veggies=" + veggies +
                ", cheese=" + cheese +
                ", pepproni=" + pepproni +
                ", clams=" + clams +
                '}';
    }
}
