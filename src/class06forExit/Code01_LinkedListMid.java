package class06forExit;


/**
 * 链表问题，快慢指针的使用
 * */
public class Code01_LinkedListMid {

    public static class Node{
        public int value;
        public Node next;

        public Node(int value) {
            this.value=value;
        }
    }
    //返回链表的上中点的值
    public static Node midOrUpMidNode(Node head){
        //至少有三个节点
        if(head==null|| head.next==null || head.next.next==null) return null;

        Node lest=head.next;
        Node fast=head.next.next;
        //当下面的值能够满足 快慢指针能跳一次
        while(fast.next==null &&fast.next.next!=null){
            lest=head.next;
            fast=head.next.next;
        }
        return lest;
    }

    //返回链表的下中点的值
    public static Node midOrDownMidNode(Node head){
        //至少有三个节点
        if(head==null|| head.next==null || head.next.next==null) return null;

        Node lest=head.next;
        Node fast=head.next;
        //当下面的值能够满足 快慢指针能跳一次
        while(fast.next==null &&fast.next.next!=null){
            lest=head.next;
            fast=head.next.next;
        }
        return lest;
    }


}
