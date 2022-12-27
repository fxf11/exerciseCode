package com.fxf.concureent.JUCpackage;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntUnaryOperator;

/**
 * @Classname Test1
 * @Description TODO
 * @Version 1.0.0
 * @Date 2022/1/23 21:59
 * @Created by 饭小范
 */
public class Test1 {

    public static void main(String[] args) {
        AtomicInteger i = new AtomicInteger(6);

        updateAndGet(i,p->p/2);

        System.out.println(i.get());
    }

    public static void updateAndGet(AtomicInteger i, IntUnaryOperator operator){
        while (true){
            int prev = i.get();
            int next = operator.applyAsInt(prev);
            if (i.compareAndSet(prev,next)){
                break;
            }
        }
    }
}
