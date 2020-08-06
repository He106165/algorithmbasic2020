package class01forExit;


import util.utilMethod;

//冒泡排序
public class Code02_BubbleSort {

    public static void BubbleSort(int[] arr){
        if(arr.length<2 || arr.length==0) return;

        for (int i = 0; i <arr.length ; i++) {

            for (int j = i+1; j < arr.length; j++) {

                if(arr[j] > arr[i])
                    utilMethod.swap(arr,i,j);
            }
        }
        utilMethod.printArray(arr);
    }


    public static void main(String[] args){
        int[] arra={1,2,1,8,6,4,9,4};
        BubbleSort(arra);
    }
}
