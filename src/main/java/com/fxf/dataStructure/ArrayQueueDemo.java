package com.fxf.dataStructure;

import java.util.Scanner;

/**
 * @Classname ArrayQueueDemo
 * @Description TODO
 * @Version 1.0.0
 * @Date 2022/12/25 18:09
 * @Created by 饭小范
 */
public class ArrayQueueDemo {

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop){
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列去除数据");
            System.out.println("h(head):查看队列头的数据");
        }
    }

}


class ArrayQueue{

    private int maxSize;
    private int front;//队列头
    private int rear;//队列尾
    private int[] arr;//存放数据

    //创建队列的构造器
    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }

    public boolean isFull(){
        return rear == maxSize - 1;
    }

    public boolean isNull(){
        return rear == front;
    }

    public void addQueue(int n){
        if (isFull()){
            return;
        }
        rear++;
        arr[rear] = n;
    }

    public int getQueue(){
        if (isNull()){
            System.out.println("队列为空");
        }
        front++;
        return 0;
    }
}
