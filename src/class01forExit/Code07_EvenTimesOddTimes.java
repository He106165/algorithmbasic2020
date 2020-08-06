package class01forExit;

public class Code07_EvenTimesOddTimes {

    //一个数组中有一个数出现了奇数次
    public static int printOddTimesNum1(int[] arr){
        int eor=0;
        for (int i = 0; i <arr.length ; i++) {
            eor^=arr[i];
        }

        return  eor;
    }
    //一个数组中有俩个数出现了奇数次
    public static void printOddTimesNum2(int[] arr){
        int eor=0;
        for (int i = 0; i <arr.length ; i++) {
            eor^=arr[i];
        }
        //最右侧的1   本身 与 （printOddTimesNum2）
        int rightOne=eor & (~eor +1);
        int onlyOne=0;
        for (int i = 0; i <arr.length ; i++) {
           if((rightOne & arr[i]) !=0){
               onlyOne ^=arr[i];
           }
        }
        System.out.println(onlyOne +"   "+ (eor^onlyOne));
    }


    public static void main(String[] args){
        int[] arr={1,1,1,22,22,33,44,33,44,55,55,4,4,5,5,5};
        //System.out.println(printOddTimesNum2(arr));
        printOddTimesNum2(arr);
    }
}
