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
    //使用快慢指针和一个栈   来判断是否是回文链表，需要一半的空间
    public static boolean isPalindromByStack2( Node head){
        if(head ==null&&head.next==null){
            return  true;
        }

        Node right=head.next;
        Node curr=head;
        //快慢指针 找到中点的位置
        while(curr.next!=null && curr.next.next!=null){
            curr=curr.next.next;
            right=curr.next;
        }
        //将中点以后的值放到栈里
        Stack<Node> nodes=new Stack<Node>();
        while (right!=null){
            nodes.push(right);
            right=right.next;
        }
        while (!nodes.isEmpty()){
            if(nodes.pop().value !=head.value){
                return false;
            }
            head =head.next;
        }
        return true;
    }


    public  static  boolean  isPalindromByPointer(Node head){
        if(head==null || head.next==null){
            return true;
        }
        //n1标记了中点
        Node n1=head;
        //n2标记了最右边的位置
        Node n2=head;
        while(n2.next!=null && n2.next.next!=null){
            n1=head.next;
            n2=head.next.next;
        }

        //将中点后面的链表翻过来
        n2=n1.next;
        n1.next=null;

        //n3记录了最后一个值
        Node n3=null;
        while (n2!=null){
            n3=n2.next;
            n2.next=n1;
            n1=n2;
            n2=n3;
        }
        n3=n1;
        n2=head;
        boolean res=true;
        //最后链表成这样的了   1-2->3<-2<-1
        while (n1!=null && n2!=null){
            if(n1.value !=n2.value){
                res=false;
                break;
            }
            n1=n1.next;
            n2=n2.next;
        }
        //最后把链表还原
        n1= n3.next;
        n3.next=null;
        while(n1!=null){
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return res;
    }

        public static void main(String[] args){
            Node node=new Node(1);
            node.next=new Node(2);
            node.next=new Node(3);
            node.next=new Node(2);
            node.next=new Node(1);
/*
            System.out.println(isPalindromByStack(node));
            System.out.println(isPalindromByStack2(node));
*/
            System.out.println(isPalindromByPointer(node));


        }
}
