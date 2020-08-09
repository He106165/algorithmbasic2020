package class03forExit;

import util.utilMethod;

public class Code02_SmallSum {

    public static int MergeSort(int[] arr){
        if(arr==null || arr.length <2) return 0;
       return  process(arr, 0, arr.length - 1);
    }
    public static int   process(int[] arr,int L,int R){
        if(L == R) return 0;
        int mid= L+((R -L ) >> 1);
        return process(arr,L,mid)+
        process(arr,mid+1,R)+
        merge(arr,L,mid,R);
    }
    public static int  merge(int[] arr,int L,int M,int R) {
        int[] help=new int[R-L+1];
        int ann=0;
        int i=0;
        int p1=L;
        int p2=M+1;
        while (p1 <= M && p2<=R){
            ann+=arr[p1] < arr[p2] ? (R- p2 +1)* arr[p1]: 0;
            help[i++]= arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
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
        return ann;
    }

    public static void main(String[] args) {
        int[] arr={1,3,4,6,83,5,42,54,32,67,23,523,23,4523,214124,543256453,6,75};
        System.out.println(MergeSort(arr));
        utilMethod.printArray(arr);
    }

}
