package com.fxf.thread;

/**
 * @Description TODO
 * @Author Administrator
 * @Date 2021/8/4 15:56
 * @Version 1.0
 */
public class ThreadSafe extends Thread{


    @Override
    public void run() {

        while (!isInterrupted()){
            try {
                Thread.sleep(5*1000);
            }catch (InterruptedException e){
                e.printStackTrace();
                break;
            }


        }
    }

    public static void main(String[] args) {

        ThreadSafe threadSafe = new ThreadSafe();
        threadSafe.start();
    }
}
