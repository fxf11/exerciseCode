package com.fxf.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO
 * @date 2021/7/19 23:21
 */
public class SubList {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("t1");
        list.add("t2");
        list.add("t3");


        //这样的话做添加操作实际上还是会影响到list集合
//        List<String> list1 = list.subList(0, 1);
        List<String> list1 = new ArrayList<>(list.subList(0, 1));
        //这样就好了
        list1.add("t4");

        for (String s : list) {
            System.out.print(s+",");
        }
        System.out.println("----------");
        for (String s : list1) {
            System.out.print(s+",");
        }
    }
}
