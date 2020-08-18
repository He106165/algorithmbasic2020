package class05forExit;


import util.utilMethod;

/**
 * 计数排序  --桶排序
 * */
public class code03_CountSort {

    public static void countSort(int[] arr){
        //先算出数组中的最大值
        int max =Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max=Math.max(max,arr[i]);
        }
        //创建出一个数组
        int[] count=new int[max+1] ;
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        //定义一个重新排序的下标，用来重新往进放数据
        int j=0;
        for (int i = 0; i <count.length ; i++) {
            while(count[i]-- > 0){//这里一定要 -- 把每个桶里的东西都放出来
                arr[j++]=i;
            }
        }
    }
    public static void main(String[] args){
        int[] arr={123,2,35,64,34,67,89,54,32,65,86,33,45,68,23,4,55};
        countSort(arr);
        utilMethod.printArray(arr);
    }
}
