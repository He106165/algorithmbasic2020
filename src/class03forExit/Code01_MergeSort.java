package class03forExit;

import util.utilMethod;


/**
 * 递归进行排序，思想让左边一半有序，让右边一半有序，然后合并
 * 合并时，定义一个help数组，先按个比较左右俩边谁大，谁大谁先进help数组，之后将剩余的添加到help数组，最后把help数组返回到arr数组中
 * **/
public class Code01_MergeSort {

    public static void MergeSort(int[] arr){
        if(arr==null || arr.length <2) return ;
        process(arr,0,arr.length-1);
    }
    public static void  process(int[] arr,int L,int R){
        if(L == R) return;
        int mid= L+((R -L ) >> 1);
        process(arr,L,mid);
        process(arr,mid+1,R);
        merge(arr,L,mid,R);
    }
    public static void merge(int[] arr,int L,int M,int R) {
        int[] help=new int[R-L+1];
        int i=0;
        int p1=L;
        int p2=M+1;
        while (p1 <= M && p2<=R){
            help[i++]= arr[p1] > arr[p2] ? arr[p1++] : arr[p2++];
        }

        while(p1 <= M){
            help[i++]=arr[p1++];
        }
        while(p2 <= R){
            help[i++]=arr[p2++];
        }
        for (int j = 0; j <help.length ; j++) {
            arr[L+j]=help[j];
        }
    }

    public static void main(String[] args) {
        int[] arr={1,3,4,6,83,5,42,54,32,67,23,523,23,4523,214124,543256453,6,75};
        MergeSort(arr);
        utilMethod.printArray(arr);
    }

}
