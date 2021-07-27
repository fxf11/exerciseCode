package com.fxf.generic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO 自定义泛型类
 * @date 2021/7/26 0:18
 */
public class GenericTest1 {


    @Test
    public void test1(){

        Order order = new Order();

        //如果定义了泛型类，实例化没有指明类的泛型，则认为此泛型类型为Object类型
        //要求：如果定义了类是带泛型的，则在实例化时要指明类的泛型
        order.setOrderT(123);
        order.setOrderT("AVC");

        //带上泛型
        Order<String> order1 = new Order<>("order",1001,"Order:AA");
        order1.setOrderT("AA:hello");


    }

    @Test
    public void test2(){
        SubOrder subOrder = new SubOrder();
        //子类继承带泛型的父类Order时，指明了泛型类型为Integer，则实例化子类对象时，不再需要泛型类型
        subOrder.setOrderId(1122);
    }

    @Test
    public void test3(){

        ArrayList<String> list = null;
        ArrayList<Integer> list1 = new ArrayList<>();
        //泛型指不同的引用不能互相赋值
        //异常类不能是泛型

    }

    @Test
    public void test4(){
        Order<String> order = new Order<>();
        Integer[] arr = new Integer[]{1,2,3,4};
        List<Integer> integers = order.copyFromArrayToList(arr);
        System.out.println(integers);
    }
}
