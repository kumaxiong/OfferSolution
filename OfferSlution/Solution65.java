package OfferSlution;

import java.util.Arrays;

/**
 * 65 矩阵中的路径
 */
public class Solution65 {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || rows < 1 || cols < 1 || str == null) return false;

        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) Arrays.fill(visited[i], false);
        int pathLength = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (hasPathCore(matrix, rows, cols, row, col, str, pathLength, visited)) return true;
            }
        }
        return false;
    }

    boolean hasPathCore(char[] matrix, int rows, int cols, int row, int col, char[] str, int pathLength, boolean[][] visited) {
        // 找到合适的位置之后pathLength的位置++，数组越界是就不用判断了
        if (str.length == pathLength) return true;
        boolean hasPath = false;
        if ((row >= 0) && (row < rows) && (col >= 0) && (col < cols) && !visited[row][col] && (matrix[row * cols + col] == str[pathLength])) {
            pathLength++;
            visited[row][col] = true;
            hasPath = hasPathCore(matrix, rows, cols, row + 1, col, str, pathLength, visited)
                    || hasPathCore(matrix, rows, cols, row - 1, col, str, pathLength, visited)
                    || hasPathCore(matrix, rows, cols, row, col + 1, str, pathLength, visited)
                    || hasPathCore(matrix, rows, cols, row, col - 1, str, pathLength, visited);
            if (!hasPath) {
                pathLength--;
                visited[row][col] = false;
            }
        }
        return hasPath;
    }
}

//class Test {
//    public static void main(String[] args) {
//        boolean[][] nums = new boolean[10][10];
//        for (int i = 0; i < nums.length; i++) {
//            Arrays.fill(nums[i], true);
//        }
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = 0; j < nums[i].length; j++) {
//                System.out.println(nums[i][j]);
//            }
//        }
//    }
//}