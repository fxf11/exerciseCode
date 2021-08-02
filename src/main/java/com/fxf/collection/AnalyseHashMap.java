package com.fxf.collection;

import java.util.HashMap;
import java.util.Map;

/**
 *
 *      HashMap源码常见变量：
 *          DEFAULT_INITIAL_CAPACITY:HashMap的默认容量，16
 *          MAXIMUM_CAPCITY:HashMap的最大支持容量，2^30
 *          TREEIFY_THRESHOLD：BUcket桶中链表长度大于该默认值，转化为红黑树
 *          UNTREEIFY——THRESHOLD：BUCKET中红黑树存储的NODE小于该默认值，转化为链表
 *          MIN_TREEIFY_CAPACITY:桶中NODE被书画时最小的hash表容量
 *
 *          table：存储元素的数组，总是2的n次幂
 *          entrySet：存储具体元素的集
 *          size：hashMap中存储的键值对的数量
 *          modCount：HashMap扩容和结构改变的次数。
 *          threshold：扩容的临界值，=容量*填充因子
 *          loadFactor:填充因子
 *
 *
 * HashMap底层是基于拉链式的散列算法实现的，jdk1.8中则引入了红黑树来优化链表，解决链表过长效率低的问题
 *
 *
 * @author 饭小范
 * @version 1.0
 * @description: TODO HashMap 1.8源码分析
 * @date 2021/8/1 15:05
 */
public class AnalyseHashMap {

    public static void main(String[] args) {
        //java.lang.IllegalArgumentException: Illegal initial capacity: -1
        Map<Object, Object> objectObjectHashMap = new HashMap<>(-1);


    }
}
