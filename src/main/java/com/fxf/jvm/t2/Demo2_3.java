package com.fxf.jvm.t2;


import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO 演示软引用
 * -Xmx20m -XX:+PrintGCDetails -verbose:gc
 *
 * @date 2021/6/30 21:59
 */
public class Demo2_3 {

    private static final int _4MB = 4 * 1024 * 1024;

    //强引用会因为堆内存不足无法启动
    public static void main(String[] args) throws IOException {

//        ArrayList<byte[]> list = new ArrayList<>();
//
//        for (int i = 0; i < 5; i++) {
//            list.add(new byte[_4MB]);
//        }
//        System.in.read();
        soft();
    }

    //软引用，当堆内存空间不足时，会回收来释放内存空间
    public static void soft(){
        //list ---> SoftReference ---> byte[] list先引用了软引用对象SoftReference，软引用对象SoftReference再间接引用byte
        List<SoftReference<byte[]>> list = new ArrayList<>();

        //引用队列
        ReferenceQueue<byte[]> queue = new ReferenceQueue<>();

        for (int i = 0; i < 5; i++) {
            //引用对象关联引用队列，当软引用所关联的byte[]被回收时，软引用自己会加入到引用队列queue中去
            SoftReference<byte[]> ref = new SoftReference<>(new byte[_4MB],queue);
            System.out.println(ref.get());
            list.add(ref);
            System.out.println(list.size());

        }

        //poll方法就是从队列中获取最先放入队列的元素移除队列
        //从队列中获取无用的软引用对象并移除
        Reference<? extends byte[]> poll = queue.poll();
        while (poll != null){
            list.remove(poll);
            poll = queue.poll();

        }


        System.out.println("循环结束：" + list.stream());

        //这时会发现
        for (SoftReference<byte[]> softReference : list) {
            System.out.println(softReference.get());
        }
    }
}
