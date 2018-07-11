package OfferSlution;
/*
class Test{
    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,3,3,3,4,5};
        System.out.println(new Solution37().GetNumberOfK(array,3));
    }
}*/
public class Solution37 {
    public int GetNumberOfK(int[] array, int k) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int start = getFirstOfK(array, k, 0, array.length - 1);
        int start2 = getFirstOfK2(array,k);
        int end2 = getLastOfK2(array,k);
        int end = getLastOfK(array, k, 0, array.length - 1);
        if (start > -1 && end > -1) {
            return end - start + 1;
        }
        return 0;
    }

    private int getFirstOfK(int[] array, int k, int start, int end) {
        if (start > end) {
            return -1;
        }

        int middleIndex = (start + end) >> 1;
        int middleData = array[middleIndex];
        if (middleData == k) {
            if ((middleIndex > 0 && array[middleIndex - 1] != k) || middleIndex == 0) {
                return middleIndex;
            } else {
                end = middleIndex - 1;
            }
        } else if (middleData > k) {
            end = middleIndex - 1;
        } else {
            start = middleIndex + 1;
        }
        return getFirstOfK(array, k, start, end);
    }

    private int getLastOfK(int[] array, int k, int start, int end) {
        if (start > end) {
            return -1;
        }

        int middleIndex = (start + end) >> 1;
        int middleData = array[middleIndex];
        if (middleData == k) {
            if (middleIndex == array.length - 1 || (middleIndex < array.length && array[middleIndex + 1] != k)) {
                return middleIndex;
            } else {
                start = middleIndex + 1;
            }
        } else if (middleData > k) {
            end = middleIndex - 1;
        } else if (middleData < k) {
            start = middleIndex + 1;
        }
        return getLastOfK(array, k, start, end);
    }


    /**
     * 不要拘泥于递归写法，循环写法也要实现。
     */
    private int getFirstOfK2(int[] array, int k) {
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int middleIndex = (start + end) >> 1;
            int middleData = array[middleIndex];
            if (middleData == k) {
                if (middleIndex == 0 || (middleIndex > 0 && array[middleIndex - 1] != k)) {
                    return middleIndex;
                } else {
                    end -= 1;
                }
            }
            if (middleData > k) {
                end = middleIndex - 1;
            } else if (middleData < k) {
                start = middleIndex + 1;
            }
        }
        return -1;
    }

    private int getLastOfK2(int[] array, int k) {
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int middleIndex = (start + end) >> 1;
            int middleData = array[middleIndex];
            if (middleData == k) {
                if (middleIndex == array.length - 1 || (middleIndex < array.length && array[middleIndex + 1] != k)) {
                    return middleIndex;
                } else {
                    start += 1;
                }
            } else if (middleData < k) {
                start = middleIndex + 1;
            } else if (middleData > k) {
                end = middleIndex - 1;
            }
        }
        return -1;
    }
}
