package OfferSlution;

public class Solution2 {
    public String replaceSpace(StringBuffer str){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ' '){
                stringBuilder.append("%20");
            }
            else {
                stringBuilder.append(str.charAt(i));
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("hello xiong 123!");
        String s = new Solution2().replaceSpace(sb);
        System.out.println(s);
    }
}
