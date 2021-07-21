package com.fxf.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO 集合元素的遍历使用Iterator接口 迭代器遍历
 * @date 2021/7/20 21:27
 */
public class IteratorTest {


    @Test
    public void test1(){
        Collection list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("aaa");

        Iterator iterator = list.iterator();

        while (iterator.hasNext()){
            if ("aaa".equals(iterator.next())){
                iterator.remove();
            }
        }

        Iterator iterator1 = list.iterator();
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }

    }
}
