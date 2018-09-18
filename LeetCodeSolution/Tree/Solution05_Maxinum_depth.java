package LeetCodeSolution.Tree;

public class Solution05_Maxinum_depth {


    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
    }


    // top - down 法，从上往下看
    private int answer = 0;

    public int maxDepth1(TreeNode root) {
        helper(root, 1);
        return answer;
    }

    private void helper(TreeNode root, int depth) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null && depth > answer) {
            answer = depth;
        }

        helper(root.left, depth + 1);
        helper(root.right, depth + 1);
    }
}
