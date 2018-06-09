package OfferSlution;

/**
 * 4. 重建二叉树
 */
public class Solution4 {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode root = ConstructCore(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }

    public TreeNode ConstructCore(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        if (startPre > endPre || startIn > endIn||pre.length != in.length) return null;
        int rootValue = pre[startPre];
        TreeNode root = new TreeNode(rootValue);
        root.left = root.right = null;
        int leftTreeCount = startIn;
        while (rootValue != in[leftTreeCount]) {
            leftTreeCount++;
        }
        // 偏移量的下标要注意，不然会产生数组越界。
        root.left = ConstructCore(pre, startPre + 1, startPre + leftTreeCount - startIn, in, startIn, leftTreeCount - 1);
        root.right = ConstructCore(pre,  startPre + leftTreeCount - startIn + 1, endPre, in, leftTreeCount + 1, endIn);
        return root;
    }
}

