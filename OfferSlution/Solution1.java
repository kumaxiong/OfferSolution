package OfferSlution;

import java.util.Random;

public class Solution1 {
    public boolean Find(int target, int[][] array) {
        int i = 0, j = array[0].length - 1;
        while (i <= array.length - 1 && j >= 0) {
            if (target == array[i][j]) return true;
            else if (target < array[i][j]) {
                j--;
                continue;
            } else if (target > array[i][j]) {
                i++;
                continue;
            }
        }
        return false;
    }

    /**
     * 相关题目 两个排序号的数组，合并成一个数组，a1，末尾有足够的空间。
     */
    public int[] sort(int[] A, int[] B) {
        int p2 = B.length - 1;
        int p1 = A.length - B.length - 1;
        int current = A.length - 1;
        while (p1 >= 0 && p2 >= 0) {
            A[current--] = B[p2] >= A[p1] ? B[p2--] : A[p1--];
        }
        if (p1 < 0) {
            A[current--] = B[p2];
        }
        if (p2 < 0) {
            A[current--] = A[p1];
        }
        return A;
    }
}

//
//class Test {
//    public static void main(String[] args) {
//        int[] A = {1,2,5,8,9,0,0,0,0,0};
//        int[] B = {1,2,3,6,6};
//        new Solution1().sort(A, B);
//        for (int i = 0; i < A.length; i++) {
//            System.out.print(A[i] + ",");
//        }
//    }
//}
