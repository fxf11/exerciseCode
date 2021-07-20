package com.fxf.collection;

import java.util.ArrayList;

/**
 *
 *  ArrayList:
 *     作为List的主要实现类，但是线程不安全，效率高，底层使用Object[] elementData存储
 *
 *
 *  LinkedList:
 *      对于频繁插入、删除，LinkeList效率会比较高，底层使用双向链表存储
 *
 *
 * @author 饭小范
 * @version 1.0
 * @description: TODO
 * @date 2021/7/20 22:03
 */
public class ListTest {


    public static void main(String[] args) {

        //底层创建了长度是10的Object[] elementData数组
        ArrayList<Object> list = new ArrayList<>();
        //如果此次添加的操作导致底层的elementData数组容量不够
        //则ArrayList底层 会进行扩容，默认扩容为原来的1.5倍
        //具体操作是创建一个长度1.5倍的数组，同时将原有数组的数据copy到新的数组中

        /**
         * new ArrayList()  底层Object[] elementData初始化为{}，并不会直接去创建长度为10的数组
         *
         * jdk1.8在new实例化ArrayList的时候并不会直接去创建数组，
         * 而是给把一个预先定义好的常量赋值给list，减少内存消耗
         *
         * 在list进行add操作时，首先判断list是否等于常量DEFAULTCAPACITY_EMPTY_ELEMENTDATA，
         * 如果等于则说明是第一次进行add，就会去创建一个长度为10的数组
         *
         * jdk1.7中ArrayList的对象的创建类似于单例的饿汉式，而jdk8中的ArrayList的对象的长江见类似于单例的懒汉式，延迟了数组的创建，节省内存
         */
        list.add("123");
    }
}
