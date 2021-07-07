package com.fxf.jvm.t2;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO 演示弱引用
 * @date 2021/6/30 22:33
 *
 * -Xmx20m -XX:+PrintGCDetails -verbose:gc
 */
public class Demo2_5 {

    private static final int _4MB = 4 * 1024 * 1024;

    public static void main(String[] args) {

        ArrayList<WeakReference<byte[]>> list = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            WeakReference<byte[]> ref = new WeakReference<>(new byte[_4MB]);
            list.add(ref);
            for (WeakReference<byte[]> w : list) {
                System.out.print(w.get() + " ");
            }
        }
    }
}
