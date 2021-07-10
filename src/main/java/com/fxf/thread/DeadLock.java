package com.fxf.thread;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO 演示线程的死锁问题
 * 两个线程都持有对方的同步资源不放弃，都在等待对方放弃自己需要的同步资源，此时线程会处于阻塞的状态，无法继续执行下去
 * @date 2021/7/10 22:20
 */
public class DeadLock {

    public static void main(String[] args) {
        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();
        new Thread(() -> {
            //线程1获取s1的锁
            synchronized (s1){
                s1.append("a");
                s2.append("1");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //拿着s1的锁去请求s2的锁
                synchronized (s2){
                    s1.append("b");
                    s2.append("2");

                    System.out.println(s1);
                    System.out.println(s2);
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                //线程2获取s2的锁
                synchronized (s2){
                    s1.append("c");
                    s2.append("3");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //拿着s2的锁去请求s1的锁
                    synchronized (s1){
                        s1.append("d");
                        s2.append("t");

                        System.out.println(s1);
                        System.out.println(s2);
                    }
                }
            }
        }).start();
    }
}
