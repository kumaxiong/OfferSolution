package BookCase;

/*class Test{
    public static void main(String[] args) {
        String str = "arabcacfr";
        System.out.println(new Case48_DP_LongestString().longestSubstringWithoutDuplication(str.toCharArray()));
    }
}*/
/*
f(i) = f(i - 1)  + 1 前面一个字符没有出现过。
当前字符在前面有出现过 上次出现——这次出现距离为d
d <= f(i-1) 那么f（i） =d；
d > f(i - 1) 说明 f(i - 1)有效能够直接应用到当前的过程中。
动态规划总结，看看是否需要额外的存储空间，可以开一个一维数组或者二维数组，或者直接用变量来存放。
 */

public class Case48_DP_LongestString {
    public int longestSubstringWithoutDuplication(char[] chars){
        int currentLength = 0;
        int maxLength = 0;
        // 用于存放一当前字符串为结尾的最长数字
        int[] position = new int[26];
        for (int i = 0; i < 26; i++) {
            position[i] = -1;
        }
        for (int i = 0; i < chars.length; i++) {
            int preIndex = position[chars[i] - 'a'];
            if(preIndex < 0 || i - preIndex > currentLength)
                currentLength++;
            else {
                if(currentLength > maxLength)
                    maxLength = currentLength;
                currentLength = i - preIndex;
            }
            position[chars[i] - 'a'] = i;
        }
        if(currentLength > maxLength)
            maxLength = currentLength;
        return maxLength;
    }
}
