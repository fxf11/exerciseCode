package com.fxf.jvm.t2;

/**
 * @Description TODO 演示StackOverflowError
 * @Author Administrator
 * @Date 2021/7/20 9:57
 * @Version 1.0
 */
public class JavaVMStackSOF {

    private int stackLength = 1;

    public void stackLeak(){
        stackLength++;
        stackLeak();
    }


    public static void main(String[] args) throws Throwable{
        JavaVMStackSOF javaVMStackSOF = new JavaVMStackSOF();
        try {
            javaVMStackSOF.stackLeak();
        }catch (Throwable e){
            System.out.println("stack length:"+javaVMStackSOF.stackLength);
            throw e;
        }
    }
}
