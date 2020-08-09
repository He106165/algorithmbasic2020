package class02forExit;

import java.util.Stack;


/**
 * 用俩个栈构件一个队列
 * */
public class Code06_TwoStacksImplmentQueue {


    public class queue<T>{
        public Stack<T> stackPush;
        public Stack<T> stackpoll;

        public queue(){
            stackPush=new Stack<>();
            stackpoll=new Stack<>();
        }

        private void PushToPoll(){
            if(stackpoll.isEmpty()){
                while(!stackPush.isEmpty()){
                    stackpoll.push(stackPush.pop());
                }
            }
        }

        public void push(T value){
            stackPush.push(value);
            PushToPoll();
        }
        public T poll(){
            if(stackpoll.isEmpty() &&stackPush.isEmpty()) throw  new RuntimeException("沒有東西");
            T ret=stackpoll.pop();
            PushToPoll();
            return ret;
        }

        public T peek(){
            if(stackpoll.isEmpty() &&stackPush.isEmpty()) throw  new RuntimeException("沒有東西");
            T ret=stackpoll.peek();
            PushToPoll();
            return ret;
        }




    }

}
