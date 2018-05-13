package OfferSlution;

/**
 * 数值的整数次方
 * double类型不能够直接判断。
 */

import java.math.BigDecimal;

public class Solution12 {
    boolean g_InvalidInput = false;

    public double Power(double base, int exponent) {
        g_InvalidInput = false;
        BigDecimal data1 = new BigDecimal(base);
        BigDecimal data2 = new BigDecimal(0.0);
        // 0 ^ 0 输出是无意义的。
        if (data1.compareTo(data2) == 0 && exponent < 0) {
            g_InvalidInput = false;
            return 0.0;
        }
        int absExponent = exponent;
        if(exponent < 0) absExponent *= -1;

        double result = PowerWithUnsignedExponent(base,absExponent);

        if(exponent < 0) result = 1.0 / result;

        return result;

    }


    // 看不懂Math的pow实现，需要JNI知识
    //public double PowerWithUnsignedExponent(double base,int absEponent){
    //    return Math.pow(base,absEponent);
    //}

    public double PowerWithUnsignedExponent(double base, int absEponent) {

        if(absEponent == 0) return 1.0;
        if(absEponent == 1) return base;

        double result = PowerWithUnsignedExponent(base,absEponent>>1);
        result *= result;
        if((absEponent & 1) == 1) result *= base;
        return result;
    }
}
