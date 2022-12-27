package com.fxf.collection;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;

import static sun.misc.Unsafe.getUnsafe;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO
 * @date 2021/8/16 21:27
 */
public class ConcurrentHashMapTest {

    public static void main(String[] args) throws Exception {
//        ConcurrentHashMap concurrentHashMap = null;
//        concurrentHashMap.put("1",1);
//        System.out.println(concurrentHashMap.size());


//        Integer[] arr = {2,5,1,8,10};
//
//        Unsafe unsafe = getUnsafe();
//        //基础偏移量
//        int baseOffset = unsafe.arrayBaseOffset(Integer[].class);
//        //偏移量间隔
//        int indexScale = unsafe.arrayIndexScale(Integer[].class);
//
//        //获取数组中索引为2的元素对象
//        unsafe.getObjectVolatile(arr,(2*indexScale) +baseOffset);
//        //设置数组中索引为2的元素值
//        unsafe.putOrderedObject(arr,(2*indexScale)+baseOffset,100);
//        System.out.println(Arrays.toString(arr));
//
//        new ConcurrentHashMap<>();

        final ConcurrentHashMap chm = new ConcurrentHashMap();

        new Thread(){
            @Override
            public void run() {
                chm.put("通话","11");
                System.out.println("----------------");
            }
        }.start();

        Thread.sleep(1000);

        new Thread(){
            @Override
            public void run() {
                chm.put("重地","11");
                System.out.println("============");
            }
        }.start();


    }

    public static Unsafe getUnsafe() throws Exception {
        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);
        return (Unsafe) theUnsafe.get(null);
    }
}
