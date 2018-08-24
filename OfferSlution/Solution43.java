package OfferSlution;

public class Solution43 {

    public String LeftRotateString(String str, int n) {
        if (str == null || str.length() <= 1 || n <= 0) {
            return str;
        }

        n = n % str.length();// 左移操作的n可能会大于长度，可以用取余操作过滤
        char[] result = str.toCharArray();
        reverse(result, 0, result.length - 1);
        reverse(result, 0, result.length - n - 1);
        reverse(result, result.length - n, result.length - 1);
        return new String(result);
    }

    public static char[] reverse(char[] chars, int lo, int hi) {
        if (chars == null || (lo > hi)) {
            return null;
        }
        while (lo < hi) {
            char temp = chars[lo];
            chars[lo] = chars[hi];
            chars[hi] = temp;
            lo++;
            hi--;
        }
        return chars;
    }
}

//class Test {
//
//    public static void main(String[] args) {
//        System.out.println(new Solution43().LeftRotateString("xiongliqiang", 65));
//    }
//}
