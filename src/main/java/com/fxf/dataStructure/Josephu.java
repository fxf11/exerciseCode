package com.fxf.dataStructure;

/**
 * @Classname Josephu
 * @Description TODO
 * @Version 1.0.0
 * @Date 2023/1/8 14:26
 * @Created by 饭小范
 */
public class Josephu {


    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.showBoy();

    }

}

class CircleSingleLinkedList{

    private Boy first = new Boy(-1);

    //添加节点构建环形链表
    public void addBoy(int nums){

        if (nums < 1){
            return;
        }

        Boy curBoy = null;

        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            if (i == 1){
                first = boy;
                first.setNext(first);
                curBoy = first;
            }else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    //遍历环形链表
    public void showBoy(){

        if (first == null){
            return;
        }
        Boy curBoy = first;
        while (true){
            System.out.println(curBoy.toString());
            if (curBoy.getNext() == first){
                break;
            }
            curBoy = curBoy.getNext();

        }

    }


}

class Boy{

    private int no;

    private Boy next;

    public Boy(int no){
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "no=" + no +
                '}';
    }
}

