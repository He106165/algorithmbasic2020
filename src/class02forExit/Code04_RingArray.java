package class02forExit;

public class Code04_RingArray {
    public static class MyQueue {
        //环形列表
        public int[] data;
        public int pushi;
        public int limit;
        public int size;
        public int polli;
        public  MyQueue(int limit){
            data=new int[limit];
            pushi=0;
            size=0;
            polli=0;
            this.limit=limit;
        }
        public void push(int value){
            if(limit==size)
                throw new RuntimeException("栈满了，不能再加了");
            data[pushi]=value;
            size++;
            pushi=nextIndex(pushi);
        }
        public int poll(){
            if(size==0)
                throw  new RuntimeException("地主家没有余粮了~~~~~");
            size--;
            int res=data[polli];
            polli=nextIndex(polli);
            return res;
        }
        public boolean isEmpty(){
            return size==0;
        }

        public int nextIndex(int i){
            return i<limit-1 ? i:0 ;
        }
    }
}
