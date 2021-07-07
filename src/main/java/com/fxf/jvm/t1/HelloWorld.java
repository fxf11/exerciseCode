package com.fxf.jvm.t1;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO
 * @date 2021/6/27 23:15
 */
public class HelloWorld {
    //常量池中的信息，都会被加载到运行时常量池中，这时a,b,ab都是常量池中的符号，还没有变为Java字符串对象，
    // 等到执行到引要到这个字符串时就会把这个符号变为Java字符串对象
    public static void main(String[] args) {

        System.out.println("Hello World");

        String s1 = "a";
        String s2 = "b";
        String s3 = s1+s2;//new StringBuilder().append("a").append("b").toString  new String("ab")
        String s4 = "ab";
        String s5 = "a"+"b";

        System.out.println(s3 == s4);
        System.out.println(s3 == s5);
        System.out.println(s4 == s5);


    }
}
