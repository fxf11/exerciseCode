package com.fxf.dataStructure;

/**
 * @Classname DoubleLinkedListDemo
 * @Description TODO
 * @Version 1.0.0
 * @Date 2023/1/8 12:45
 * @Created by 饭小范
 */
public class DoubleLinkedListDemo {
}


class DoubleLinkedList{

    //初始化头节点,不存放具体的数据
    private HeroNode2 head = new HeroNode2(0,"","");


    public HeroNode2 getHead() {
        return head;
    }


    public void add(HeroNode2 heroNode){
        HeroNode2 temp = head;
        //遍历链表找到最后一个节点
        while (true){
            if (temp.next == null){
                break;
            }
            temp = temp.next;
        }

        //将最后一个节点的next指向新的节点
        temp.next = heroNode;
    }


    public void del(int no){

        if (head.next == null){
            System.out.println("链表为空，无法删除");
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag = false;
        while (true){
            if (temp == null){
                break;
            }
            //找到需要待删除的前一个节点
            if (temp.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
       if (flag){
           temp.pre.next = temp.next;
           temp.next.pre = temp.pre;
       }

    }
}


class HeroNode2{

    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next; //指向下一个节点
    public HeroNode2 pre; //指向下一个节点


    public HeroNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }



    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +

                '}';
    }
}
