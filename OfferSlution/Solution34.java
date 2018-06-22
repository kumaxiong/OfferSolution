package OfferSlution;

import java.util.HashMap;

public class Solution34 {
    public static void main(String[] args) {
        int a = new Solution34().FirstNotRepeatingChar("NXWtnzyoHoBhUJaPauJaAitLWNMlkKwDYbbigdMMaYfkVPhGZcrEwp");
        System.out.println(a);
    }
    public int FirstNotRepeatingChar(String str) {
        if(str == null || str.length() == 0)
            return -1;
        return find(str.toCharArray());
    }

    private int find(char[] chars){
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if(map.get(chars[i]) == null){
                map.put(chars[i],1);
            }
            else {
                int num = map.get(chars[i]);
                num++;
                map.put(chars[i],num);
            }
        }
        for (int i = 0; i < chars.length; i++) {
            if(map.get(chars[i]) == 1)
                return i;
        }
        return -1;
    }
    public int find2(char[] chars){
        int[] hashTable = new int[256];
        for (int i = 0; i < 256; i++) {
            hashTable[i] = 0;
        }
        for (int i = 0; i < chars.length; i++) {
            hashTable[chars[i]]++;
        }
        for (int i = 0; i < chars.length; i++) {
            if(hashTable[chars[i]] == 1)
                return i;
        }
        return -1;
    }
}
