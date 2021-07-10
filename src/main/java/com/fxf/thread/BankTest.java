package com.fxf.thread;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO 使用同步机制将单例模式中的懒汉式改写为线程安全的
 * @date 2021/7/10 21:56
 */
public class BankTest {
}

class Bank{
    private Bank(){}

    /**
     * 默认不进行实例化，什么时候用什么时候new
     */
    private static Bank instance = null;

    public static Bank getInstance(){
        //方式一：效率稍差
//        synchronized(Bank.class){
//            if (instance == null){
//                //什么时候用就什么时候new
//                instance = new Bank();
//            }
//            return instance;
//        }
        //方式二
        if (instance == null){
            synchronized(Bank.class){
                if (instance == null){
                    instance = new Bank();
                }
            }
        }
        return instance;
    }
}
