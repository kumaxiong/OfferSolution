package LeetCodeSolution.Tree;

public class Solution06_hasPathSum {

    private boolean hasSum = false;

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        hasPathSumHelper(root, sum, 0);
        return hasSum;
    }

    private void hasPathSumHelper(TreeNode root, int sum, int curSum) {

        if (hasSum || root == null) {
            return;
        }
        curSum += root.val;

        if (curSum == sum) {
            hasSum = true;
        }

        if (root.left != null) {
            hasPathSumHelper(root.left, sum, curSum);
        } else if (root.right != null) {
            hasPathSumHelper(root.right, sum, curSum);
        }

    }

}
