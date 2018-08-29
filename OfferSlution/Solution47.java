package OfferSlution;


public class Solution47 {

    public int Sum_Solution(int n) {
        int result = n;
        // 没法直接写逻辑与，n > 0 表示初始条件
        boolean a = (n > 0) && (result += Sum_Solution(n - 1)) > 0;
        return result;
    }
}
