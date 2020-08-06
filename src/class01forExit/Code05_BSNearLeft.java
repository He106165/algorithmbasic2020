package class01forExit;


//给定一个有序数组，查找比某一个值大的最左边界  二分
public class Code05_BSNearLeft {

    public static int BSNearLeft(int[] arr,int num){
        if(arr==null || arr.length==0) return -1;
        //左边界
        int L =0;
        //右边界
        int R =arr.length-1;
        //二分位置
        int mid=0;
        int index=0;
        while (L <= R){
            mid= L+((R-L) >> 1);
            if( arr[mid] <= num){
                L=mid +1;

            }else{
                R =mid-1;
                index=mid;
            }
        }
        return index;
    }

    public static void main(String[] args){
        int[] arr={1,2,3,6,7,8,9,15,19};
        int i=5;
        System.out.println(BSNearLeft(arr, i));
    }
}
