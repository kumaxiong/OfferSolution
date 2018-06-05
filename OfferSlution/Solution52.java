package OfferSlution;

/**
 * test1 a = "",b = ".*"
 * test2 a = "aaa",b = "aaa*"
 */
/*
class Test {
    public static void main(String[] args) {
        String a = "aaa";
        String b = "aaa.";
        System.out.println(new Solution52().match(a.toCharArray(), b.toCharArray()));
    }
}
*/

public class Solution52 {
    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null)
            return false;
        int strIndex = 0;
        int patternIndex = 0;
        return matchCore(str, pattern, strIndex, patternIndex);
    }

    public boolean matchCore(char[] str, char[] pattern, int strIndex, int patternIndex) {
        // str pattern 同时都到了末尾,没有到末尾之前都可以+1，但是末尾的前一个+1放到数组中就会越界，注意判断
        if (strIndex == str.length && patternIndex == pattern.length)
            return true;
        // str没到末尾，而pattern 到了末尾 （另一种情况）str到末尾，patter没到末尾（各种*情况已考虑）
        if (strIndex != str.length && patternIndex == pattern.length)
            return false;
        // 第二个模式是*   保证patternIndex的不越界
        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
            // str没到底部的情况，匹配有三种情况：
            // 保持当前状态 str 后移一位，patter不后移
            // 跳过pattern
            // 消耗str字符
            if (strIndex != str.length && (str[strIndex] == pattern[patternIndex] || pattern[patternIndex] == '.'))
                return matchCore(str, pattern, strIndex + 1, patternIndex) ||
                        matchCore(str, pattern, strIndex + 1, patternIndex + 2) ||
                        matchCore(str, pattern, strIndex, patternIndex + 2);
            else
                // str到头了，patter还有可能是.* a* 这样子的情况，记得消耗
                return matchCore(str, pattern, strIndex, patternIndex + 2);
        }
        // 没有* ，那就正常匹配。
        if (strIndex != str.length && (str[strIndex] == pattern[patternIndex] || pattern[patternIndex] == '.'))
            return matchCore(str, pattern, strIndex + 1, patternIndex + 1);
        return false;
    }
}
