package com.fxf.dataStructure;

/**
 * @Classname SingleLinkedList
 * @Description TODO 单向链表实现
 * @Version 1.0.0
 * @Date 2022/12/28 22:52
 * @Created by 饭小范
 */
public class SingleLinkedListDemo {

    public static void main(String[] args) {
        //进行测试
        //先创建节点
        HeroNode heroNode = new HeroNode(1, "宋江", "及时雨");
    }

}

class SingleLinkedList {

    //初始化头节点,不存放具体的数据
    private HeroNode head = new HeroNode(0,"","");

    //添加节点到单向链表
    //找到当前链表的最后节点
    //将最后这个节点的next指向新的节点
    public void add(HeroNode heroNode){
        HeroNode temp = head;
        //遍历链表找到最后一个节点
        while (true){
            if (temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
        //将最后一个节点的next指向新的节点
        temp.next = heroNode;
    }

    //遍历链表
    public void list(){
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while (true){
            if (temp == null){
                break;
            }

            System.out.println(temp);
            temp = temp.next;
        }
    }


}

class HeroNode{

    public int no;
    public String name;
    public String nickname;
    public HeroNode next; //指向下一个节点


    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }
}
