package LeetCodeSolution.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution02_inorder {


    /*
    非递归遍历（迭代）

    先把根节点的左孩子压入栈，持续压入左孩子。
    直到左孩子为空。

    之后进行出栈操作。拿出栈顶元素。
            ---- 叶子节点：当前节点加入result，当前节点遍历完毕。
            ---- 有左孩子 持续压入左孩子，当前节点未遍历完毕。
            ---- 无右孩子：当前节点加入result，当前节点遍历完毕。
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode pNode = root;
        while (!stack.isEmpty() || pNode != null) {

            while (pNode != null) {
                stack.push(pNode);
                pNode = pNode.left;
            }

            if (!stack.isEmpty()) {
                pNode = stack.pop();
                result.add(pNode.val);
                // 遍历右孩子
                pNode = pNode.right;
            }
        }

        return result;
    }


    // 递归写法
    public List<Integer> inorderTraversal1(TreeNode root) {
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
        } else {
            helper(root.left, result);
            result.add(root.val);
            helper(root.right, result);
        }
    }
}
