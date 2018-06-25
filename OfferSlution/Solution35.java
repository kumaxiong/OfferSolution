package OfferSlution;

import javax.crypto.spec.IvParameterSpec;

/*class Test {
    public static void main(String[] args) {
        int[] array = {7, 5, 6, 4};
        int a = new Solution35().InversePairs(array);
        System.out.println(a);
    }
}*/

public class Solution35 {
    public int InversePairs(int[] array) {
        if (array == null || array.length == 0)
            return 0;
        int[] copy = new int[array.length];
        for (int i = 0; i < copy.length; i++) {
            copy[i] = array[i];
        }
        // 归并排序
        int count = InversePairsCore(array, copy, 0, copy.length - 1);
        return count;
    }

    private int InversePairsCore(int[] array, int[] copy, int start, int end) {
        if (start == end) {
            copy[start] = array[start];
            return 0;
        }
        int length = (end - start) / 2;
        int left = InversePairsCore(array, copy, start, start + length) % 1000000007;
        int right = InversePairsCore(array, copy, start + length + 1, end) % 1000000007;
        // 初始化i为前半段的最后一个下标，初始化j为后半段的最后一个下标
        int i = start + length;
        int j = end;
        int indexCopy = end;
        int count = 0;
        while (i >= start && j >= start + length + 1) {
            if (array[i] > array[j]) {
                copy[indexCopy] = array[i];
                indexCopy--;
                i--;
                count += j - start - length;
                if (count > 1000000007)
                    count = count % 1000000007;
            } else {
                // array[j] 比较大
                copy[indexCopy] = array[j];
                indexCopy--;
                j--;
            }
        }
        while (i >= start) {
            copy[indexCopy--] = array[i--];
        }
        while ((j >= start + length + 1)) {
            copy[indexCopy--] = array[j--];
        }
        for (int k = start; k <= end; k++) {
            array[k] = copy[k];
        }
        return (left + right + count) % 1000000007;
    }
}
