package class02forExit;

public class Code01_ReverseList {

    public static class Node{
        public int value;
        public Node next;
        public Node(int data){
            this.value=data;
        }
    }

    public  class DoubleNode{
        public int value;
        public DoubleNode last;
        public DoubleNode next;
        public DoubleNode(int data){
            this.value=data;
        }
    }
    //反转单向链表
    public Node ReverseNode(Node head){
        //头结点
        Node pre=null;
        //下一个
        Node next=null;
        while(head!=null){
            next=head.next;
            head.next=pre;
            pre=head;
            head=next;
        }
       /* Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;*/
       return pre;
    }
    //反转双链表
    public DoubleNode ReverseDoubleNode(DoubleNode head){
        //头结点
        DoubleNode pre=null;
        //下一个
        DoubleNode next=null;
        while(head!=null){
            next=head.next;
            head.last=next;
            head.next=pre;
            pre=head;
            head=next;
        }
        return pre;
    }


}
