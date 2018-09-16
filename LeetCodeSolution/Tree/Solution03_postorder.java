package LeetCodeSolution.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution03_postorder {


    // 先把root，以及左左孩子压入栈中，持续这个过程。
    /*
        之后出栈，pNode只可能有右孩子，不可能有左孩子了。
           ---有&右孩子是否遍历过 ---是：出栈，压入 result
                              ---否，把当前节点放回去，持续压入左孩子。

             无右孩子：出栈 压入 result
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();

        TreeNode pLast = new TreeNode(Integer.MIN_VALUE);
        TreeNode pNode = root;
        while (pNode != null) {
            stack.push(pNode);
            pNode = pNode.left;
        }

        boolean seen;
        while (!stack.isEmpty()) {
            seen = false;
            pNode = stack.pop();
            if (pNode.right != null) {
                // 相等，说明该节点的左右子树都遍历过了，可以加入。
                if (!pNode.right.equals(pLast)) {
                    stack.push(pNode);
                    TreeNode node = pNode.right;
                    while (node != null) {
                        stack.push(node);
                        node = node.left;
                    }
                    seen = true;
                }
            }
            if (!seen) {
                result.add(pNode.val);
                pLast = pNode;
            }

        }
        return result;
    }


    // 递归写法
    public List<Integer> postorderTraversal1(TreeNode root) {
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
        helper(root.left, result);
        helper(root.right, result);
        result.add(root.val);
    }
}
