package com.fxf.generic;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO 泛型的使用
 * @date 2021/7/25 23:55
 */
public class GenericTest {

    @Test
    public void test1(){
        Map<String, Integer> map = new HashMap<>(16);
        map.put("TOM",30);
        map.put("jerry",50);
        map.put("jack",96);


        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry);
        }
    }
}
