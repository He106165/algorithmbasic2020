package class02forExit;

import java.util.Stack;

public class Code05_GetMinStack {

    public static class MyStack1{
        public Stack<Integer> stack;
        public Stack<Integer> stackMin;

        public MyStack1() {
            stack=new Stack<>();
            stackMin=new Stack<>();
        }

        /*public void push(int value){
            if(stack.isEmpty()){
                stackMin.push(value);
            }else if(value < getMin()){
                stackMin.push(value);
            }else{
                int newMin = this.stackMin.peek();
                this.stackMin.push(newMin);
            }
            stack.push(value);
        }*/
        public void push(int newNum){
            if (this.stackMin.isEmpty()) {
                this.stackMin.push(newNum);
            } else if (newNum <= this.getMin()) {
                this.stackMin.push(newNum);
            }
            this.stack.push(newNum);
        }

        public int getMin(){
            if (this.stackMin.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            return this.stackMin.peek();
        }
        public int poll(){
            if(stack.isEmpty()) throw new RuntimeException("栈是空的，你取个锤子哦");

            int ret=stack.pop();
            if(ret==getMin()){
                stackMin.pop();
            }
            return ret;
        }

    }

    public static void main(String[] args) {
        MyStack1 myStack1=new MyStack1();
        myStack1.push(5);
        System.out.println(myStack1.getMin());

        myStack1.push(1);
        System.out.println(myStack1.getMin());

        myStack1.push(4);
        System.out.println(myStack1.getMin());
        myStack1.push(6);
        System.out.println(myStack1.getMin());

        myStack1.push(9);

        System.out.println("1233333");
    }
}
