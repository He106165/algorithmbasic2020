package class06forExit;


import java.util.Stack;

/**
 * 快慢指针的使用    链表是否是回文链表
 * */
public class Code02_IsPalindromList {

    //整个一个单向链表
    public static class  Node{
        public int value;
        public Node next;
        public Node(int value){
            this.value=value;
        }
    }

    //使用栈来判断是否是回文链表  ，需要申请额外的空间
    public static boolean isPalindromByStack( Node head){
        if(head ==null || head.next == null ){
            return false;
        }
        Node curr=head;
        Stack<Node> stack=new Stack<Node>();
        while (curr!=null){
            stack.push(curr);
            curr=curr.next;
        }
        //不能去判断stack ，stack一直不为空
        while (head!=null){
            if(stack.pop().value !=head.value ){
                return false;
            }
            head=head.next;
        }
        return true;

    }


    public static void main(String[] args){
        Node node=new  Node(2);
        node.next=new Node(2);
        System.out.println(isPalindromByStack(node));


    }
}
