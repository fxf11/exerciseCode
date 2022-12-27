package com.fxf.concureent;

import java.util.LinkedList;

import static java.lang.Thread.sleep;

/**
 * @Classname TestMessageQueue
 * @Description TODO
 * @Version 1.0.0
 * @Date 2022/1/13 23:54
 * @Created by 饭小范
 */
public class TestMessageQueue {

    public static void main(String[] args) {

        MessageQueue messageQueue = new MessageQueue(2);
        for (int i = 0; i < 3; i++) {
            int id = 1;
            new Thread(() -> {
                messageQueue.put(new Message(id,"123"));
            },"生产者"+i).start();
        }



        new Thread(()->{
           while (true){
               try {
                   sleep(1000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               Message take = messageQueue.take();
           }

        },"消费者").start();

    }

}

class MessageQueue{

    private LinkedList<Message> list = new LinkedList<>();
    private int capcity;

    public MessageQueue(int capcity) {
        this.capcity = capcity;
    }

    public Message take(){
        synchronized (list){
            while (list.isEmpty()){
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Message message = list.removeFirst();
            list.notifyAll();
            return message;
        }
    }

    public void put(Message message){
        synchronized (list){
            while (list.size() == capcity){
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.addLast(message);
            list.notifyAll();

        }
    }


}

class Message{
    private Integer messId;
    private Object message;

    public Message(Integer messId, Object message) {
        this.messId = messId;
        this.message = message;
    }
}
