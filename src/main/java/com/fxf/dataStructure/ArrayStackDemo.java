package com.fxf.dataStructure;

/**
 * @Classname ArrayStackDemo
 * @Description TODO
 * @Version 1.0.0
 * @Date 2023/2/5 13:25
 * @Created by 饭小范
 */
public class ArrayStackDemo {
}

class ArrayStack{

    private int maxSize;

    private int[] stack;

    private int top = -1;


    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
    }


    public boolean isFull(){
        return top == maxSize - 1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    //入栈
    public void push(int value){
        //先判断栈是否已满
        if (isFull()){
            return;
        }
        top++;
        stack[top] = value;
    }

    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("栈空，没有数据");
        }
        int i = stack[top];
        top--;
        return i;
    }

    public void list(){
        if (isEmpty()){
            System.out.println("栈空，没有数据");
        }

        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }

    }
}
