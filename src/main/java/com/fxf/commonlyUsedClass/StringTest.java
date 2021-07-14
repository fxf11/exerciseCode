package com.fxf.commonlyUsedClass;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO String 的使用
 * @date 2021/7/13 21:01
 */
public class StringTest {

    /**
     * String 和 char[]之间的转换
     */
    @Test
    public void test2(){
        String str1 = "abc123";
        char[] chars = str1.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);

        }
        String s = new String(chars);
        System.out.println(s);

    }

    /**
     * String和byte[]之间的转换
     */
    @Test
    public void test3(){
        String str1 = "abc123中国";
        byte[] bytes = str1.getBytes();
        System.out.println(Arrays.toString(bytes));

        String s = new String(bytes);
        System.out.println(s);
    }

    /**
     * 常量拼接入串池，变量拼接在堆中，拼接调用intern(),返回值在常量池
     */
    @Test
    public void test4(){
        String s1 = "javaEEhadoop";
        String s2 = "javaEE";
        String s3 = s2 + "hadoop";
        System.out.println(s1 == s3);

        //加了final是一个常量
        final String s4 = "javaEE";
        String s5 = s4 + "hadoop";
        System.out.println(s1 == s5);

    }


    @Test
    public void test1(){
        String str1 = "123";
        Integer.valueOf(str1);

        String str2 = "1234";
        Integer.parseInt(str2);
    }

}
