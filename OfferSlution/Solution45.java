package OfferSlution;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 可以使用桶排序来加速
 * 不能出现对子
 *
 * 8, 3, 1, 9, 4   false
 * 0,0,1,1,4 false
 */
public class Solution45 {

    public boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length != 5) {
            return false;
        }
        Arrays.sort(numbers);
        int zeroCount = 0;
        int needZero = 0;
        int doubleResult;
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == 0) {
                zeroCount++;
            } else {
                doubleResult = numbers[i + 1] - numbers[i] - 1;
                if (doubleResult < 0) {
                    return false;
                }
                needZero += doubleResult;
            }
        }
        return needZero <= zeroCount;
    }
}


class Test {

    public static void main(String[] args) {
        boolean result = new Solution45().isContinuous(new int[]{0,0,1,1,4});
        System.out.println(result);
    }
}