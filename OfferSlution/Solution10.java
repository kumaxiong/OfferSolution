package OfferSlution;

/**
 * 矩形覆盖，斐波那契数列。
 */
public class Solution10 {
    public int RectCover(int target) {
        if (target <= 2) return target;
        int beforeOne = 1;
        int beforeTwo = 2;
        int FibN = 0;
        for (int i = 3; i <= target; i++) {
            FibN = beforeOne + beforeTwo;
            beforeOne = beforeTwo;
            beforeTwo = FibN;
        }
        return FibN;
    }

    // 递归方法不适用，通过不了
    public int RectCover_recursive(int target) {
        if (target == 1) return 1;
        if (target == 2) return 2;
        return RectCover_recursive(target - 1) + RectCover_recursive(target - 2);
    }
}