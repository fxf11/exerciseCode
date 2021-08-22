package com.fxf.test;

import org.junit.Test;

/**
 *
 * 装箱：自动根据数值创建对应得Integer类型
 * 拆箱：自动将包装器类型转换为基本数据类型
 *
 * @author 饭小范
 * @version 1.0
 * @description: TODO 深入剖析Java中的装箱和拆箱
 * @date 2021/8/1 0:11
 */
public class IntegerBinning {


    /**
     * 装箱 在装箱得过程中，自动调用得是Integer的Valueof(int)方法   其他类型也一样
     */
    Integer i = 10;

    /**
     * 拆箱 在拆箱的过程中，自动调用的是Integer的IntValue方法    其他类型也一样
     */
    int n = i;

    public static void main(String[] args) {

        Integer i1 = 100;
        Integer i2 = 100;
        Integer i3 = 200;
        Integer i4 = 200;

        /**
         *
         *  if (i >= IntegerCache.low （-128）&& i <= IntegerCache.high（127）)
         *             return IntegerCache.cache[i + (-IntegerCache.low)];
         *         return new Integer(i);
         *
         * 这是因为通过valueOf创建Integer对象的时候，如果数值在-128到127之间，
         * 便会返回IntegerCache.cache中已经存在的对象的引用，否则则会创建一个新的Integer对象
         */
        System.out.println(i1==i2);//true  i1和i2指向为同一个对象
        System.out.println(i3==i4);//false i3和i4却不一样

        doubleTest();
    }

    public static void doubleTest(){
        Double i1 = 100.0;
        Double i2 = 100.0;
        Double i3 = 200.0;
        Double i4 = 200.0;

        /**
         *
         * public static Double valueOf(double d) {
         *         return new Double(d);
         *     }
         *
         * 因为在某个范围内的整型数值的个数是有限的，而浮点数却不是。
         * 所以Double类的valueOf方法会采用与Integer类的valueOf方法不同的实现
         */
        System.out.println(i1==i2);//false
        System.out.println(i3==i4);//false
    }

    /**
     * Integer i = new Integer(xxx)和Integer i =xxx区别
     */
    @Test
    public void test(){

        //不触发自动装箱功能
        Integer i1 = new Integer(12);

        //会触发自动装箱功能，执行效率和资源占用的情况一般更优
        Integer i2 = 12;

        System.out.println(i1 == i2);

    }


    /**
     * 当 "=="运算符的两个操作数都是 包装器类型的引用，则是比较指向的是否是同一个对象，
     * 而如果其中有一个操作数是表达式（即包含算术运算）则比较的是数值（即会触发自动拆箱的过程）。
     * 另外，对于包装器类型，equals方法并不会进行类型转换。
     */
    @Test
    public void test1(){

        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        Long h = 2L;

        System.out.println(c==d);//true
        System.out.println(e==f);//false
        /**
         * 由于  a+b包含了算术运算，因此会触发自动拆箱过程（会调用intValue方法），
         * 因此它们比较的是数值是否相等。而对于c.equals(a+b)会先触发自动拆箱过程，
         * 再触发自动装箱过程，也就是说a+b，会先各自调用intValue方法，
         * s得到了加法运算后的数值之后，便调用Integer.valueOf方法，再进行equals比较。
         */
        System.out.println(c==(a+b));//true
        System.out.println(c.equals(a+b));//true
        System.out.println(g==(a+b));//true
        System.out.println(g.equals(a+b));//false  equals方法不会进行类型转换
        System.out.println(g.equals(a+h));//true    //a+h运行过程中会进行类型转换

    }


}
