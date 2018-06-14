package OfferSlution;
/*class Test {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode p1 = new TreeNode(6);
        TreeNode p2 = new TreeNode(14);
        root.left = p1;
        root.right = p2;
        TreeNode p3 = new TreeNode(4);
        TreeNode p4 = new TreeNode(8);
        p1.left = p3;
        p1.right = p4;
        TreeNode p5 = new TreeNode(12);
        TreeNode p6 = new TreeNode(16);
        p2.left = p5;
        p2.right = p6;
        TreeNode p = new Solution26().Convert(root);
        while (p != null){
            System.out.print(p.val + " ");
            p = p.right;
        }
    }
}*/
public class Solution26 {
    TreeNode pLastNodeInList = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        ConvertNode(pRootOfTree);
        TreeNode pHeadOfList = pLastNodeInList;
        while (pHeadOfList != null && pHeadOfList.left != null){
            pHeadOfList = pHeadOfList.left;
        }
        return pHeadOfList;
    }

    private void ConvertNode(TreeNode pRootOfTree){
        if(pRootOfTree == null)
            return;
        TreeNode pCurrent = pRootOfTree;
        // 持续Convert直到为空
        if(pCurrent.left != null)
            ConvertNode(pRootOfTree.left);
        // 拼接操作
        pCurrent.left = pLastNodeInList;
        if(pLastNodeInList != null)
            pLastNodeInList.right = pCurrent;
        // 拼接完成后当前节点成为最后遍历的节点。
        pLastNodeInList = pCurrent;
        if(pCurrent.right != null)
            ConvertNode(pCurrent.right);
    }
}
