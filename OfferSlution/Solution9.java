package OfferSlution;

/**
 * 变态跳台阶
 * 思路：有n根火柴，使用有n-1个空格，向这n-1个空格插入挡板，2^(n-1)
 */
public class Solution9 {
    public int JumpFloorII(int target) {
        return (int) Math.pow(2, target - 1);
    }

    public int JumpFloorII_Recursive(int target) {
        if (target == 1) return 1;
        return 2*JumpFloorII_Recursive(target-1);
    }
}
