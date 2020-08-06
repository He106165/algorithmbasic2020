package class01forExit;


//二分法查找一个数
public class Code04_BSExist {
    //1.给定一个有序数组
    public static boolean BSExit(int[] arr, int num){
        if(arr==null || arr.length==0) return false;
        //左边界
        int L =0;
        //右边界
        int R =arr.length-1;
        //二分位置
        int mid=0;
        while (L <= R){
            mid= L+((R-L) >> 1);
            if(arr[mid]==num){
                return true;
            }else if( arr[mid] < num){
                L=mid +1;
            }else{
                R =mid-1;
            }
        }
        return arr[mid]==num;
    }

    public static void main(String[] args){
        int[] arr={1,2,3,4,7,8,9,15,19};
        int i=9;
        System.out.println(BSExit(arr, i));
    }
}
