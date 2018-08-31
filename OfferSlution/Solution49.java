package OfferSlution;

public class Solution49 {

    // 判断是否是非法输入
    public static boolean isInt = false;
    /**
     * 字符串转换成整数
     * + -  a  非法输入
     *
     * 空指针  空字符串 等错误输出
     *
     * 整数的上下溢出：使用Long类型暂存变量，之后用于判断输出
     *
     */
    public int StrToInt(String str) {
        long result = 0;
        if (str == null || str.length() == 0) {
            // 默认设置就是false
            isInt = false;
            return (int) result;
        }
        int sign = readFirst(str.charAt(0),str.length());
        if(sign == -2) {
            isInt = false;
            return (int) result;
        }

        int count = 1;
        char[] nums = str.toCharArray();
        for (int i = nums.length - 1; i >= 0; i--) {

            if (isNum(nums[i])) {
                isInt = true;
                result += sign * count * (nums[i] - '0');
                if((sign == 1 && Integer.MAX_VALUE < result) || (sign == -1 &&  result < Integer.MIN_VALUE)) {
                    isInt = false;
                    return 0;
                }
                count *= 10;
            } else {
                if(i == 0) {
                    break;
                }
                isInt = false;
                return 0;
            }
        }
        return (int) result;
    }


    public int readFirst(char c,int len) {
        if (c == '+' || isNum(c)) {
            return 1;
        } else if (c == '-') {
            return -1;
        } else {
            return -2;
        }
    }

    public boolean isNum(char num) {
        return num > '0' && num < '9';
    }
}

/*
class Test{

    public static void main(String[] args) {
        // int res = new Solution49().StrToInt("123455");
        int res = new Solution49().StrToInt("214748364888788");
        // int res = new Solution49().StrToInt("+"); // 刚好是零
        boolean flag = Solution49.isInt;
        System.out.println(res);
    }
}
*/
