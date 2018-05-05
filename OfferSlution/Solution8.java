package OfferSlution;

/**
 * 跳台阶
 */
public class Solution8 {
    public int JumpFloor(int target) {
        if (target == 1) return 1;
        if (target == 2) return 2;
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

    public int JumpFloor_Recursive(int target) {
        if (target == 1) return 1;
        if (target == 2) return 2;
        return JumpFloor_Recursive(target - 1) + JumpFloor_Recursive(target - 2);
    }
}
