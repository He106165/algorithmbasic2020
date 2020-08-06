package class02forExit;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//利用双向链表  做  栈 队列
public class Code03_DoubleEndsQueueToStackAndQueue {
    public static  class  Node<T>{
        public T value;
        public Node<T> last;
        public Node<T> next;
        public Node(T data){
            value=data;
        }
    }
    public static  class DoubleEndsQueue<T>{
        public Node<T> head;
        public Node<T> tail;

        //从头开始加
        public void addFromHead(T value){
            Node<T> curr=new Node<T>(value);
            if (head == null) {
                head=curr;
                tail=curr;
            }else{
                curr.next=head;
                head.last=curr;
                head=curr;
            }
        }

        //从尾巴开始加
        public void addFormButtom(T value){
            Node<T> curr=new Node<>(value);
            if (head == null) {
                head=curr;
                tail=curr;
            }else{

                curr.last=tail;
                tail.next=curr;
                tail=curr;
            }
        }
        //从头开始弹出
        public T pollFormHead(){
            if(head==null) return null;

            Node<T> rets=head;
            //判断是否就剩下一个了
            if(head==tail){
                head=null;
                tail=null;
            }else{
                head=head.next;
                //释放引用
                rets.next=null;
                //释放引用
                head.last=null;

            }
            return rets.value;
        }

        //从尾部弹出
       public T pollFormButtom(){
            if(head==null) return null;
            Node<T> rets=tail;
            //判断是否就剩下一个了
            if(head==tail){
                head=null;
                tail=null;
            }else{
                tail = tail.last;
                //释放引用
                tail.next=null;
                rets.last=null;
            }
            return rets.value;
        }



        public boolean isEmpty(){
            return head==null;
        }
    }
    //栈
    public static class MyStack<T>{
        private DoubleEndsQueue<T>  queue;

        public MyStack(){
            queue=new DoubleEndsQueue<>();
        }
        public void push(T value){

            queue.addFromHead(value);
        }
        public  T pop(){
            return queue.pollFormHead();
        }
        public boolean isEmpty(){
            return  queue.isEmpty();
        }
    }
    //队列
    public static class MyQueue<T> {
        private DoubleEndsQueue<T> queue;

        public MyQueue() {
            queue = new DoubleEndsQueue<>();
        }
        public void push(T value) {
            queue.addFromHead(value);
        }

        public T poll() {
            return queue.pollFormButtom();
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }
    }
    public static boolean isEqual(Integer o1, Integer o2) {
        if (o1 == null && o2 != null) {
            return false;
        }
        if (o1 != null && o2 == null) {
            return false;
        }
        if (o1 == null && o2 == null) {
            return true;
        }
        return o1.equals(o2);
    }

    public static void main(String[] args) {
        int oneTestDataNum = 100;
        int value = 10000;
        int testTimes = 100000;
        for (int i = 0; i < testTimes; i++) {
            MyStack<Integer> myStack = new MyStack<>();
            MyQueue<Integer> myQueue = new MyQueue<>();
            Stack<Integer> stack = new Stack<>();
            Queue<Integer> queue = new LinkedList<>();
            for (int j = 0; j < oneTestDataNum; j++) {
                int nums = (int) (Math.random() * value);
                if (stack.isEmpty()) {
                    myStack.push(nums);
                    stack.push(nums);
                } else {
                    if (Math.random() < 0.5) {
                        myStack.push(nums);
                        stack.push(nums);
                    } else {
                        if (!isEqual(myStack.pop(), stack.pop())) {
                            System.out.println("oopsmmmm!");
                        }
                    }
                }
                int numq = (int) (Math.random() * value);
                if (stack.isEmpty()) {
                    myQueue.push(numq);
                    queue.offer(numq);
                } else {
                    if (Math.random() < 0.5) {
                        myQueue.push(numq);
                        queue.offer(numq);
                    } else {
                        if (!isEqual(myQueue.poll(), queue.poll())) {
                            System.out.println("oopsssss!");
                        }
                    }
                }
            }
        }
        System.out.println("finish!");
    }
}
