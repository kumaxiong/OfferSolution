package OfferSlution;

import java.lang.reflect.Array;

//class Test {
//    public static void main(String[] args) {
//        int[] array = {1, 2, 3, 4, 5, 6};
//        new Solution13().reOrderArray3(array);
//        for (int i : array)
//            System.out.print(i + " ");
//
//    }
//}

public class Solution13 {
    public void reOrderArray(int[] array) {
        // 插入排序思想
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i;
            while (isEven(current) && j > 0 && !isEven(array[j - 1])) {
                swap(array, j, j - 1);
                j--;
            }
        }
    }

    // 剑指offer第二版上面明明没说奇数偶数相对位置不变（稳定 == 相对位置不变）
    public void reOrderArray2(int[] array) {
        int lo = 0;
        int hi = array.length - 1;
        // 不稳定被pass了
        while (lo < hi) {
            if (isEven(array[lo]))
                //奇数区间变大
                lo++;
            if (!isEven(array[lo])) {
                while (!isEven(array[hi]))
                    hi--;
                swap(array, lo, hi);
                hi--;
            }
        }
    }

    // 扫描法
    public void reOrderArray3(int[] array) {
        // 扫两边数组即可，辅助空间O(n)
        int[] result = new int[array.length];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (isEven(array[i])) {
                result[index] = array[i];
                index++;
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (!isEven(array[i])) {
                result[index] = array[i];
                index++;
            }
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = result[i];
        }
    }

    boolean isEven(int a) {
        if ((a & 1) == 0) {
            return false;
        } else return true;
    }

    public void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
