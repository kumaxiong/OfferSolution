package OfferSlution;
/*
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
 */
/* 测试代码
class Test {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(3);
        node3.next = node4;
        ListNode node5 = new ListNode(4);
        node4.next = node5;
        ListNode node6 = new ListNode(4);
        node5.next = node6;
        ListNode node7 = new ListNode(5);
        node6.next = node7;
        ListNode p = new Solution56().deleteDuplication(node1);
        while (p != null){
            System.out.println(p.val);
            p = p.next;
        }
    }
}*/

public class Solution56 {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null)
            return null;
        ListNode pPreNode = null;
        ListNode pNode = pHead;
        while (pNode != null) {
            ListNode pNext = pNode.next;
            boolean needDelete = false;
            if (pNext != null && pNext.val == pNode.val)
                needDelete = true;
            if (!needDelete) {
                pPreNode = pNode;
                pNode = pNode.next;
            } else {
                int val = pNode.val;
                ListNode toBeDeleteNode = pNode;
                while (toBeDeleteNode != null && toBeDeleteNode.val == val) {
                    pNext = toBeDeleteNode.next;
                    //toBeDeleteNode.next = null;
                    //toBeDeleteNode = null;
                    toBeDeleteNode = pNext;
                    if (pPreNode == null)
                        // 如果删除完后是个空链表
                        pHead = pNext;
                    else
                        pPreNode.next = pNext;
                    // 从删除玩重复节点的后一节点开始循环操作
                    pNode = pNext;
                }
            }
        }
        return pHead;
    }
}