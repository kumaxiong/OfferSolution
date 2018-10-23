package LeetCodeSolution.Array;

public class Solution80_Remove_Duplicates {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        int sorted = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[sorted] < nums[i]) {
                sorted++;
                nums[sorted] = nums[i];
            }
        }

        return sorted+1;
    }
}
