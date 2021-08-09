package com.fxf.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Description TODO
 * @Author Administrator
 * @Date 2021/8/9 15:44
 * @Version 1.0
 */
public class ArraycopyTest {

    public static void main(String[] args) {


        int[] a = new int[10];
        a[0] = 0;
        a[1] = 1;
        a[2] = 2;
        a[3] = 3;
        System.arraycopy(a, 2, a, 3, 3);
        a[2] = 99;
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }

        System.out.println();

        int[] b = new int[3];
        b[0] = 0;
        b[1] = 1;
        b[2] = 2;
        //使用 Arrays.copyOf()方法主要是为了给原有数组扩容，测试代码如下：
        int[] c = Arrays.copyOf(b, 10);
        System.out.println("c.length:"+c.length);
        for (int i = 0; i < 10; i++) {
            System.out.print(c[i]+" ");
        }
    }

    @Test
    public void EnsureCapacityTest(){
        ArrayList<Object> list = new ArrayList<Object>();
        final int N = 10000000;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            list.add(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("使用ensureCapacity方法前："+(endTime - startTime));

        ArrayList<Object> list1 = new ArrayList<Object>();
        final int N1 = 10000000;
        list1 = new ArrayList<Object>();
        long startTime1 = System.currentTimeMillis();
        list1.ensureCapacity(N1);
        for (int i = 0; i < N1; i++) {
            list.add(i);
        }
        long endTime1 = System.currentTimeMillis();
        System.out.println("使用ensureCapacity方法后："+(endTime1 - startTime1));
    }

}
