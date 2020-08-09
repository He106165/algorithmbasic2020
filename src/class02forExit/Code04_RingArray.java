package class02forExit;


/**
 * 环形数组
 * */
public class Code04_RingArray {

    public static class queue{
        public int[] data;
        public int pushi;
        public int size;
        public int limit;
        public int polli;
        public queue(int limit){
            data=new int[limit];
             int pushi=0;
             int size=0;
             int polli=0;
            this.limit=limit;
        }

        public void push(int value){
            if(size==limit) throw new RuntimeException("满了满了");
            data[pushi]=value;
            size++;
            pushi=nextIndex(pushi);
        }

        public int  poll(){
            int ret=data[polli];
            size--;
            polli=nextIndex(polli);
            return ret;
        }

        public int nextIndex(int i){
            return i < limit-1 ? i+1 : 0;
        }
    }

    public static void main(String[] args) {
        queue queue=new queue(7);
        queue.push(1);
    }
}
