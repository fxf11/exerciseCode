package com.fxf.concureent;

import java.util.concurrent.locks.LockSupport;

/**
 * @Classname Test31
 * @Description TODO
 * @Version 1.0.0
 * @Date 2022/1/16 13:25
 * @Created by 饭小范
 */
public class Test31 {
    static Thread t1;
    static Thread t2;
    static Thread t3;
    public static void main(String[] args) {

        ParkUnpark parkUnpark = new ParkUnpark(5);
        t1 = new Thread(() -> {
            parkUnpark.print("a", t2);
        });

        t2 = new Thread(() -> {
            parkUnpark.print("b", t3);
        });

        t3 = new Thread(() -> {
            parkUnpark.print("c", t1);
        });

        t1.start();
        t2.start();
        t3.start();
        LockSupport.unpark(t1);
    }
}

class ParkUnpark{
    public void print(String str ,Thread next){
        for (int i = 0; i < loopNumber; i++) {
            LockSupport.park();
            System.out.println(str);
            LockSupport.unpark(next);
        }
    }

    private int loopNumber;

    public ParkUnpark(int loopNumber){
        this.loopNumber = loopNumber;
    }
}
