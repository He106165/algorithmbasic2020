package class01forExit;

import util.utilMethod;

//插入排序
public class Code03_InsertionSort {

    public static  void InsertionSort(int[] arr){
        if(arr.length<2 || arr.length==0) return;
        for (int i = 1; i < arr.length ; i++) {
            for (int j = i-1; j >=0; j--) {
                if(arr[j] < arr[j+1]){
                    utilMethod.swap(arr,j+1,j);
                }
            }
        }
        utilMethod.printArray(arr);
    }

    public static void main(String[] args){
        int[] arra={1,2,1,8,6,4,9,4};
        InsertionSort(arra);
    }
}
