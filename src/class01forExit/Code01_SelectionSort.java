package class01forExit;


import util.utilMethod;

//复习选择排序
public class Code01_SelectionSort {


    public static void main(String[] args){
        int[] arra={1,2,1,8,6,4,9,4};
        selectionSort(arra);
    }

    public static void selectionSort(int[] arr){
        if(arr.length<2 || arr.length==0) return;
        for (int i = 0; i < arr.length-1 ; i++) {
            //记录每次查询的最大值下标
            int index=i;
            for (int j = i+1; j <arr.length ; j++) {
                index= arr[j] > arr[index] ? j : index;//每次记录之后需要和这次的index最大值相比，所以不能是i
            }
            utilMethod.swap(arr ,index, i);
            utilMethod.printArray(arr);
        }
        utilMethod.printArray(arr);
    }



}
