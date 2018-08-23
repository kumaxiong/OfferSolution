package OfferSlution;

public class Solution44 {

    public String ReverseSentence(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }

        char[] result = reverse(str.toCharArray(), 0, str.length() - 1);
        if (result == null) {
            return null;
        }
        int pBegin = 0;
        int pEnd = 0;

        while (pEnd < result.length) {
            if (result[pEnd] == ' ') {
                reverse(result, pBegin, pEnd - 1);
                pBegin = pEnd + 1;
            }
            pEnd++;
        }
        reverse(result, pBegin, pEnd - 1);// 牛客网，最后一个单独翻转
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

/*
class Test {

    public static void main(String[] args) {
        System.out.println(new Solution44().ReverseSentence("a b c"));
    }
}
*/
