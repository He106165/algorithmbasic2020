package class05forExit;

import util.utilMethod;

/**
 * 计数排序
 * */
public class code04_RadixSort {

    //返回一个数的第几位是啥
    public  static int getDigit(int x,int d){
        return x / ((int)Math.pow(10,d-1)) % 10;
    }
    //返回一个数组中最大的值，该值有几位
    public  static int getmaxbits(int[] data){
        int ret=0;
        int max=Integer.MIN_VALUE;
        for (int datum : data) {
            max=max > datum ? max : datum;
        }
        while (max >0){
            max=max/10;
            ret++;
        }
        return ret;
    }


    public static void  RadixSort(int[] arr){
        //先排除错误情况
        if(arr==null || arr.length<2) return ;
        RadixSort(arr,0,arr.length-1,getmaxbits(arr));
    }
    public static void RadixSort(int[] arr,int L ,int R,int d){
        //定义一个和原数组等长的 辅助数组 ，用来第三步接收数据
        int[] help=new int[R-L+1];
        for (int i = 1; i <=d ; i++) {
            int[] count=new int[10];
            //把count的桶先填充好了
            for (int j = L; j <R ; j++) {
                int index=getDigit(arr[j], d);
                count[index]++;
            }
            //把count的桶逐个相加
            for (int j = 1; j <count.length-1; j++) {
                count[j]=count[j]+ count[j-1];
            }
            //arr倒序开始，找到在count的位置，然后放到help数组中去
            for (int j = count.length-1; j >=0 ; j--) {
                //找到位置
                int index=getDigit(arr[j],d);
                help[count[index]-1] = arr[j];
                count[index]--;
            }
            //把数据从count到arr中去
            /*for (int c = 0; c <count.length ; c++) {
                arr[c]= count[c];
            }*/
            for (int h = L, j = 0; i <= R; i++, j++) {
                arr[h] = help[j];
            }
        }
    }
    public static void main(String[] args){
        System.out.println(getDigit(3, 1));

     /*   int[] arr={1,3,4,6,83,5,42,54,32,67,23,523,23,4523,214124,543256453,6,75};
        RadixSort(arr);
        utilMethod.printArray(arr);*/
    }
}
