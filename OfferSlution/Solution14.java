package OfferSlution;
import Util.ArraryToListNode;
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/

/*
代码鲁棒性，扫描一次获取倒数第k个节点
1.空指针，或者k == 0
2.下移不足k个节点
 */
//class Test{
//    public static void main(String[] args) {
//        ListNode p = ArraryToListNode.ArrayToListNode(new int[]{1,2,3,4,5,6,7,8});
//        p = new Solution14().FindKthToTail(p,1);
//        System.out.println(p.val);
//    }
//}
public class Solution14 {
    public ListNode FindKthToTail(ListNode head, int k) {
        // 鲁棒性1：空指针&参数错误
        if (head == null || k <= 0)
            return null;
        ListNode pAHead = head;
        ListNode pBehind = null;
        for (int i = 1; i < k; i++) {
            if(pAHead.next != null){
                pAHead = pAHead.next;
            }
            else
                return null;
        }
        pBehind = head;
        while (pAHead.next != null){
            pAHead = pAHead.next;
            pBehind = pBehind.next;
        }
        return pBehind;
    }
}
