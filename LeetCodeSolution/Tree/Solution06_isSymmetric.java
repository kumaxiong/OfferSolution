package LeetCodeSolution.Tree;

public class Solution06_isSymmetric {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetricHelper(root.left, root.right);
    }

    private boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        // 有一个为空，判断另一个是不是也为空
        if (left == null || right == null) {
            return left == right;
        }

        if (left.val != right.val) {
            return false;
        }

        return isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right,
                right.left);
    }


}
