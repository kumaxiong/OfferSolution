package BookCase;

import java.util.Arrays;

/**
 * 输入数字n，打印从一到最大的n位十进制数，比如输入3，打印 1,2,3…………999；
 * <p>
 * 大数问题，用字符串数组模拟。
 */
class Test {
    public static void main(String[] args) {
        new Case17().Print1ToMaxOfNDigits2(3);
    }
}

public class Case17 {
    public void Print1ToMaxOfDigits(int n) {
        if (n < 0) return;
        char[] num = new char[n + 1];
        Arrays.fill(num, '0');
        while (!Increment(num)) {
            PrintNumber(num);
        }
    }

    public boolean Increment(char[] nums) {
        boolean isOverflow = false;
        int nTakeOver = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            int nSum = nums[i] - '0' + nTakeOver;
            if (i == nums.length - 1)
                nSum++;
            if (nSum >= 10) {
                if (i == 1)
                    isOverflow = true;
                else {
                    nTakeOver = 1;
                    nSum = 0;
                    nums[i] = (char) ('0' + nSum);
                }
            } else {
                // 没有进位
                nums[i] = (char) ('0' + nSum);
                break;
            }
        }
        return isOverflow;
    }

    public void PrintNumber(char[] nums) {
        boolean isBeginning0 = true;
        for (int i = 0; i < nums.length; i++) {
            if (isBeginning0 && nums[i] != '0')
                isBeginning0 = false;
            if (!isBeginning0)
                System.out.print(nums[i]);
        }
        System.out.println();
    }

    public void Print1ToMaxOfNDigits2(int n) {
        char[] nums = new char[n];
        for (int i = 0; i < 10; i++) {
            nums[0] = (char) ('0' + i);
            Solution_Recursive(nums, 0);
        }
    }

    public void Solution_Recursive(char[] nums, int index) {
        if (index == nums.length - 1) {
            PrintNumber(nums);
            return;
        }
        for (int i = 0; i < 10; i++) {
            nums[index + 1] = (char) ('0' + i);
            Solution_Recursive(nums, index + 1);
        }
    }

}
