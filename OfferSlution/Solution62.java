package OfferSlution;

import java.util.Stack;

/**
 * 二叉搜索树的第k个节点。
 */
public class Solution62 {
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k <= 0) {
            return null;
        }
        return kthNodeCore(pRoot, k);
    }

    TreeNode kthNodeCore(TreeNode pRoot, int k) {
        TreeNode pNode = pRoot;
        int count = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode kthNode = null;
        while (pNode != null || !stack.isEmpty()) {
            while (pNode != null) {
                stack.push(pNode);
                pNode = pNode.left;
            }
            pNode = stack.pop();
            count++;
            if (count == k) {
                kthNode = pNode;
            }
            pNode = pNode.right;
        }
        return kthNode;
    }
}
