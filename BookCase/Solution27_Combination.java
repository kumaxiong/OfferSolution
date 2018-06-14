package BookCase;

import java.util.ArrayList;
/*class Test{
    public static void main(String[] args) {
        new Solution27_Combination().Combination("abc");
    }
}*/
public class Solution27_Combination {
    public void Combination(String str) {
        if (str == null || str.length() == 0)
            return;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= str.length(); i++) {
            Combination(str.toCharArray(), 0,i,sb);
        }
    }

    // 从chars 中选出 len长的字符。
    private void Combination(char[] chars, int index, int number,StringBuilder sb) {
        if(number == 0){
            System.out.println(sb.toString());
            return;
        }
        if(index == chars.length)
            return;
        // 加入当前元素，不加入当前元素
        sb.append(chars[index]);
        Combination(chars,index+1,number-1,sb);
        sb.deleteCharAt(sb.length() - 1); // 这行一定要加，不然会影响当前
        Combination(chars,index+1,number,sb);
    }
}
