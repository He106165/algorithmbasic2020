package class03forExit;

import util.utilMethod;

public class Code03_PartitionAndQuickSort {

    public static int partition(int[] arr,int L, int R){
        if(arr==null || L > R) return -1;

        if(L==R) return L;
        int lessEqual=L-1;
        int index=L;
        while(index < R){
            if(arr[index] <= arr[R]){
                utilMethod.swap(arr,index,++lessEqual);

            }
            index++;
        }
        utilMethod.swap(arr,++lessEqual,R);
        return lessEqual;
    }

    public static int[] netherlandsFlag(int[] arr, int L, int R) {
        if(L > R){
            return new int[] {-1,-1};
        }
        if(L == R) {
            return new int[] { L, R };
        }
        //左边界
        int less= L-1;
        //指标
        int index = L;
        //右边界
        int more = R;
        while(index < more){
            if(arr[index] == arr[R]){
                index++;
            }else if(arr[index] < arr[R]){
                utilMethod.swap(arr,index++,++less);
            }else{
                utilMethod.swap(arr,index,--more);
            }
        }
        utilMethod.swap(arr,more,R);
        return new int[] { more+1, R };
    }

    public static  void  quickSort1(int[] arr){

        if(arr==null || arr.length<2) return ;
        process1(arr,0,arr.length-1);
    }

    public static void process1(int[] arr,int L ,int R){
        if(L > R) return ;
        int mid=partition(arr,L,R);
        process1(arr,L,mid-1);
        process1(arr,mid+1,R);
    }

    public static  void  quickSort2(int[] arr){

        if(arr==null || arr.length<2) return ;
        process2(arr,0,arr.length-1);
    }

    public static void process2(int[] arr,int L ,int R){
        if(L > R) return ;
        int[] mid=netherlandsFlag(arr,L,R);
        process1(arr,L,mid[0]-1);
        process1(arr,mid[1]+1,R);
    }



    public static void main(String[] args) {
        int[] arr={1,3,4,6,83,5,42,54,32,67,23,523,23,4523,214124,543256453,6,75};

        /*utilMethod.printArray(netherlandsFlag(arr, 0, arr.length-1));
        utilMethod.printArray(arr);*/

        quickSort1(arr);
        utilMethod.printArray(arr);
    }


}
