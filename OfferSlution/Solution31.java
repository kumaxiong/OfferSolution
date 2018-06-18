package OfferSlution;

public class Solution31 {
    // 编程之美解法，当前位，高位，低位的影响
    public int NumberOf1Between1AndN_Solution(int n){
        int count = 0;
        int iFactor = 1;
        int currentNum = 0;
        int higherNum = 0;
        int lowerNum = 0;
        while (n  / iFactor != 0){
            currentNum = (n / iFactor)  % 10;
            higherNum = n / (iFactor * 10);
            lowerNum = n - (n / iFactor) * iFactor;
            switch (currentNum){
                case 0:
                    count += higherNum * iFactor;
                    break;
                case 1:
                    count += higherNum * iFactor + lowerNum + 1;
                    break;
                default:
                    count += (higherNum + 1) * iFactor;
                    break;
            }
            iFactor *= 10;
        }
        return count;
    }
    public int NumberOf1Between1AndN_Solution_Normal(int n) {
        if(n <= 0)
            return 0;
        int count = 0;
        for (int i = 1; i <= n ; i++) {
            count += NumberOf1(i);
        }
        return count;
    }
    private int NumberOf1(int n){
        int count = 0;
        while (n > 0){
            if(n % 10 == 1)
                count++;
            n = n / 10;
        }
        return count;
    }
}
