package com.fxf;


import java.lang.reflect.Field;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO
 * @date 2021/8/7 16:05
 */
public class Test {

    String str = new String("good");
    char[] ch = {'a','b','c'};

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Test test = new Test();
        test.change(test.str,test.ch);
        System.out.println(test.str+"and");
        System.out.println(test.ch);

        Integer a = 12; Integer b = 12;
        Integer c = 316; Integer d = 316;
        Class declaredClass = Integer.class.getDeclaredClasses()[0];
        Field cache = declaredClass.getDeclaredField("cache");
        cache.setAccessible(true);

        Integer[] new_cache = (Integer[])cache.get(declaredClass);
        new_cache[130] = new_cache[129];

        Integer res = 1+1;
        System.out.println("1+1="+res);
    }
    public void change(String str,char ch[]){
//        str = "test ok";
        ch[0] = 'g';
    }


}
