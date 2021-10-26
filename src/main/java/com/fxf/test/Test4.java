package com.fxf.test;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO
 * @date 2021/9/15 23:12
 */
public class Test4 {

    static class a {
        int x = 999;
        int y = 999;
        {
            System.out.println("a--父类非静态方法");
        }
        static {
            System.out.println("a--父类静态方法");
        }
        public a() {
            System.out.println("a--执行a类无参构造方法");
            print();
        }
        public a(int x) {
            System.out.println("a--执行父类有参构造方法");
        }
        public void print() {
            System.out.println("a--我是父类的打印方法");
        }
    }

    static class b extends a {
        int x = 1;
        int y;
        {
            System.out.println("b--子类非静态方法");
        }
        static {
            System.out.println("b--子类静态方法");
        }
        public b() {
            System.out.println("b--执行b类无参构造方法");
            //y = -1;
        }
        public b(int x) {
            System.out.println("b--执行子类有参构造方法");
        }
        public void print() {
            System.out.println("b--在子类中调用父类的super方法");
            super.print();
            System.out.println("b--我是子类的打印方法");
        }
    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int x = 0;
        new b(x);
        //a.print();
    }
}
