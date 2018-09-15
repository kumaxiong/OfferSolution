package OfferSlution;

import java.util.ArrayList;
import java.util.Stack;

public class Solution59 {

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if (pRoot == null) {
            return result;
        }


        Stack[] stacks = new Stack[2];
        stacks[0] = new Stack<TreeNode>();
        stacks[1] = new Stack<TreeNode>();

        int current = 0;
        int next = 1;
        stacks[current].push(pRoot);


        ArrayList<Integer> floorTemp = new ArrayList<>();
        while (!stacks[current].isEmpty() || !stacks[next].isEmpty()) {
            TreeNode pNode = (TreeNode) stacks[current].pop();
            floorTemp.add(pNode.val);
            if (current == 0) {
                if (pNode.left != null) {
                    stacks[next].push(pNode.left);
                }
                if (pNode.right != null) {
                    stacks[next].push(pNode.right);
                }
            } else {
                if (pNode.right != null) {
                    stacks[next].push(pNode.right);
                }
                if (pNode.left != null) {
                    stacks[next].push(pNode.left);
                }
            }
            if (stacks[current].isEmpty()) {
                result.add(floorTemp);
                floorTemp = new ArrayList<>();
                current = 1 - current;
                next = 1- next;
            }
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
        new Solution59().Print(root);
    }
}
*/
