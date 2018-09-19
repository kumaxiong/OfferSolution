package LeetCodeSolution.Bit;

public class Solution231_PowerOfTwo {

    public boolean isPowerOfTwo1(int n) {

        if (n <= 0) {
            return false;
        }
        int countOne = 0;
        for (int i = 0; i < 31; i++) {
            if ((n & 1) == 1) {
                countOne++;
            }
            n = n >> 1;
        }
        return countOne == 1;
    }

    public boolean isPowerOfTwo(int n) {

        if (n <= 0) {
            return false;
        } else {
            return (n & n - 1) == 0;
        }
    }
}

// class Test{
//
//     public static void main(String[] args) {
//         System.out.println(new Solution231_PowerOfTwo().isPowerOfTwo(1));
//         System.out.println(new Solution231_PowerOfTwo().isPowerOfTwo(16));
//         System.out.println(new Solution231_PowerOfTwo().isPowerOfTwo(218));
//         System.out.println(new Solution231_PowerOfTwo().isPowerOfTwo(-1));
//         System.out.println(new Solution231_PowerOfTwo().isPowerOfTwo(-2));
//         System.out.println(new Solution231_PowerOfTwo().isPowerOfTwo(-16));
//     }
// }