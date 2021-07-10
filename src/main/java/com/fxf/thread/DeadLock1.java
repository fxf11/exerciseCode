package com.fxf.thread;



/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO
 * @date 2021/7/10 22:34
 */
public class DeadLock1 implements Runnable{

    A a = new A();
    B b = new B();
    public void init(){
        Thread.currentThread().setName("主线程");
        //调用a对象的foo方法
        a.foo(b);
        System.out.println("进入了主线程之后");
    }
    @Override
    public void run(){
        Thread.currentThread().setName("副线程");
        b.bar(a);
        System.out.println("进入了副线程之后");
    }

    public static void main(String[] args) {
        DeadLock1 deadLock1 = new DeadLock1();
        new Thread(deadLock1).start();

        deadLock1.init();

    }
}
class A{
    public synchronized void foo(B b){//同步监视器：A类的对象
        System.out.println("当前线程名：" + Thread.currentThread().getName() + "进入了A实例的foo方法");

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("当前线程名：" + Thread.currentThread().getName() + "企图调用B实例的last方法");
        b.last();
    }
    public synchronized void last(){//同步监视器：A类的对象
        System.out.println("进入了A的last的方法内部");
    }
}
class B{
    public synchronized void bar(A a){
        System.out.println("当前线程名：" + Thread.currentThread().getName() + "进入了B实例的bar方法");

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("当前线程名：" + Thread.currentThread().getName() + "企图调用A实例的last方法");
        a.last();

    }
    public synchronized void last(){//同步监视器B
        System.out.println("进入了B的last的方法内部");
    }
}
