package BookCase;
/*
选择礼物的最大价值
往右往下
 */
/*class Test{
    public static void main(String[] args) {
        int[][] presents = new int[][]{{1,10,3,8},{12,2,9,6},{5,7,4,11},{3,7,16,5}};
        System.out.println(new Case47_DP_Present().getMaxValue_solution2(presents));
    }
}*/
public class Case47_DP_Present {
    public int getMaxValue_solution(int[][] values){
        if(values == null)
            return -1;
        int rows = values.length;
        if(rows == 0)
            return -1;
        int cols = values[0].length;
        int [][] maxValues = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int left = 0;
                int up = 0;
                if(i > 0)
                    up = maxValues[i - 1][j];
                if(j > 0)
                    left = maxValues[i][j-1];

                maxValues[i][j] = Math.max(up,left) + values[i][j];
            }
        }
        return maxValues[rows -1][cols - 1];
    }

    public int getMaxValue_solution2(int[][] values) {
        if (values == null)
            return -1;
        int rows = values.length;
        if (rows == 0)
            return -1;
        int cols = values[0].length;
        int[] maxValues = new int[cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int left = 0;
                int up = 0;
                // 第一次算上了第一层的所有，第二次的时候就能调用up层的数据，然后同时
                if (i > 0)
                    up = maxValues[j];
                // 同时第二层在更新的时候又从左边的开始更新左端数据
                if (j > 0)
                    left = maxValues[j - 1];

                maxValues[j] = Math.max(up, left) + values[i][j];
            }
        }
        return maxValues[cols - 1];
    }
}
