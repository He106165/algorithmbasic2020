package class02forExit;

public class Code02_DeleteGivenValue {

    public class Node{
        public int value;
        public Node next;
        public Node(int data){
            this.value=data;
        }
    }

    public Node DeleteGivenValue(Node head,int num){
        //过滤链表 前几个需要删除的元素，让head 来到第一个不需要删除的位置
        while (head!=null){
            if(head.value!=num){
                break;
            }
            head=head.next;
        }
        Node pre=head;
        Node curr=head;
        while (curr!=null){
            if(pre.value==num){

            }

            curr=curr.next;
        }

        return  null;
    }
}
