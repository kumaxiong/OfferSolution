package OfferSlution;
import java.util.ArrayList;
/* 按层次遍历树，每一行打出一个换行符
* z字遍历
*             8
*         6         10
*       5   7     9   11
*     1  2
* */

/*class Test {
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
        p5.left = new TreeNode(2);
        TreeNode p6 = new TreeNode(11);
        p2.left = p5;
        p2.right = p6;
        p3.left = new TreeNode(1);
        p3.right = new TreeNode(2);
        ArrayList<ArrayList<Integer>> paths = new Solution24().FindPath(root,29);
        for(ArrayList<Integer> list : paths){
            for(Integer i: list){
                System.out.println(i + " ");
            }
            System.out.println("ZZZZZZZZZZZZZZZZ");
        }
    }
}*/
public class Solution24 {

    // 剑指Offer版Solution
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root == null)
            return result;
        ArrayList<Integer> path = new ArrayList<>();
        FindPath(root,target,path,0);
        return result;
    }

    public void FindPath(TreeNode root,int target,ArrayList<Integer> path,int currentSum){
        path.add(root.val);
        currentSum += root.val;

        // 是叶节点，则加入结果集合当中
        boolean isLeaf = root.left == null && root.right == null;
        if(currentSum == target && isLeaf){
            ArrayList<Integer> aResult = new ArrayList<>();
            aResult.addAll(path);
            result.add(aResult);
        }

        // 不是叶节点的操作

        if(root.left != null)
            FindPath(root.left,target,path,currentSum);
        if(root.right != null)
            FindPath(root.right,target,path,currentSum);

        // 不管是不是叶节点，遍历完这层之后我们就要在path中减去这段数值
        path.remove(path.size() - 1);
    }


    // 精简版Solution
    ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
    ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath2(TreeNode root,int target) {
        if(root == null)
            return paths;
        list.add(root.val);
        target = target - root.val;
        if(target == 0 && root.left == null && root.right == null)
            paths.add(new ArrayList<>(list));
        FindPath(root.left,target);
        FindPath(root.right,target);
        list.remove(list.size()-1);
        return paths;
    }

}

