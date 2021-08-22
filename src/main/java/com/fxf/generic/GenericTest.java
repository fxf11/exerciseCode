package com.fxf.generic;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 泛型可以在编译器进行类型检测
 * 可以使用自限定类型
 * 使用Object类型需要手动添加强制类型转换，容易出错
 *
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

    /**
     *
     *
     * 泛型擦除：Java的泛型是伪泛型,因为Java再编译期间，所有的泛型信息都会被擦掉，编译器会在编译期间动态将泛型T擦除为Object或将T extends xxx擦除为其限定类型xxx
     *
     * 泛型是编译器的性为，减少虚拟机的运行开销
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    @Test
    public void test2() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(12);
//        list.add("a");
        Class<? extends ArrayList> aClass = list.getClass();
        Method add = aClass.getDeclaredMethod("add", Object.class);
        add.invoke(list,"vv");
        System.out.println(list);
    }
}
