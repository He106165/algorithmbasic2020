package class02forExit;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 俩个队列实现一个栈
 * */
public class Code07_TwoQueueImplmentStack {

    public static class MyStack<T> {
        public Queue<T> queue;
        public Queue<T> help;

        public MyStack() {
            queue = new LinkedList<>();
            help = new LinkedList<>();
        }

        public void push(T value) {
            queue.offer(value);
        }

        public T poll(){
            if(queue.isEmpty()) throw new RuntimeException("没东西了");
            while(queue.size()>1){
                help.offer(queue.poll());
            }
            T ret=queue.poll();
            Queue<T> temp=help;
            help=queue;
            queue=temp;
            return ret;

        }

        public T peek(){
            if(queue.isEmpty()) throw new RuntimeException("没东西了");
            while(queue.size()>1){
                help.offer(queue.poll());
            }
            T ret=queue.poll();
            help.offer(ret);
            Queue<T> temp=help;
            help=queue;
            queue=temp;
            return ret;
        }
    }

    public static void main(String[] args) {
        MyStack<Integer> myStack=new MyStack<Integer>();
        myStack.push(2);
        myStack.push(3);
        myStack.push(6);
        System.out.println(myStack.poll());
        System.out.println(myStack.poll());
        System.out.println(myStack.poll());
    }
}
