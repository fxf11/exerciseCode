package com.fxf.jvm.t1;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO 死锁
 * @date 2021/6/25 21:59
 */
class A{}
class B{}
public class Demo1_3 {

    static A a = new A();
    static B b = new B();

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            synchronized (a){
                try {
                    Thread.sleep(2000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                synchronized (b){
                    System.out.println("我获得了a和b");
                }
            }
        }).start();

        Thread.sleep(1000);
        new Thread(() -> {
            synchronized (b){
                synchronized (a){
                    System.out.println("我获得了a和b");
                }
            }

        }).start();
    }


}
