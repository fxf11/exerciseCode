package com.fxf.reflection;

import java.io.Serializable;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO
 * @date 2021/7/27 0:33
 */
public class Person implements Serializable,Cloneable {

    public String name;
    public int age;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private Person(String name) {
        this.name = name;
    }

    public Person() {}

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void show(){
        System.out.println("你好，我是一个人");
    }

    private String showNation(String nation){
        System.out.println("我的国籍是："+ nation);
        return nation;
    }

    public static void showDesc(){
        System.out.println("我是一个可爱的人");
    }
}
