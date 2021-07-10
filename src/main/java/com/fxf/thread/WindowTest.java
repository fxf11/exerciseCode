package com.fxf.thread;


import java.awt.*;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO 使用同步代码块synchronized解决线程安全问题
 * @date 2021/7/10 16:51
 */
public class WindowTest{
//    private static int ticket = 100;
//
//    private static Object obj = new Object();

    private static int ticket = 100;
    private static Object obj = new Object();


    Thread thread = new Thread(() -> {
        while (true) {
            synchronized (obj) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "：买票，票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    });

    public static void main(String[] args) {

//        Thread thread4 = new Thread();
//        Thread thread5 = new Thread();
//        Thread thread6 = new Thread();
//
//        thread4.setName("窗口1");
//        thread5.setName("窗口1");
//        thread6.setName("窗口1");
//
//        thread4.start();
//        thread5.start();
//        thread6.start();

        Windows windows = new Windows();
        Windows windows1 = new Windows();
        Windows windows2 = new Windows();

        windows.thread.setName("窗口1");
        windows1.thread.setName("窗口2");
        windows2.thread.setName("窗口3");

        windows.thread.start();
        windows1.thread.start();
        windows2.thread.start();
//
//        Thread thread1 = new Thread(windows);
//        Thread thread2 = new Thread(windows);
//        Thread thread3 = new Thread(windows);
//
//        thread1.setName("窗口1");
//        thread2.setName("窗口2");
//        thread3.setName("窗口3");
//
//        thread1.start();
//        thread2.start();
//        thread3.start();
    }
}
class Windows{

    private static int ticket = 100;
    private static Object obj = new Object();


    Thread thread = new Thread(() -> {
        while (true) {
            synchronized (obj) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "：买票，票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    });
}
//class Windows extends Thread {
//
//    private static int ticket = 100;
//
//    private static Object obj = new Object();
//    @Override
//    public void run(){
//        while (true){
//            synchronized(obj){
//                if (ticket > 0){
//                    try {
//                        Thread.sleep(100);
//                    }catch (InterruptedException e){
//                        e.printStackTrace();
//                    }
//                    System.out.println(Thread.currentThread().getName()+ "：买票，票号为："+ticket);
//                    ticket--;
//                }else {
//                    break;
//                }
//            }
//        }
//    }
//}

