package OfferSlution;
/*class Test{
    public static void main(String[] args) {
        ListNode p = ArraryToListNode.getNode(new int[]{1,2});
        p = new Solution15.ReverseList(null);
        if(p != null){
            while (p!= null){
                System.out.print(p.val + " ");
                p = p.next;
            }
        }
        else {
            System.out.println("null");
        }
    }
}*/
public class Solution15 {
    public ListNode ReverseList(ListNode pHead){
        // 鲁棒性，pNode == null 的时候返回空
        // 代码个数为1，2的时候也能正常运作
        ListNode pReverseHead = null;
        ListNode pPre = null;
        ListNode pNode = pHead;
        while (pNode != null){
            // 防止链表断开，现获取下一个节点
            ListNode pNext = pNode.next;
            // 最后一个节点作为返回节点;
            if(pNext == null){
                pReverseHead = pNode;
            }
            pNode.next = pPre;
            pPre = pNode;
            pNode = pNext;
        }
        return pReverseHead;
    }
}
