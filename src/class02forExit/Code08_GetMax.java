package class02forExit;

public class Code08_GetMax {

    public static int  getMax(int[] arr){
        return process(arr,0,arr.length-1);
    }

    public static int process(int[] arr,int L,int R){
        if(L == R) return arr[L];

        int mid= L+((R -L ) >> 1);
        int LDate=process(arr,L,mid);
        int RDate=process(arr,mid+1,R);
        return Math.max(LDate,RDate);


    }

    public static void main(String[] args) {
        int[] arr={1,3,4,6,83,5,42,54,32,67,23,523,23,4523,214124,543256453,6,75};
        System.out.println(getMax(arr));
    }
}
