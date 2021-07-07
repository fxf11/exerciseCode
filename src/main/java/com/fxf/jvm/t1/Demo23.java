package com.fxf.jvm.t1;



/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO
 * @date 2021/6/28 21:37
 */
public class Demo23 {

    //串池["a","b"]
    public static void main(String[] args) {
        String x = "ab";//串池["ab"]
        String s = new String("a") + new String("b");//new String("ab")串池：["ab","a","b"]

        //堆 String a = new String("a"); new String("a") new String("ab")
        String s2 = s.intern();//将这个字符串对象尝试放入串池，如果有则不会放入，如果没有则放入串池，会把串池中的对象放回
        System.out.println(s2 == x);//s2是串池中的对象,x也是串池的中的对象
        System.out.println(s == x);//s是堆中的创建出来的
    }
}
