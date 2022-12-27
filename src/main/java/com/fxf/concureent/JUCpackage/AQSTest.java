package com.fxf.concureent.JUCpackage;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

import static java.lang.Thread.sleep;

/**
 * @Classname AQSTest
 * @Description TODO
 * @Version 1.0.0
 * @Date 2022/2/21 22:18
 * @Created by 饭小范
 */
public class AQSTest {

    public static void main(String[] args) {
        MyLock myLock = new MyLock();
        new Thread(()->{
            myLock.lock();
            myLock.lock();
            try {
                System.out.println("t1加锁成功。。。。。。。。。。");
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("t1解锁成功...........");
                myLock.unlock();
            }
        },"t1").start();
        new Thread(()->{
            myLock.lock();
            try {
                System.out.println("t2加锁成功。。。。。。。。。。");
            }finally {
                System.out.println("t2解锁成功...........");
                myLock.unlock();
            }
        },"t2").start();
    }
}

//自定义锁 不可重入锁
class MyLock implements Lock{

    //独占锁
    class MySync extends AbstractQueuedSynchronizer{

        @Override
        protected boolean tryAcquire(int arg) {
            if (compareAndSetState(0,1)){
                //加上了锁,设置owner为当前线程
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        @Override //是否持有独占锁
        protected boolean isHeldExclusively() {
            return getState()==1;
        }

        public Condition newCondition(){
            return new ConditionObject();
        }
    }

    private MySync sync = new MySync();

    @Override //加锁 不成功就进入等待队列等待
    public void lock() {
        sync.acquire(1);
    }

    //加锁 可打断
    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    //尝试加锁 尝试一次
    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    //尝试加锁 有超时时间
    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireSharedNanos(1,unit.toNanos(time));
    }

    //解锁
    @Override
    public void unlock() {
        sync.release(1);
    }

    //创建条件变量
    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }
}
