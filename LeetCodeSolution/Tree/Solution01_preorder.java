package LeetCodeSolution.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution01_preorder {

    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode pNode;
        while (!stack.isEmpty()) {
            pNode = stack.pop();
            result.add(pNode.val);
            if (pNode.right != null) {
                stack.push(pNode.right);
            }
            if (pNode.left != null) {
                // 需要先把左边的遍历完再遍历右边的，所以使用栈的结构，left后加入。
                stack.push(pNode.left);
            }
        }
        return result;
    }


    // 最优的递归写法
    public List<Integer> preorderTraversal1(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        helper(root, result);

        return result;
    }

    public void helper(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }

        result.add(root.val);
        helper(root.left, result);
        helper(root.right, result);
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        result.add(root.val);

        if (root.left != null) {
            result.addAll(preorderTraversal(root.left));
        }

        if (root.right != null) {
            result.addAll(preorderTraversal(root.right));
        }
        return result;
    }
}