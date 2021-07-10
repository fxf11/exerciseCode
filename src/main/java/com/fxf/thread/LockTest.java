package com.fxf.thread;


import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO 解决线程安全的方式三：Lock锁 --- JDK5.0新增
 * @date 2021/7/10 22:58
 */
public class LockTest {

    public static void main(String[] args) {
        Window w = new Window();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();

    }
}
class Window implements Runnable{
    private int ticket = 100;
    /**
     * 实例化Lock锁
     */
    private ReentrantLock lock = new ReentrantLock(true);
    @Override
    public void run() {
        while (true){
            lock.lock();
            try {
                //调用锁定方法lock();
                if (ticket > 0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"：售票，票号为" + ticket);
                    ticket--;
                }else {
                    break;
                }
            }finally {
                lock.unlock();
            }
        }
    }
}

