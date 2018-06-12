package BookCase;

import OfferSlution.TreeNode;

import java.util.ArrayDeque;
import java.util.Stack;
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
        new Case32_UpToDownPrint().ZPrint(root);
    }
}
*/

public class Case32_UpToDownPrint {
    // 两个变量一个用于存放当前层需要打印的数量，另一个存放下一层的数量。
    public void Print(TreeNode root) {
        if (root == null)
            return;
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        int nextLevel = 0;
        int toBePrinted = 1;
        while (!deque.isEmpty()) {
            TreeNode pNode = deque.remove();
            System.out.print(pNode.val + " ");
            toBePrinted--;
            if (pNode.left != null) {
                deque.add(pNode.left);
                nextLevel++;
            }
            if (pNode.right != null) {
                deque.add(pNode.right);
                nextLevel++;
            }
            if (toBePrinted == 0) {
                System.out.println();
                toBePrinted = nextLevel;
                nextLevel = 0;
            }
        }
    }

    public void ZPrint(TreeNode root) {
        if (root == null)
            return;
        Stack[] stacks = new Stack[2];
        stacks[0] = new Stack<TreeNode>();
        stacks[1] = new Stack<TreeNode>();
        int current = 0;
        int next = 1;
        stacks[0].push(root);
        while (!stacks[current].isEmpty() || !stacks[next].isEmpty()) {
            TreeNode pNode = (TreeNode) stacks[current].pop();
            System.out.print(pNode.val + " ");
            if (current == 0) {
                if (pNode.left != null)
                    stacks[next].push(pNode.left);
                if (pNode.right != null)
                    stacks[next].push(pNode.right);
            } else {
                if (pNode.right != null)
                    stacks[next].push(pNode.right);
                if (pNode.left != null)
                    stacks[next].push(pNode.left);
            }
            if(stacks[current].isEmpty()){
                System.out.println();
                current = 1 - current;
                next = 1 - next;
            }
        }
    }

}
