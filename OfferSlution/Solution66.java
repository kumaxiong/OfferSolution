package OfferSlution;

import java.util.Arrays;
//
//class Test{
//    public static void main(String[] args) {
//        System.out.println(new Solution66().movingCount(15,100,1));
//    }
//}
public class Solution66 {
    public int movingCount(int threshold, int rows, int cols) {
        if (threshold < 0 || rows < 0 || cols < 0) return 0;
        boolean[] visited = new boolean[rows * cols];
        Arrays.fill(visited, false);
        int count = movingCountCore(threshold, rows, cols, 0, 0, visited);
        return count;
    }

    public int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        int count = 0;
        // 这个能走，再试试周围的
        if (check(threshold, rows, cols, row, col, visited)) {
            visited[row * cols + col] = true;
            count = 1 + movingCountCore(threshold, rows, cols, row + 1, col, visited)
                    + movingCountCore(threshold, rows, cols, row - 1, col, visited)
                    + movingCountCore(threshold, rows, cols, row, col + 1, visited)
                    + movingCountCore(threshold, rows, cols, row, col - 1, visited);
        }
        return count;
    }

    public boolean check(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        if (row >= 0 && row < rows && col >= 0 && col < cols && (getDigitSum(row) + getDigitSum(col) <= threshold) && !visited[row * cols + col]) {
            return true;
        } else return false;
    }

    public int getDigitSum(int number) {
        int sum = 0;
        int num = number;
        while (num > 0) {
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }
}

