package OfferSlution;

/**
 * 表示数值的字符串
 */

public class Solution53 {
    private int index = 0;
    // 剑指offer解答
    public boolean isNumeric(char[] str) {
        if (str.length < 1)
            return false;
        boolean numeric = scanInteger(str);
        if (index != str.length && str[index] == '.') {
            index++;
            // 三种情况
            // .123  = 0.123
            // 1. == 1.0
            // 123.123
            numeric = scanUnsignedInteger(str) || numeric;
        }
        if (index != str.length && (str[index] == 'e' || str[index] == 'E')) {
            index++;
            // 前面false 后面有  e123
            // 前面true 后面false 13e
            numeric = numeric && scanInteger(str);
        }
        // 另一种情况  12e+5.4  最后的.4 都没有扫到
        // 以及其他各种，+-5,都会影响index没有到结尾
        return numeric && index == str.length;
    }

    boolean scanUnsignedInteger(char[] str) {
        int strart = index;
        while (index != str.length && str[index] >= '0' && str[index] <= '9')
            index++;
        // 是否存在整数0~9
        return strart < index;
    }

    boolean scanInteger(char[] str) {
        if (index != str.length && (str[index] == '+' || str[index] == '-'))
            index++;
        return scanUnsignedInteger(str);
    }

    // 正则表达式解答
    boolean isNumeric_re(char[] str){
        String s = String.valueOf(str);
        return s.matches("[\\+|\\-]?\\d*(\\.\\d*)?([e|E][\\+|\\-]?\\d+)?");
    }
}

