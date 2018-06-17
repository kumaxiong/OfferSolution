package OfferSlution;

import java.util.Random;

/*class Test{
    public static void main(String[] args) {
        int i = new Solution28().MoreThanHalfNum_Solution(new int[]{1});
    }
}*/
public class Solution28 {

    public int MoreThanHalfNum_Solution(int[] array){
        if(CheckInvalidArray(array))
            return 0;
        int middle = array.length >> 1;
        int start = 0;
        int end = array.length-1;
        int index = Partition(array,start,end);
        while (index != middle){
            if(index > middle){
                end = index - 1;
                index = Partition(array,start,end);
            }
            else {
                start = index+1;
                index = Partition(array,start,end);
            }
        }
        int result = array[middle];
        if(!CheckMoreThanHalf(array,result))
            return 0;
        return result;
    }

    private int Partition(int[] array,int start, int end){
        if(array.length == 0 || array == null || start < 0 || end > array.length||start>end)
            throw new IllegalArgumentException("invalid input");

        int key_index = (start + end) >> 1;
        int key = array[key_index];
        int small = start;
        swap(array,key_index,end);
        for (int i = start; i <= end ; i++) {
            if(array[i] <= key){
                swap(array,small,i);
                small++;
            }
            // 遇到大的就跳过
        }
        return --small;
    }
    private void swap(int[] array,int a, int b){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    private boolean g_bInputInvalid = false;
    public int MoreThanHalfNum_Solution1(int[] array) {
        if(CheckInvalidArray(array))
            return 0;
        int result = array[0];
        int times = 1;
        for (int i = 0; i < array.length; i++) {
            if(times == 0){
                result = array[i];
                times = 1;
            }
            else if(array[i] == result)
                times++;
            else
                times--;
        }
        if(!CheckMoreThanHalf(array,result))
            return 0;
        return result;

    }

    private boolean CheckInvalidArray(int[] array){
        g_bInputInvalid = false;
        if(array == null || array.length <= 0)
            g_bInputInvalid = true;
        return g_bInputInvalid;
    }

    private boolean CheckMoreThanHalf(int[] array,int target){
        int times = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] == target)
                times++;
        }
        boolean isMoreThanHalf = true;
        if(times * 2 <= array.length)
            isMoreThanHalf = false;
        return isMoreThanHalf;
    }
}
