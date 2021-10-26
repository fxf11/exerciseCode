package com.fxf.test;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO
 * @date 2021/8/30 22:11
 */
public class Tests {

    @Test
    public void test(){
       int i = 9;
        i *= 0.1;
        System.out.println(i);
    }


    @Test
    public void test1(){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            list.add(i);
        }
        Integer s = 4;
        list.remove(s);
        System.out.println(list);
    }

    @Test
    public void test3(){
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
        list.add(1);
        list.add(2);

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            Integer next = iterator.next();
            System.out.println(next);
            if ("1".equals(next)){
                iterator.remove();
            }
        }
        System.out.println(list);
    }

    @Test
    public void test4(){
        Thread t = new Thread(){
            public void run(){
                print();
            }
        };
        t.run();
        System.out.println("2");

    }
    public static void print(){
        System.out.println("1");

    }

    @Test
    public void test5(){
        int key = 1;
        Map<Integer, List<Integer>> map = new HashMap<>();
        map.computeIfAbsent(key,v -> new ArrayList<>()).add(1);
        map.computeIfAbsent(key,v -> new ArrayList<>()).add(1);
        System.out.println(map.get(key));
        map.remove(key);
        map.get(key).add(1);
        System.out.println(map.get(key));
    }

    @Test
    public void test6(){
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            list.add(i);
        }
        for (int i = 0; i < 4; i++) {
            if (list.get(i)>1){
                list.remove(i);
            }
        }
        System.out.println(list);
    }
}
