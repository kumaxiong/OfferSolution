package LeetCodeSolution.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution03_levelOrder_bfs {


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            ArrayList<Integer> levelResult = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.remove();
                levelResult.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(levelResult);

        }
        return result;
    }

    /*
        记录当前层的最后一个指针，pLast。
        记录下一层的最后一个指针，pLastNext.

        遍历到当前最后一个指针的时候，pLast = pLastNext
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();

        // int pLevel = 1;
        TreeNode pLast = root;
        TreeNode pNextLast = null;
        TreeNode pNode;
        queue.add(root);

        List<Integer> levelResult = new ArrayList<>();

        while (!queue.isEmpty()) {
            pNode = queue.remove();
            levelResult.add(pNode.val);

            if (pNode.left != null) {
                queue.add(pNode.left);
                pNextLast = pNode.left;
            }
            if (pNode.right != null) {
                queue.add(pNode.right);
                pNextLast = pNode.right;
            }
            if (pNode.equals(pLast)) {
                result.add(levelResult);
                levelResult = new ArrayList<>();
                pLast = pNextLast;
                // level+1;
            }
        }
        return result;
    }
}
