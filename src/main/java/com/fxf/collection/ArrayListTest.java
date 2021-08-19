package com.fxf.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO
 * @date 2021/8/7 18:24
 */
public class ArrayListTest {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(12);
        list.add(23);
        list.add(14);
        list.add(51);
        list.add(56);
        list.add(15);
        list.add(44);
        Collections.sort(list);
        for (Integer integer : list) {
            System.out.println(integer);
        }
        System.out.println();

        List<Integer> list1 = new ArrayList<>();
        list1.add(12);
        list1.add(29);
        list1.add(14);
        list1.add(25);
        list1.add(56);
        list1.add(68);
        list1.add(44);
        //求交集
        list1.retainAll(list);
//        for (Integer i : list1) {
//            System.out.println(i);
//        }

        //无重复并集
//        list.removeAll(list1);
//        list1.addAll(list);
//        for (Integer integer : list1) {
//            System.out.println(integer);
//        }

        //可重复并集：
        list.addAll(list1);
        for (Integer integer : list) {
            System.out.println(integer);
        }

    }

    @Test
    public void arrayRemove(){
        System.out.println("测试remove包装类型和非包装类型");
        ArrayList<Integer> myList = new ArrayList<>();
        for (int k = 0; k < 10; k++) {
            myList.add((k + 1) * 10);
        }

        System.out.println("myList:" + myList);

        //如果ArrayList内装的是Integer对象，则 .remove(8)是删掉下标为8的元素
        System.out.println(String.format("%s:%s myList:%s", "remove(8)", myList.remove(8), myList));

        //将元素80替换为8
        myList.set(myList.indexOf(80), 8);

        Collections.shuffle(myList);

        System.out.println("myList:" + myList);
        // myList.remove(Integer.valueOf(8)) 是删掉8这个元素
        System.out.println(String.format("%s:%s myList:%s", "remove(Integer.valueOf(8))", myList.remove(Integer.valueOf(8)), myList));

    }
}
