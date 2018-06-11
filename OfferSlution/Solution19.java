package OfferSlution;
import java.util.ArrayList;
/*class Test{
    public static void main(String[] args) {
        ArrayList<Integer> a = new Solution19().printMatrix(new int[][]{{1,2,3,4,5}});
        for(Integer i :a){
            System.out.print(i + " ");
        }
    }
}*/

public class Solution19 {
    private ArrayList<Integer> result = new ArrayList<>();
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        if(matrix.length <= 0 || matrix[0].length <= 0)
            return null;
        int rows = matrix.length;
        int columns = matrix[0].length;
        int start = 0;
        while (rows > start * 2 && columns > start * 2){
            printMatrixCircle(matrix,rows,columns,start);
            start++;
        }
        return result;
    }

    private void printMatrixCircle(int[][] matrix,int rows,int columns,int start){
        int endX = columns - 1 - start;
        int endY = rows - 1 - start;
        // 1. 左到右
        for (int i = start; i <= endX; i++)
            result.add(matrix[start][i]);

        // 2.上到下，有可能只有一行，所以需要判断

        if(start < endY){
            for (int i = start + 1; i <= endY; i++) {
                result.add(matrix[i][endX]);
            }
        }

        // 3.右到左，从右开始，往左打一行，需要判断条件。
        if(start < endX && start < endY){
            for (int i = endX - 1; i >= start ; i--) {
                result.add(matrix[endY][i]);
            }
        }

        // 4. 从下到上，判断是否是两行以上的
        if(start < endX && start < endY - 1){
            // 上面一格,在变化
            for (int i = endY - 1; i >= start + 1 ; i--) {
                result.add(matrix[i][start]);
            }
        }
    }
}

