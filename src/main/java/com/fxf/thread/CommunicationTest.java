package com.fxf.thread;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO 线程通信的例子：使用两个线程打印1-100.线程1，线程2交替打印
 * @date 2021/7/11 14:54
 */
public class CommunicationTest {
    public static void main(String[] args) {

        Number number = new Number();

        Thread thread = new Thread(number);
        Thread thread1 = new Thread(number);

        thread.setName("线程1");
        thread1.setName("线程2");

        thread.start();
        thread1.start();

    }
}

class Number implements Runnable{

    private int number = 1;

    @Override
    public void run() {
        while(true){
            synchronized (this){
                //唤醒阻塞的线程
                notify();
                if (number <= 100){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    number++;
                    try {
                        //使调用wait()方法的线程进入阻塞状态
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    break;
                }
            }
        }
    }
}
