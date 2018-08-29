package BookCase;

/**
 * 买卖的最大利润
 * - 每个时间点都有可能卖出
 * - 卖出的利润只与之前最小的价格有关，也就是之前买入的价格越小越好
 */
public class Case63_MaxmalProfit {
    public int maxDiff(int[] numbers) {
        if(numbers == null || numbers.length < 1) {
            return 0;
        }
        int maxDiff = Integer.MIN_VALUE;
        int minBefore = Integer.MAX_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            // 更新之前的最小值
            if(numbers[i] < minBefore) {
                minBefore = numbers[i];
            }
            int diff = numbers[i] - minBefore;
            if(diff > maxDiff) {
                maxDiff = diff;
            }
        }
        return maxDiff;
    }
}
/*
class Test {

    public static void main(String[] args) {
        System.out.println(new Case63_MaxmalProfit().maxDiff(new int[]{9,11,8,5,7,12,16,14}));
    }
}*/
