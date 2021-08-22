package com.fxf.test;

import org.junit.Test;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO
 * @date 2021/8/18 0:22
 */
public abstract class MianshiTest {




    @Test
    public void test1(){
        float a= 0.1f;
        double b= 0.12345678901234567890;

        short s1 = 1;
        s1 = (short) (s1+1);
        s1+=1;

        System.out.println(a);
        System.out.println(b);
    }
}
