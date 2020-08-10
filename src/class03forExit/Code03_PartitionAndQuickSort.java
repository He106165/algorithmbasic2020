package class03forExit;

import util.utilMethod;



public class Code03_PartitionAndQuickSort {
    /**
     * partition分治问题，左边比某个值小，右边比某个值大
     * */
    public static int partition(int[] arr,int L, int R){
        if(arr==null || L > R) return -1;

        if(L==R) return L;
        int lessEqual=L-1;
        int index=L;
        while(index < R){
            if(arr[index] <= arr[R]){
                utilMethod.swap(arr,index,lessEqual);
                index++;
            }
        }
        utilMethod.swap(arr,++lessEqual,R);
        return lessEqual;
    }

    //在数组的给定范围之内，查找以最后一个数字为轴，小于等于排前面，大于排后面。最后将轴放到中心，返回轴位置
    public static  int  partition2(int[] arr, int leftPor,int rightPor) {
        int pivot = arr[rightPor];
        int left = leftPor;
        int right = rightPor - 1;
        while (left <= right) {
            while (left <= right && arr[left] <= pivot) left++; //寻找左边大于pivot 的第一个值
            while (left <= right && arr[right] > pivot) right--;//寻找右边小于pivot 的第一个值
            if (left < right) utilMethod.swap(arr, left, right);//交换
        }
        //交换最左边和最后一个数
        utilMethod.swap(arr, left, rightPor);
        return left;
    }


    public static void main(String[] args) {
        int[] arr={1,3,4,6,83,5,42,54,32,67,23,523,23,4523,214124,543256453,6,75};

        System.out.println(partition(arr, 0, arr.length-1));
        utilMethod.printArray(arr);
    }


}
