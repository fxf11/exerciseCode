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

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        SingleLinkedList singleLinkedList2 = new SingleLinkedList();

        //进行测试
        //先创建节点
        HeroNode heroNode = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode1 = new HeroNode(2, "宋江1", "及时雨1");
        HeroNode heroNode2 = new HeroNode(3, "宋江2", "及时雨2");
        HeroNode heroNode4 = new HeroNode(4, "宋江3", "及时雨3");
        HeroNode heroNode5 = new HeroNode(5, "宋江5", "及时雨3");
        HeroNode heroNode6 = new HeroNode(6, "宋江6", "及时雨3");
        HeroNode heroNode7 = new HeroNode(7, "宋江7", "及时雨3");
        HeroNode heroNode8 = new HeroNode(8, "宋江8", "及时雨3");
        singleLinkedList.addByOrder(heroNode);
        singleLinkedList.addByOrder(heroNode4);
        singleLinkedList.addByOrder(heroNode6);
        singleLinkedList.addByOrder(heroNode7);
        singleLinkedList2.addByOrder(heroNode1);
        singleLinkedList2.addByOrder(heroNode2);
        singleLinkedList2.addByOrder(heroNode5);

        singleLinkedList2.addByOrder(heroNode8);

        singleLinkedList.list();
        System.out.println("--------------");
        singleLinkedList2.list();
        System.out.println("=======");

//        reverseList(singleLinkedList.getHead());
        SingleLinkedList singleLinkedList1 = mergeList(singleLinkedList.getHead(), singleLinkedList2.getHead());
        singleLinkedList1.list();
//        singleLinkedList.list();
    }

    public static void reverseList(HeroNode head){
        if (head.next != null){
            reverseList(head.next);
        }
        System.out.println(head);


    }

    /**
     * 链表合并
     * @param head1
     * @param head2
     * @return
     */
    public static SingleLinkedList mergeList(HeroNode head1,HeroNode head2){
        SingleLinkedList result = new SingleLinkedList();
        HeroNode resultHead = result.getHead();
        if (head1.next == null && head2.next == null){
            return result;
        }
        if (head1.next == null){
            resultHead.next = head2.next;
        }else if (head2 == null){
            resultHead.next = head1.next;
        }else {
            resultHead.next = head1.next;
            //遍历head2
            HeroNode temp =  head2.next;
            while (true){
                if (temp == null) {
                    break;
                }
                HeroNode cur = temp;
                temp = temp.next;
                result.addByOrder(cur);
            }
        }
        return result;
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

        //将最后一个节点的next指向新的节点
        temp.next = heroNode;
    }

    //按顺序插入节点，根据排名插入指定节点
    public void addByOrder(HeroNode heroNode){
        HeroNode temp = head;
        boolean flag = false;
        while (true){
            if (temp.next == null){
                break;
            }
            if (temp.next.no > heroNode.no){
                break;
            }else if (temp.next.no == head.no){
                flag = true;
                break;
            }
            temp = temp.next;//后移遍历
        }
        if (!flag){
            heroNode.next = temp.next;
            //当前编号的节点已经存在
            temp.next = heroNode;
        }
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

            System.out.println(temp.toString());
            temp = temp.next;
        }
    }


    /**
     * 链表反转
     * @param head
     */
    public static void reverse(HeroNode head){
        if (head.next == null ||head.next.next == null){
            return;
        }
        HeroNode reverseHead = new HeroNode(0,"","");
        HeroNode cur = head.next;
        HeroNode next = null;//指向当前节点的下一个节点
        while (cur != null){
            next = cur.next; //保存当前节点的下一个节点
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = next;
        }


    }

    public HeroNode getHead() {
        return head;
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

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +

                '}';
    }
}
