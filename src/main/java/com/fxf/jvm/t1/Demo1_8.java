package com.fxf.jvm.t1;

import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.Opcodes;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO 演示元空间内存溢出  java.lang.OutOfMemoryError: Metaspace
 * -XX:MaxMetaspaceSize=8m
 * @date 2021/6/27 22:21
 */
public class Demo1_8 extends ClassLoader {//可以用来加载类的二进制字节码

    public static void main(String[] args) {
        int j = 0;
        try {
            Demo1_8 test = new Demo1_8();
            for (int i = 0; i < 10000; i++,j++) {
                //ClassWriter作用是生成类的二进制字节码
                ClassWriter cw = new ClassWriter(0);
                //版本号，类的权限修饰符，类名，包名，父类，实现的接口
                cw.visit(Opcodes.V1_8,Opcodes.ACC_PUBLIC,"Class" + i,null,"java/lang/Object",null);
                //返回byte[]
                byte[] code = cw.toByteArray();
                //执行了类的加载
                //Class对象
                test.defineClass("Class" + i,code,0,code.length);
            }
        }finally {
            System.out.println(j);
        }
    }

}
