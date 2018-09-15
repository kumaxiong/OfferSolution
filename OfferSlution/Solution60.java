package OfferSlution;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Solution60 {

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }

        TreeNode pNode = pRoot;
        TreeNode pEnd = pRoot;
        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.add(pNode);
        ArrayList<Integer> floorResult = new ArrayList<>();
        while (!queue.isEmpty()) {
            pNode = queue.remove();
            floorResult.add(pNode.val);

            if (pEnd == pNode) {
                result.add(floorResult);
                floorResult = new ArrayList<>();
                pEnd = pNode.right == null ? pNode.left : pNode.right;
            }
            if (pNode.left != null) {
                queue.add(pNode.left);
            }
            if (pNode.right != null) {
                queue.add(pNode.right);
            }

        }

        if (!floorResult.isEmpty()) {
            result.add(floorResult);
        }
        return result;
    }
}


/* 按层次遍历树，每一行打出一个换行符
 * z字遍历
 *             8
 *         6         10
 *       5   7     9   11
 *     1  2
 * */
/*

class Test {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        TreeNode p1 = new TreeNode(6);
        TreeNode p2 = new TreeNode(10);
        root.left = p1;
        root.right = p2;
        TreeNode p3 = new TreeNode(5);
        TreeNode p4 = new TreeNode(7);
        p1.left = p3;
        p1.right = p4;
        TreeNode p5 = new TreeNode(9);
        TreeNode p6 = new TreeNode(11);
        p2.left = p5;
        p2.right = p6;
        p3.left = new TreeNode(1);
        p3.right = new TreeNode(2);
        new Solution60().Print(root);
    }
}
*/
