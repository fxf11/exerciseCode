//package com.fxf.concureent;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.function.BiConsumer;
//import java.util.function.Supplier;
//
///**
// * @Classname TestHashMap
// * @Description TODO
// * @Version 1.0.0
// * @Date 2022/5/22 16:32
// * @Created by 饭小范
// */
//public class TestHashMap {
//
//    public static HashMap map = new HashMap();
//
//
//
//
//    public static void main(String[] args) {
////        demo(
////                ()-> new ConcurrentHashMap<>(),
////                (map,words) -> {
////                    for (String word : words) {
////
////                    }
////                }
////        );
//        System.out.println("长度为16时，桶下标为1的key");
//        for (int i = 0; i < 64; i++) {
//            if (hash(i) % 16 == 1) {
//                System.out.println(i);
//            }
//        }
//        System.out.println("长度为32时，桶下标为1的key");
//        for (int i = 0; i < 64; i++) {
//            if (hash(i) % 32 == 1) {
//                System.out.println(i);
//            }
//        }
//        // 1, 35, 16, 50 当大小为16时，它们在一个桶内
//        final HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
//        // 放 12 个元素
//        map.put(2, null);
//        map.put(3, null);
//        map.put(4, null);
//        map.put(5, null);
//        map.put(6, null);
//        map.put(7, null);
//        map.put(8, null);
//        map.put(9, null);
//        map.put(10, null);
//        map.put(16, null);
//        map.put(35, null);
//        map.put(1, null);
//        System.out.println("扩容前大小[main]:"+map.size());
//        new Thread() {
//            @Override
//            public void run() {
//                // 放第 13 个元素, 发生扩容
//                map.put(50, null);
//                System.out.println("扩容后大小[Thread-0]:"+map.size());
//            }
//        }.start();
//        new Thread() {
//            @Override
//            public void run() {
//                // 放第 13 个元素, 发生扩容
//                map.put(50, null);
//                System.out.println("扩容后大小[Thread-1]:"+map.size());
//            }
//        }.start();
//    }
//    final static int hash(Object k) {
//        int h = 0;
//        if (0 != h && k instanceof String) {
//            return sun.misc.Hashing.stringHash32((String) k);
//        }
//        h ^= k.hashCode();
//        h ^= (h >>> 20) ^ (h >>> 12);
//        return h ^ (h >>> 7) ^ (h >>> 4);
//    }
//
//    public static <V> void demo(Supplier<Map<String,V>> supplier, BiConsumer<Map<String,V>, List<String>> consumer){}
//}
