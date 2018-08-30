package OfferSlution;

import java.util.Arrays;

public class Solution51 {

    public int[] multiply(int[] A) {
        if (A == null || A.length == 0) {
            return null;
        }
        // 先算下三角的连续陈发，后面算上三角的
        int[] result = new int[A.length];
        result[0] = 1;// 初始化第一个
        for (int i = 1; i < A.length; i++) {
            result[i] = result[i - 1] * A[i - 1];
        }

        int temp = 1; // 上三角的temp
        for (int i = A.length - 2; i >= 0; i--) {
            temp *= A[i + 1];
            result[i] *= temp;
        }
        return result;
    }

    public int[] multiply_iterator(int[] A) {

        int[] result = new int[A.length];
        // int[][] matrix = new int[A.length][A.length];
        for (int i = 0; i < A.length; i++) {
            int eachRow = 1;
            for (int j = 0; j < A.length; j++) {

                if (i == j) {
                    // matrix[i][j] = 1;
                    eachRow *= 1;
                } else {
                    // matrix[i][j] = A[j];
                    eachRow *= A[j];
                }
            }
            result[i] = eachRow;
        }
        return result;
    }

}


/*
class Test {

    public static void main(String[] args) {
        new Solution51().multiply(new int[]{1,2,3,4,5});
    }
}*/
