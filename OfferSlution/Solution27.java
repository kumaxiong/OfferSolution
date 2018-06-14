package OfferSlution;

import java.util.ArrayList;
import java.util.Collections;

/*class Test{
    public static void main(String[] args) {

        ArrayList<String> results = new Solution27().Permutation("a");
        for(String s: results){
            System.out.println(s);
        }
    }
}*/
public class Solution27 {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> results = new ArrayList<>();
        if(str == null || str.length() == 0)
            return results;
        Permutation(str.toCharArray(),0,results);
        // 按照字典序升序排里
        Collections.sort(results);
        return results;
    }
    private void Permutation(char[] chars,int index,ArrayList<String> results){
        if(index == chars.length)
            return;
        if(index == chars.length - 1){
            results.add(String.valueOf(chars));
        }
        // 确认index，当前index 需要加Permutation，后面遇到重复字符跳过。
        Permutation(chars,index+1,results);
        for (int i = index + 1; i < chars.length; i++) {
            if(chars[i] != chars[index]){
                swap(chars,i,index);
                Permutation(chars,index+1,results);
                swap(chars,i,index);
            }
        }

    }

    private void swap(char[] chars,int i,int j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
