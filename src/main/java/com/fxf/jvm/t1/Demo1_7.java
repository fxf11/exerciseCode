package com.fxf.jvm.t1;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO 演示StringTable垃圾回收
 * -Xmx10m -XX:+PrintStringTableStatistics:打印字符串表的信息，可以看到串池中字符串池里的个数   -XX:+PrintGCDetails -verbose:gc 打印垃圾回收的一些详细信息
 * @date 2021/6/29 20:29
 */
public class Demo1_7 {
    public static void main(String[] args) {
        int i = 0;
        try {
            for (int j = 0; j < 10000; j++) {
                String.valueOf(i).intern();
                i++;
            }
        }catch (Throwable e){
            e.printStackTrace();
        }finally {
            System.out.println(i);
        }
    }
}
