package OfferSlution;

public class Solution48 {

    public int Add(int num1, int num2) {
        int sum = 0;
        int carray = 0;

        do {
            sum = num1 ^ num2; // 通过异或运算，算出相加但是不进位的结果
            carray = (num1 & num2) << 1; // 通过与运算 00 = 0 01=0 11= 1 算出进位，记得左移

            num1 = sum;
            num2 = carray;
        } while (num2 != 0);// 没有进位的时候结束循环；

        return num1;
    }
}
