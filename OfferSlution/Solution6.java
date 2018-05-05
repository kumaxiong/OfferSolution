package OfferSlution;

/**
 * 旋转数组中的最小数字
 */
public class Solution6 {

    public static void main(String[] args) {
        System.out.println(new Solution6().minNumberInRotateArray(new int[]{1,1,1,0,1}));
    }

    public int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0) return 0;
        if (array.length == 1) return array[0];
        int index1 = 0;
        int index2 = array.length - 1;
        int indexMid = 0;
        while (array[index1] >= array[index2]) {
            if ((index2 - index1) == 1) {
                indexMid = index2;
                break;
            }

            indexMid = (index1 + index2) / 2;

            if (array[indexMid] == array[index1] && array[indexMid] == array[index2]) {
                return search(array, index1, index2);
            }
            if (array[indexMid] >= array[index1]) index1 = indexMid;
            else if (array[indexMid] <= array[index2]) index2 = indexMid;
        }
        return array[indexMid];
    }

    public int search(int[] array, int index1, int index2) {
        int result = array[index1];
        if (array[index1] < array[index2]) return array[index1];
        for (int i = index1 + 1; i <= index2; i++) {
            if (array[i] < result) {
                result = array[i];
                break;
            }
        }
        return result;
    }
}

