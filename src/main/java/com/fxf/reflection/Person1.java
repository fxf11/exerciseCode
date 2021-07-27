package com.fxf.reflection;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO
 * @date 2021/7/27 23:46
 */
public class Person1 extends Creature<String> implements Comparable<String>,MyInteface {

    private String name;
    int age;
    public int id;

    public Person1(){}

    @MyAnnotation(value = "abc")
    private Person1(String name){
        this.name = name;
    }

    public Person1(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    @MyAnnotation
    public String show(String nation){

        System.out.println("我的国际是：" + nation);
        return nation;

    }

    public String display(String interests){
        return interests;
    }

    @Override
    public void info() {
        System.out.println("我是个人");
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }
}
