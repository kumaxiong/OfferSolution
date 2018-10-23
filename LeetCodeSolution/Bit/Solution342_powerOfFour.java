package LeetCodeSolution.Bit;

public class Solution342_powerOfFour {

    public boolean isPowerOfFour(int num) {
        if (num <= 0) {
            return false;
        }

        boolean result;
        result = isPowerOfTwo(num);
        if (!result) {
            return false;
        }
        // 是二的倍数又是能被四整除
        result = num % 3 == 1;
        return result;

        // 计算零的个数
        // int countOfZero = 0;
        // for (int i = 0; i < 32; i++) {
        //     if ((num & 1) == 0) {
        //         countOfZero++;
        //     } else {
        //         break;
        //     }
        //     num = num >> 1;
        // }
        // return countOfZero % 2 == 0;
    }

    private boolean isPowerOfTwo(int n) {
        return (n & n - 1) == 0;
    }
}


// class Test {
//
//     public static void main(String[] args) {
//         System.out.println(new Solution342_powerOfFour().isPowerOfFour(16));
//         System.out.println(new Solution342_powerOfFour().isPowerOfFour(5));
//     }
// }