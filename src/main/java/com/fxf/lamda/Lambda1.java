package com.fxf.lamda;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO 函数引用
 * @date 2021/6/20 22:01
 */
public class Lambda1 {

    private static interface Calculate{
        int calculate(int a,int b);
    }

    public static void main(String[] args) {
//        Calculate calculate = (x,y) -> calculate(x,y);
//        System.out.println(calculate.calculate(10,20));

        //引用一个静态方法
//        Calculate calculate = Lambda1::calculate;
//        System.out.println(calculate.calculate(10,20) );

        //引用一个非静态方法
        Calculate calculate = new Lambda1()::calculate2;
        System.out.println(calculate.calculate(10,20));;
    }

    private int calculate2(int a, int b){
        if (a != b){
            return a - b;
        }
        return a + b;
    }

    private static int calculate(int x,int y){
        if (x > y){
            return x - y;
        }else if (x < y){
            return y - x;
        }
        return x + y;
    }

}
