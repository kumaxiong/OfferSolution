package BookCase;
/*
面试题46 翻译字符串
counts 数组里面应该是  5，3,2,1,1
 */
/*class Test{
    public static void main(String[] args) {
        System.out.println(new Case46_TurnIntToString().getTranslationCount(12218));
    }
}*/
public class Case46_TurnIntToString {
    public int getTranslationCount(int number){
        if(number < 0)
            return 0;
        String nString = String.valueOf(number);
        return getTranslationCount(nString.toCharArray());
    }
    private int getTranslationCount(char[] number){
        int[] counts = new int[number.length];
        int count = 0;
        for (int i = number.length - 1; i >= 0; i--) {
            if(i == number.length - 1)
                count = 1;
            else
                count = counts[i+1];
            if(i < number.length - 1){
                int digit1 = number[i] - '0';
                int digit2 = number[i + 1]  - '0';
                int converted = digit1 * 10 + digit2;
                if(converted >= 10 && converted <= 25){
                    if(i < number.length - 2)
                        count += counts[i+2];
                    else
                        count += 1;
                }
            }
            // 更新count数组
            counts[i] = count;
        }
        return counts[0];
    }
}
