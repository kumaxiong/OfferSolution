package LeetCodeSolution.Dp;

public class Solution300_LIS {


    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        int[] stack = new int[nums.length];
        int top = 0;
        stack[0] = -1;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > stack[top]) {
                top++;
                stack[top] = nums[i];
            } else {
                int low = 1;
                int high = top;
                while (low <= high) {
                    int mid = (low + high) >> 1;
                    if (nums[i] > stack[mid]) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
                stack[low] = nums[i];
            }
        }
        return top;
    }

    // o（n^2） 算法

    public int lengthOfLIS1(int[] nums) {

        if (nums == null || nums.length < 1) {
            return 0;
        }

        int[] maxLength = new int[nums.length];
        maxLength[0] = 1;
        int result = 1;
        for (int i = 1; i < nums.length; i++) {

            int max = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    max = Math.max(max, maxLength[j] + 1);
                }
            }
            maxLength[i] = max;
            result = Math.max(result, max);
        }
        return result;
    }
}

class Test {

    public static void main(String[] args) {
        // int t = new Solution300_LIS().lengthOfLIS(new int[]{10,9,2,5,3,7,101,18});
        int t = new Solution300_LIS().lengthOfLIS(new int[]{2,1,5,3,6,4,8,9,7});
        System.out.println(t);
    }
}