package OfferSlution;

/**
 * 斐波那契数列
 */
public class Solution7 {
    public int Fibonacci(int n) {
        int beforeOne = 0;
        int beforeTwo = 1;
        int FibN = 0;
        if (n <= 1) return n;
        for (int i = 2; i <= n ; i++) {
            FibN = beforeOne + beforeTwo;
            beforeOne = beforeTwo;
            beforeTwo = FibN;
        }
        return FibN;
    }

    public int Fibonacci_Recursive(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return Fibonacci_Recursive(n - 1) + Fibonacci_Recursive(n-2);
    }


}
