package class04forExit;

import util.utilMethod;

import java.util.Vector;

public class Code02_Heap01 {

    public static class MyHeap{
        private int[] data;
        private int heapSize;
        private int limit;

        public MyHeap(int limit){
            this.limit=limit;
            data=new int[limit];
            heapSize=0;
        }
        public void push(int value){
            if(limit==heapSize) throw  new RuntimeException("堆满了");
            data[heapSize]=value;
            heapInsert(data,heapSize++);
        }
        public int pop(){
            if(heapSize==0) throw  new RuntimeException("堆是空的");
            int ret=data[0];

            utilMethod.swap(data,0,--heapSize);

            heapify(data,0,heapSize);
            return ret;
        }
        public boolean isEmpty(){
            return heapSize==0;
        }

        //当堆中添加了一个新值，会添加到末尾上，末尾上浮对比，和自己的父亲比较
        private void heapInsert(int[] arr,int index){
            int hh=(index-1)/2;
            while (arr[index] >arr[hh]){
                utilMethod.swap(arr,index,hh);
                hh=(hh-1)/2;
            }
        }

        //当堆中弹出一个节点，将第一个节点
        private void heapify(int[] arr,int index,int heapSize){
            int left = index*2+1;
            while (left< heapSize){
                int largest= left+1 < heapSize && arr[left+1] >arr[left] ?left+1 :left;
                largest= arr[largest]>arr[index] ?largest : index;
                if(largest == index){
                    break;
                }
                utilMethod.swap(arr,largest,index);
                left=largest*2+1;
            }
        }
    }

    public static void main(String[] args) {
        MyHeap myHeap=new MyHeap(5);
        myHeap.push(2);
        myHeap.push(5);
        myHeap.push(3);

        utilMethod.printArray(myHeap.data);
        System.out.println(myHeap.pop());
        utilMethod.printArray(myHeap.data);
        Vector vector=new Vector();
        vector.add(111);
    }
}
