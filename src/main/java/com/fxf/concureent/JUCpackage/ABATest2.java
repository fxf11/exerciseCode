package com.fxf.concureent.JUCpackage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import static java.lang.Thread.sleep;

/**
 * @Classname ABATest2
 * @Description TODO
 * @Version 1.0.0
 * @Date 2022/1/24 21:25
 * @Created by 饭小范
 */
public class ABATest2 {


                public static void main(String[] args) throws InterruptedException {
        GarbageBag bag = new GarbageBag("装满了垃圾");
        AtomicMarkableReference<GarbageBag> ref = new AtomicMarkableReference<>(bag, true);

        System.out.println("start...");
        GarbageBag reference = ref.getReference();
        System.out.println(reference.toString());

        new Thread(()->{
            System.out.println("start...");
            bag.setDesc("空垃圾袋");
            System.out.println(ref.getReference().toString());
            ref.compareAndSet(bag,bag,true,false);
            System.out.println(bag.toString());
        },"t3").start();

        sleep(1000);
        System.out.println("想换新垃圾袋？");
        boolean success = ref.compareAndSet(reference, new GarbageBag("空垃圾袋"), true, false);
        System.out.println(success);
        System.out.println(ref.getReference().toString());
    }

}

class GarbageBag{
    String desc;

    public GarbageBag(String desc) {
        this.desc = desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "GarbageBag{" +
                "desc='" + desc + '\'' +
                '}';
    }
}
