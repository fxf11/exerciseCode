package com.fxf.commonlyUsedClass;

import org.junit.Test;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO 关于StringBuffer和StringBuilder的使用
 * @date 2021/7/14 21:54
 */
public class StringBufferBuilderTest {


    /**
     * StringBuffer和StringBuilder长度可变，底层char[]没有final修饰，可以使用append追加拼接，默认长度为16，当追加后的长度超过16会进行扩容，扩容长度为原来的容量*2+2，
     * ，扩容是建立一个长度为原数组长度*2+2的新数组，然后会把原数组的元素复制到新的数组中，当append追加的长度太长超过了扩容后的长度，会直接使用append追加的字符串长度+原长度作为新数组的长度，
     * 当长度 < 0或者 > 128会抛OutOfMemoryError异常
     */
    @Test
    public void test1(){
        StringBuffer abc = new StringBuffer(3);
        abc.setCharAt(0,'m');
        abc.append('a');
        System.out.println(abc);

        StringBuilder stringBuilder = new StringBuilder(3);
        stringBuilder.append("1");
    }
}
