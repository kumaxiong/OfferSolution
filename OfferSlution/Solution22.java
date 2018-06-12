package OfferSlution;

import java.util.ArrayDeque;
import java.util.ArrayList;
/*
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }*/

public class Solution22 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            TreeNode pNode = deque.remove();
            result.add(pNode.val);
            if (pNode.left != null) {
                deque.add(pNode.left);
            }
            if (pNode.right != null) {
                deque.add(pNode.right);
            }
        }
        return result;
    }

}
