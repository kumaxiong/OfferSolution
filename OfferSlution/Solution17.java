package OfferSlution;

/*public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}*/

public class Solution17 {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;

        if (root1 != null & root2 != null) {
            if(root1.val == root2.val){
                result = DoesTeee1HaveTree2(root1,root2);
            }
            // 如果当前不是，那么递归搜索其左右子树
            if(!result)
                result = HasSubtree(root1.left,root2);
            if(!result)
                result = HasSubtree(root1.right,root2);
        }
        return result;
    }

    public boolean DoesTeee1HaveTree2(TreeNode root1, TreeNode root2){
        // 优先判断root2是否为空
        if(root2 == null)
            return true;
        if(root1 == null)
            return false;
        if(root1.val != root2.val)
            return false;
        return DoesTeee1HaveTree2(root1.left,root2.left) && DoesTeee1HaveTree2(root1.right,root2.right);
    }
}
