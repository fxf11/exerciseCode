package com.fxf.collection;

import org.junit.Test;

import java.util.*;

/**
 *
 * 一、集合框架的概述
 *
 * 1.集合、数组都是对多个数据惊醒存储操作的结构，简称Java容器。
 *  说明：此时的存储，主要指的是内存层面的存储，不涉及到持久化的存储
 *
 *
 * 集合框架
 *      Collection接口：单列集合，用来存储一个一个的对象
 *          List集合：存储有序的、可重复的数据   ----》动态数组
 *              ArrayList   LinkedList、Vector
 *          Set集合：存储无序的、不可重复的数据
 *              HashSet、LinkedHashSet、TreeSet
 *
 *      Map接口：双列集合、key-value键值对
 *              HashMap、LinkedHashMap、TreeMap、Hashtable、Properties
 *
 *
 * @author 饭小范
 * @version 1.0
 * @description: TODO
 * @date 2021/7/19 21:30
 */
public class CollectionTest {


    @Test
    public void test1(){
        Collection coll = new ArrayList();

        //add()
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(new Date());


        boolean contains = coll.contains(123);
        System.out.println(contains);

        System.out.println(coll.contains(new String("Tom")));

    }
}
