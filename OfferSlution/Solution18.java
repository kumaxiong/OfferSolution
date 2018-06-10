package OfferSlution;

import java.util.ArrayDeque;
/*public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}*/
public class Solution18 {
    public void Mirror(TreeNode root) {
        if(root == null)
            return;
        if(root.left == null && root.right == null)
            return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        if(root.right != null)
            Mirror(root.right);
        if(root.left != null)
            Mirror(root.left);
    }

    // 循环解法，借助队列
    public void Mirror_Iterative(TreeNode root){
        if(root == null)
            return;
        ArrayDeque<TreeNode> treeNodes = new ArrayDeque<>();
        treeNodes.add(root);
        while (!treeNodes.isEmpty()){
            TreeNode tempRoot = treeNodes.remove();
            if(tempRoot.left != null)
                treeNodes.add(tempRoot.left);
            if(tempRoot.right != null)
                treeNodes.add(tempRoot.right);
            TreeNode temp = tempRoot.left;
            tempRoot.left = tempRoot.right;
            tempRoot.right = temp;
        }
    }
}
