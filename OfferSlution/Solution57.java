package OfferSlution;

public class Solution57 {

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) return null;


        // 存在右子树 则找到右子树的最左节点。
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        }

        // 不存在右子树
        while (pNode.next != null) {
            TreeLinkNode pRoot = pNode.next;
            if (pNode == pRoot.left) {
                return pRoot;
            }
            pNode = pRoot;
        }

        return null;
    }
}
