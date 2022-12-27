package com.fxf.dataStructure;

import java.util.Scanner;

/**
 * @Classname CircleArrayQueueDemo
 * @Description TODO 环形队列
 * @Version 1.0.0
 * @Date 2022/12/27 23:04
 * @Created by 饭小范
 */
public class CircleArrayQueueDemo {

    public static void main(String[] args) {
        CircleArrayQueue circleArrayQueue = new CircleArrayQueue(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop){
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列去除数据");
            System.out.println("h(head):查看队列头的数据");
            key = scanner.next().charAt(0);
            switch (key){
                case 's':
                    circleArrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数");
                    int value = scanner.nextInt();
                    circleArrayQueue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = circleArrayQueue.getQueue();
                        System.out.printf("取出的数据是%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = circleArrayQueue.headQueue();
                        System.out.printf("队列头的数据是%d\n",res);
                    }catch (Exception e){
                        e.printStackTrace();
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
    }

}

class CircleArrayQueue{

    private int maxSize;
    private int front;//队列头 执行队列第一个元素
    private int rear;//队列尾 只想队列的最后一个元素的后一个位置
    private int[] arr;//存放数据

    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }


    public void addQueue(int n){
        if (isFull()){
            return;
        }
        arr[rear] = n;
        //将rear后移
        rear = (rear + 1) % maxSize;
    }

    public int getQueue(){
        if (isEmpty()){
            System.out.println("队列为空");
        }
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    public boolean isFull(){
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty(){
        return rear == front;
    }

    public void showQueue(){
        if (isEmpty()){
            System.out.println("队列空的，没有数据~~");
            return;
        }
        for (int i = front; i< front + getSize(); i++){
            System.out.printf("arr[%d]=%d\n",i % maxSize,arr[i % maxSize]);
        }
    }

    public int getSize(){
        return (rear - front + maxSize) % maxSize;
    }

    /**
     * 显示头元素
     * @return
     */
    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列空的，没有数据~~");
        }
        return arr[front];
    }
}
