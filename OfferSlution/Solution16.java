package OfferSlution;


/*
合并两个有序链表
 */
/*
class Test {
    public static void main(String[] args) {
        ListNode p1 = ArraryToListNode.getNode(new int[]{1, 3, 4, 5, 7, 9, 10, 11, 12, 13});
        ListNode p2 = ArraryToListNode.getNode(new int[]{2});
        ListNode p = new Solution16().Merge(p1, p2);
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
    }
}
*/
public class Solution16 {

    // 有返回值类型的递归
    public ListNode Merge(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null)
            return pHead2;
        else if (pHead2 == null)
            return pHead1;

        ListNode pMergedHead = null;
        if (pHead1.val < pHead2.val) {
            pMergedHead = pHead1;
            pMergedHead.next = Merge(pHead1.next, pHead2);
        } else {
            pMergedHead = pHead2;
            pMergedHead.next = Merge(pHead1, pHead2.next);
        }
        return pMergedHead;
    }
}
