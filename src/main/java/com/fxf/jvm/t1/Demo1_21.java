package com.fxf.jvm.t1;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO
 * @date 2021/6/28 22:26
 */
public class Demo1_21 {

    public static void main(String[] args) {

        String s1 = "a";//入串池
        String s2 = "b";//入串池
        //常量拼接入串池，变量拼接入堆中
        String s3 = "a" + "b";//ab入串池
        String s4 = s1 + s2;//两个变量的拼接，所以是在运行期间通过StringBuilder来做字符串的拼接 在堆中产生新的字符串 相当于 new String("ab")
        String s5 = "ab";//字面量，首先会检查常量池中的内容，然后发现常量池中有"ab",所以会创建一个新的对象直接引用常量池中已有的对象ab
        String s6 = s4.intern();//因为ab在常量池中已经存在，所以s4未能入池，但是会返回常量池中的ab给s6

        System.out.println(s3 == s4);//s3是常量池中的，s4是堆中的  false
        System.out.println(s3 == s5);//true
        System.out.println(s3 == s6);//true
        String x2 = new String("c") + new String("d");
        x2.intern();
        String x1 = "cd";

        //如果调换了x1，x2的位置就是true,如果是jdk1.6是false
        System.out.println(x1 == x2);//false
    }
}
