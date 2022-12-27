package com.fxf.jvm.t1;

//import sun.misc.Unsafe;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO
 * @date 2021/6/29 22:00
 */
//public class Demo1_27 {
//
//    static int _1GB = 1024 * 1024 * 1024;
//
//    public static void main(String[] args) throws IOException {
//        Unsafe unsafe = getUnsafe();
//        long base = unsafe.allocateMemory(_1GB);
//        unsafe.setMemory(base,_1GB,(byte) 0);
//        System.in.read();
//
//        unsafe.freeMemory(base);
//        System.in.read();
//    }
//
//    public static Unsafe getUnsafe(){
//        try {
//            Field f = Unsafe.class.getDeclaredField("theUnsafe");
//            f.setAccessible(true);
//            Unsafe unsafe = (Unsafe) f.get(null);
//            return unsafe;
//        }catch (NoSuchFieldException | IllegalAccessException e){
//            throw new RuntimeException(e);
//        }
//    }
//}
