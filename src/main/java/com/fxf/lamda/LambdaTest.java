package com.fxf.lamda;

import java.util.*;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO
 * @date 2021/6/21 21:31
 */
public class LambdaTest {
    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });

        new Thread(() -> System.out.println("Thread run()")).start();

        List<String> list = Arrays.asList("I", "love", "you", "too");

        Collections.sort(list,new Comparator<String>(){
            @Override
            public int compare(String s1,String s2) {
                if(s1 == null)
                    return -1;
                if(s2 == null)
                    return 1;
                return s1.length()-s2.length();

            }
        });

        Collections.sort(list,(s1,s2) -> {
            if(s1 == null)
                return -1;
            if(s2 == null)
                return 1;
            return s1.length()-s2.length();
        });
    }
}
