package OfferSlution;

import BookCase.Case32_UpToDownPrint;

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
        String s = new Solution61().Serialize2(root);
        System.out.println(s);
        TreeNode root2 = new Solution61().Deserialize(s);
        new Case32_UpToDownPrint().Print(root2);
    }
}*/
public class Solution61 {
    StringBuilder serializeBuilder = new StringBuilder();
    String Serialize(TreeNode root) {
        if(root == null){
            serializeBuilder.append("$,");
            return null;
        }
        serializeBuilder.append(root.val + ",");
        Serialize(root.left);
        Serialize(root.right);
        return serializeBuilder.toString();
    }

    // 直接使用String的序列化过程
    String Serialize2(TreeNode root) {
        if (root == null) {
            return "$,";
        }
        String s = new String(root.val + ",");
        s += Serialize2(root.left);
        s += Serialize2(root.right);
        return s;
    }
    int index = -1;
    TreeNode Deserialize(String str) {
        // 备注：如果采用本例的序列化，不会产生null串
        if(str == null)
            return null;
        index ++;
        String[] nodes  = str.split(",");
        TreeNode root = null;
        if(!nodes[index].equals("$") && index != nodes.length){
            root = new TreeNode(Integer.parseInt(nodes[index]));
            root.left = Deserialize(str);
            root.right = Deserialize(str);
        }
        return root;
    }
}
