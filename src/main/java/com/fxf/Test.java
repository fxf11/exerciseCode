package com.fxf;



/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO
 * @date 2021/8/7 16:05
 */
public class Test {

    String str = new String("good");
    char[] ch = {'a','b','c'};

    public static void main(String[] args) {
        Test test = new Test();
        test.change(test.str,test.ch);
        System.out.println(test.str+"and");
        System.out.println(test.ch);
    }
    public void change(String str,char ch[]){
//        str = "test ok";
        ch[0] = 'g';
    }
}
