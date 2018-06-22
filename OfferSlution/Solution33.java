package OfferSlution;

/*class Test{
    public static void main(String[] args) {
        int a = new Solution33().GetUglyNumber_Solution(3);
        System.out.println(a);
    }
}*/
public class Solution33 {
    public int GetUglyNumber_Solution(int index) {
        if (index <= 0)
            return 0;
        int[] uglyNumbers = new int[index];
        uglyNumbers[0] = 1;
        int t2Index = 0;
        int t3Index = 0;
        int t5Index = 0;
        int next = 1;
        while (next < index) {
            int min = getMin(uglyNumbers[t2Index] * 2, uglyNumbers[t3Index] * 3, uglyNumbers[t5Index] * 5);
            uglyNumbers[next] = min;
            // 更新t2,t3,t5;
            // t2,t3,t5小于当前最大值就需要更新了，之前的都小于等于最大值，只有之后的才会大于等于最大值。
            while (uglyNumbers[t2Index] * 2 <= uglyNumbers[next])
                t2Index++;
            while (uglyNumbers[t3Index] * 3 <= uglyNumbers[next])
                t3Index++;
            while (uglyNumbers[t5Index] * 5 <= uglyNumbers[next])
                t5Index++;
            next++;
        }
        return uglyNumbers[index - 1];
    }

    private int getMin(int a, int b, int c) {
        int min1 = a < b ? a : b;
        int min2 = min1 < c ? min1 : c;
        return min2;
    }

    public int GetUglyNumber_Solution_wasteTime(int index) {
        int uglyCount = 0;
        int number = 0;
        while (uglyCount != index) {
            number++;
            if (isUgly(number)) {
                uglyCount++;
            }
        }
        return number;
    }

    boolean isUgly(int number) {
        // 因子的概念，6 的因子2 *3 ,n 能被m整除，m就被称为因子g
        while (number % 2 == 0)
            number /= 2;
        while (number % 3 == 0)
            number /= 3;
        while (number % 5 == 0)
            number /= 5;
        return number == 1 ? true : false;
    }
}
